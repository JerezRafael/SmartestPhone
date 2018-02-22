package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoticiaController {

	@Autowired
	private NoticiaRepository repositorioNoticia;
	@Autowired
	private SmartphoneRepository repositorioSmartphone;

	@RequestMapping("/SmartestPhone/noticias")
	public String greetingNoticias(Model model) {

		model.addAttribute("noticias", repositorioNoticia.findAllByOrderByIdNoticiaDesc());
		
		model.addAttribute("smartphones", repositorioSmartphone.findAll());

		return "noticias";
	}

	@PostMapping("/SmartestPhone/añadir/noticia/solicitud")
	public String añadirNoticia(@RequestParam String titulo, @RequestParam String url, @RequestParam long[] idSmartphones, Model model) {

		Noticia noticia = new Noticia(titulo, url);
		
		for (int i = 0; i < idSmartphones.length; i++) {
			noticia.setSmartphones(repositorioSmartphone.findByIdSmartphone(idSmartphones[i]));
		}

		repositorioNoticia.save(noticia);

		return "añadirNoticia";
	}

	@RequestMapping("/SmartestPhone/noticias/buscar")
	public String añadirNoticia(@RequestParam long idSmartphone, Model model) {
		
		model.addAttribute("noticias", repositorioNoticia.findBySmartphonesIdSmartphone(idSmartphone));

		return "noticias";
	}
}