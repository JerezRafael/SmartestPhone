package es.sidelab.SmartestPhone.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.sidelab.SmartestPhone.repositorios.*;

@Controller
public class WebController {

	@Autowired
	private SmartphoneRepository repositorioSmartphone;
	@Autowired
	private ProcesadorRepository repositorioProcesador;
	@Autowired
	private CamaraRepository repositorioCamara;
	@Autowired
	private NoticiaRepository repositorioNoticia;

	@RequestMapping("/SmartestPhone")
	public String inicio(Model model, HttpServletRequest request) {

		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/buscar/modelo")
	public String buscarSmartphone(@RequestParam String marca, @RequestParam String modelo, Model model,
			HttpServletRequest request) {

		model.addAttribute("smartphones", repositorioSmartphone.findByMarcaAndModelo(marca, modelo));

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/buscar/procesador")
	public String buscarProcesador(@RequestParam long idProcesador, Model model, HttpServletRequest request) {

		model.addAttribute("smartphones", repositorioSmartphone.findByProcesadorIdProcesador(idProcesador));

		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/buscar/camara")
	public String buscarCamara(@RequestParam long idCamara, Model model, HttpServletRequest request) {

		model.addAttribute("smartphones", repositorioSmartphone.findByCamaraIdCamara(idCamara));

		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/añadir/smartphone")
	public String añadirSmartphone(Model model, HttpServletRequest request) {

		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "añadirSmartphone";
	}

	@RequestMapping("/SmartestPhone/añadir/noticia")
	public String añadirNoticia(Model model, HttpServletRequest request) {

		model.addAttribute("smartphones", repositorioSmartphone.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "añadirNoticia";
	}

	@RequestMapping("/SmartestPhone/añadir/camara")
	public String añadirCamara(Model model, HttpServletRequest request) {

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "añadirCamara";
	}

	@RequestMapping("/SmartestPhone/añadir/procesador")
	public String añadirProcesador(Model model, HttpServletRequest request) {

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "añadirProcesador";
	}

	@RequestMapping("/SmartestPhone/detalles")
	public String detalles(@RequestParam long idSmartphone, Model model, HttpServletRequest request) {

		model.addAttribute("smartphone", repositorioSmartphone.findByIdSmartphone(idSmartphone));
		model.addAttribute("noticias",
				repositorioNoticia.findBySmartphonesIdSmartphoneOrderByIdNoticiaDesc(idSmartphone));

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "detalles";
	}

	@RequestMapping("/SmartestPhone/noticias")
	public String noticias(Model model, HttpServletRequest request) {

		model.addAttribute("noticias", repositorioNoticia.findAllByOrderByIdNoticiaDesc());

		model.addAttribute("smartphones", repositorioSmartphone.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "noticias";
	}

	@RequestMapping("/SmartestPhone/noticias/buscar")
	public String añadirNoticia(@RequestParam long idSmartphone, Model model, HttpServletRequest request) {

		model.addAttribute("smartphone", repositorioSmartphone.findByIdSmartphone(idSmartphone));
		model.addAttribute("noticias",
				repositorioNoticia.findBySmartphonesIdSmartphoneOrderByIdNoticiaDesc(idSmartphone));
		model.addAttribute("smartphones", repositorioSmartphone.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "noticias";
	}

	@RequestMapping("/SmartestPhone/gestion")
	public String gestion(Model model, HttpServletRequest request) {

		model.addAttribute("smartphones", repositorioSmartphone.findAll());
		model.addAttribute("camaras", repositorioCamara.findBySmartphonesIsNull());
		model.addAttribute("procesadores", repositorioProcesador.findBySmartphonesIsNull());
		model.addAttribute("noticias", repositorioNoticia.findAllByOrderByIdNoticiaDesc());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "gestion";
	}

	@GetMapping("/SmartestPhone/acceder")
	public String acceder(Model model, HttpServletRequest request) {

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "acceder";
	}

	@GetMapping("/SmartestPhone/registrarse")
	public String registrarse(Model model, HttpServletRequest request) {

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "registrarse";
	}

	@GetMapping("/SmartestPhone/erroracceder")
	public String errorAcceder(Model model, HttpServletRequest request) {

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "erroracceder";
	}

	@GetMapping("/SmartestPhone/salir")
	public String salir(Model model, HttpServletRequest request) {

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "salir";
	}
}