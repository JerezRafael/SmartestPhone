package es.sidelab.SmartestPhone.controladores;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import es.sidelab.SmartestPhone.clases.Noticia;
import es.sidelab.SmartestPhone.clases.Usuario;
import es.sidelab.SmartestPhone.repositorios.*;

@Controller
public class NoticiaController {

	@Autowired
	private SmartphoneRepository repositorioSmartphone;
	@Autowired
	private ProcesadorRepository repositorioProcesador;
	@Autowired
	private CamaraRepository repositorioCamara;
	@Autowired
	private NoticiaRepository repositorioNoticia;
	@Autowired
	private UsuarioRepository repositorioUsuario;

	@PostMapping("/SmartestPhone/añadir/noticia/solicitud")
	public String añadirNoticia(@RequestParam String titulo, @RequestParam String url,
			@RequestParam long[] idSmartphones, Model model, HttpServletRequest request) {

		Noticia noticia = new Noticia(titulo, url);

		for (int i = 0; i < idSmartphones.length; i++) {
			noticia.setSmartphones(repositorioSmartphone.findByIdSmartphone(idSmartphones[i]));
		}

		repositorioNoticia.save(noticia);
		
		RestTemplate restTemplateUsuario = new RestTemplate();

		restTemplateUsuario.delete("http://localhost:9091/mail/usuario/init");
		String urlRESTUsuarios = "http://localhost:9091/mail/usuario";
		
		for (Usuario usuario : repositorioUsuario.findAll()) {	// solucion que podria estar bien
			restTemplateUsuario.postForObject(urlRESTUsuarios, usuario, Usuario.class);
		}
		
		restTemplateUsuario.postForObject("http://localhost:9091/mail/usuario/init", repositorioUsuario.findAll(), List<Usuario>.class);	// como deberia ser

		RestTemplate restTemplateNoticia = new RestTemplate();

		String urlREST="http://localhost:9091/mail/noticia";
		restTemplateNoticia.postForObject(urlREST, noticia, Noticia.class);
		
		model.addAttribute("smartphones", repositorioSmartphone.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "añadirNoticia";
	}

	@PostMapping("/SmartestPhone/gestion/noticia")
	public String borrarNoticia(@RequestParam long idNoticia, Model model, HttpServletRequest request) {

		Noticia noticia = repositorioNoticia.findByIdNoticia(idNoticia);

		repositorioNoticia.delete(noticia);
		
		model.addAttribute("smartphones", repositorioSmartphone.findAll());
		model.addAttribute("camaras", repositorioCamara.findBySmartphonesIsNull());
		model.addAttribute("procesadores", repositorioProcesador.findBySmartphonesIsNull());
		model.addAttribute("noticias", repositorioNoticia.findAllByOrderByIdNoticiaDesc());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "gestion";
	}
}