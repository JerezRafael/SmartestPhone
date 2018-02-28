package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@PostMapping("/SmartestPhone/añadir/noticia/solicitud")
	public String añadirNoticia(@RequestParam String titulo, @RequestParam String url,
			@RequestParam long[] idSmartphones, Model model) {

		Noticia noticia = new Noticia(titulo, url);

		for (int i = 0; i < idSmartphones.length; i++) {
			noticia.setSmartphones(repositorioSmartphone.findByIdSmartphone(idSmartphones[i]));
		}

		repositorioNoticia.save(noticia);
		model.addAttribute("smartphones", repositorioSmartphone.findAll());

		return "añadirNoticia";
	}

	@PostMapping("/SmartestPhone/gestion/noticia")
	public String borrarNoticia(@RequestParam long idNoticia, Model model) {

		Noticia noticia = repositorioNoticia.findByIdNoticia(idNoticia);

		repositorioNoticia.delete(noticia);
		
		model.addAttribute("smartphones", repositorioSmartphone.findAll());
		model.addAttribute("camaras", repositorioCamara.findBySmartphonesIsNull());
		model.addAttribute("procesadores", repositorioProcesador.findBySmartphonesIsNull());
		model.addAttribute("noticias", repositorioNoticia.findAllByOrderByIdNoticiaDesc());

		return "gestion";
	}
}