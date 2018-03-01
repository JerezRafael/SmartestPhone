package es.sidelab;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SmartphoneController {

	@Autowired
	private SmartphoneRepository repositorioSmartphone;
	@Autowired
	private ProcesadorRepository repositorioProcesador;
	@Autowired
	private CamaraRepository repositorioCamara;
	@Autowired
	private NoticiaRepository repositorioNoticia;

	@PostMapping("/SmartestPhone/añadir/solicitud")
	public String añadirSmartphone(@RequestParam String marca, @RequestParam String modelo, @RequestParam String color,
			@RequestParam Integer bateria, @RequestParam Integer almacenamiento, @RequestParam Integer ram,
			@RequestParam Integer peso, @RequestParam String SO, @RequestParam Integer versionSO,
			Dimensiones dimensiones, Pantalla pantalla, Camara camaraSeleccionada, Procesador procesadorSeleccionado,
			Model model, HttpServletRequest request) {

		Smartphone smartphone = new Smartphone(marca, modelo, color, bateria, almacenamiento, ram, peso, SO, versionSO,
				camaraSeleccionada, dimensiones, pantalla, procesadorSeleccionado);

		repositorioSmartphone.save(smartphone);

		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "añadirSmartphone";
	}

	@RequestMapping("/SmartestPhone/modificar")
	public String greetingModificar(@RequestParam long id, Model model, HttpServletRequest request) {

		model.addAttribute("smartphone", repositorioSmartphone.findByIdSmartphone(id));

		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "modificar";
	}

	@PostMapping("/SmartestPhone/modificar/solicitud")
	public String modificarSmartphone(@RequestParam long idSmartphone, @RequestParam String marca,
			@RequestParam String modelo, @RequestParam String color, @RequestParam Integer bateria,
			@RequestParam Integer almacenamiento, @RequestParam Integer ram, @RequestParam Integer peso,
			@RequestParam String SO, @RequestParam Integer versionSO, @RequestParam long idCamara,
			@RequestParam long idProcesador, Dimensiones dimensiones, Pantalla pantalla, Model model,
			HttpServletRequest request) {

		Smartphone smartphone = repositorioSmartphone.findByIdSmartphone(idSmartphone);
		Procesador procesador = repositorioProcesador.findByIdProcesador(idProcesador);
		Camara camara = repositorioCamara.findByIdCamara(idCamara);

		smartphone.setMarca(marca);
		smartphone.setModelo(modelo);
		smartphone.setColor(color);
		smartphone.setBateria(bateria);
		smartphone.setAlmacenamiento(almacenamiento);
		smartphone.setRam(ram);
		smartphone.setPeso(peso);
		smartphone.setSO(SO);
		smartphone.setVersionSO(versionSO);
		smartphone.setPantalla(pantalla);
		smartphone.setProcesador(procesador);
		smartphone.setCamara(camara);
		smartphone.setDimensiones(dimensiones);
		repositorioSmartphone.save(smartphone);

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "modificar";
	}

	@PostMapping("/SmartestPhone/gestion/smartphone")
	public String borrarSmartphone(@RequestParam long idSmartphone, Model model, HttpServletRequest request) {

		Smartphone smartphone = repositorioSmartphone.findByIdSmartphone(idSmartphone);

		repositorioSmartphone.delete(smartphone);

		model.addAttribute("smartphones", repositorioSmartphone.findAll());
		model.addAttribute("camaras", repositorioCamara.findBySmartphonesIsNull());
		model.addAttribute("procesadores", repositorioProcesador.findBySmartphonesIsNull());
		model.addAttribute("noticias", repositorioNoticia.findAllByOrderByIdNoticiaDesc());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "gestion";
	}
}
