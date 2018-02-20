package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SmartphoneController {

	@Autowired
	private SmartphoneRepository repositorioSmartPhone;

	@RequestMapping("/SmartestPhone/buscar")
	public String buscar(@RequestParam String marca, @RequestParam String modelo, Model model) {

		model.addAttribute("smartphones", repositorioSmartPhone.findByMarcaAndModelo(marca, modelo));

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/añadir/solicitud")
	public String añadirSmartphone(@RequestParam String marca, @RequestParam String modelo, @RequestParam String color,
			@RequestParam Integer bateria, @RequestParam Integer almacenamiento, @RequestParam Integer ram,
			@RequestParam Integer peso, SO so, Camara camara, Dimensiones dimensiones, Pantalla pantalla, 
			Procesador procesador, Model model) {

		Smartphone smartphone = new Smartphone(marca, modelo, color, bateria, almacenamiento, ram, peso, so, camara,
				dimensiones, pantalla, procesador);

		repositorioSmartPhone.save(smartphone);

		return "añadir";
	}

	@RequestMapping("/SmartestPhone/detalles")
	public String greetingDetalles(@RequestParam long id, Model model) {

		model.addAttribute("smartphone", repositorioSmartPhone.findByidSmartPhone(id));

		return "detalles";
	}

	@RequestMapping("/SmartestPhone/modificar")
	public String greetingModificar(@RequestParam long id, Model model) {

		model.addAttribute("smartphone", repositorioSmartPhone.findByidSmartPhone(id));

		return "modificar";
	}

	@RequestMapping("/SmartestPhone/modificar/solicitud")
	public String modificarSmartphone(@RequestParam long id, @RequestParam String marca, @RequestParam String modelo,
			@RequestParam String color, @RequestParam Integer bateria, @RequestParam Integer almacenamiento,
			@RequestParam Integer ram, @RequestParam Integer peso, @RequestParam String nombre,
			@RequestParam Integer version, @RequestParam String marcacamara, @RequestParam String modelocamara,
			@RequestParam Integer megapixeles, @RequestParam Integer selfie, @RequestParam String tipo,
			@RequestParam Double pulgadas, @RequestParam Integer resolucion1, @RequestParam Integer resolucion2,
			@RequestParam String marcacpu, @RequestParam String modelocpu, @RequestParam Double ghz,
			@RequestParam Integer nucleos, @RequestParam Integer ancho, @RequestParam Integer alto,
			@RequestParam Integer largo, Model model) {

		Smartphone smartphone = repositorioSmartPhone.findByidSmartPhone(id);

		SO so = new SO(nombre, version);

		Pantalla pantalla = new Pantalla(tipo, resolucion1, resolucion2, pulgadas);

		Procesador procesador = new Procesador(marcacpu, modelocpu, ghz, nucleos);

		Camara camara = new Camara(marcacamara, modelocamara, megapixeles, selfie);

		Dimensiones dimensiones = new Dimensiones(ancho, alto, largo);

		smartphone.setMarca(marca);
		smartphone.setModelo(modelo);
		smartphone.setColor(color);
		smartphone.setBateria(bateria);
		smartphone.setAlmacenamiento(almacenamiento);
		smartphone.setRam(ram);
		smartphone.setPeso(peso);
		smartphone.setSO(so);
		smartphone.setPantalla(pantalla);
		smartphone.setProcesador(procesador);
		smartphone.setCamara(camara);
		smartphone.setDimensiones(dimensiones);
		repositorioSmartPhone.save(smartphone);

		return "modificar";
	}
}
