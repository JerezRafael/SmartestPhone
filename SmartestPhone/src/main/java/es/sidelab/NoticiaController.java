package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoticiaController {

	@Autowired
	private NoticiaRepository repositorioNoticia;

	@RequestMapping("/SmartestPhone/noticias")
	public String greetingNoticias(Model model) {

		model.addAttribute("noticia", repositorioNoticia.findByidNoticia(1));

		return "noticias";
	}

	@RequestMapping("/SmartestPhone/noticias/añadir")
	public String añadirNoticia(@RequestParam String titulo, @RequestParam String url, Model model) {
		
		Noticia noticia = new Noticia(titulo, url);

		repositorioNoticia.save(noticia);
		
		model.addAttribute("noticia", repositorioNoticia.findByidNoticia(1));

		return "noticias";
	}
}