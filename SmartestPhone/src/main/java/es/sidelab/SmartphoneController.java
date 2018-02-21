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
	@Autowired
	private ProcesadorRepository repositorioProcesador;
	@Autowired
	private CamaraRepository repositorioCamara;

	@RequestMapping("/SmartestPhone/buscar/modelo")
	public String buscarSmartphone(@RequestParam String marca, @RequestParam String modelo, Model model) {

		model.addAttribute("smartphones", repositorioSmartPhone.findByMarcaAndModelo(marca, modelo));

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/añadir/smartphone/solicitud")
	public String añadirSmartphone(@RequestParam String marca, @RequestParam String modelo, @RequestParam String color,
			@RequestParam Integer bateria, @RequestParam Integer almacenamiento, @RequestParam Integer ram,
			@RequestParam Integer peso, @RequestParam String SO, @RequestParam Integer versionSO, Dimensiones dimensiones,
			Pantalla pantalla, long idCamara, long idProcesador, Model model) {

		Procesador procesador = repositorioProcesador.findByIdProcesador(idProcesador);
		Camara camara = repositorioCamara.findByIdCamara(idCamara);
		
		Smartphone smartphone = new Smartphone(marca, modelo, color, bateria, almacenamiento, ram, peso, SO, versionSO,
				camara, dimensiones, pantalla, procesador);

		repositorioSmartPhone.save(smartphone);

		return "añadirSmartphone";
	}

	@RequestMapping("/SmartestPhone/detalles")
	public String greetingDetalles(@RequestParam long id, Model model) {

		model.addAttribute("smartphone", repositorioSmartPhone.findByIdSmartphone(id));

		return "detalles";
	}

	@RequestMapping("/SmartestPhone/modificar")
	public String greetingModificar(@RequestParam long id, Model model) {

		model.addAttribute("smartphone", repositorioSmartPhone.findByIdSmartphone(id));

		return "modificar";
	}

	@RequestMapping("/SmartestPhone/modificar/solicitud")
	public String modificarSmartphone(@RequestParam long id, @RequestParam String marca, @RequestParam String modelo,
			@RequestParam String color, @RequestParam Integer bateria, @RequestParam Integer almacenamiento,
			@RequestParam Integer ram, @RequestParam Integer peso, @RequestParam String SO, @RequestParam Integer versionSO, long idCamara,
			Dimensiones dimensiones, Pantalla pantalla, long idProcesador, Model model) {

		Smartphone smartphone = repositorioSmartPhone.findByIdSmartphone(id);
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
		repositorioSmartPhone.save(smartphone);

		return "modificar";
	}
}
