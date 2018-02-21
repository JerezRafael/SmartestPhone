package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProcesadorController {

	@Autowired
	private ProcesadorRepository repositorioProcesador;

	@RequestMapping("/SmartestPhone/buscar/procesador")
	public String buscarProcesador(@RequestParam long idProcesador, Model model) {

		model.addAttribute("smartphones", repositorioProcesador.findSmartphonesByidProcesador(idProcesador));

		return "inicio";
	}
	
//	@RequestMapping("/SmartestPhone")												// deberia estar en webcontroller
//	public String greetingInicio(Model model) {
//		
//		model.addAttribute("procesadores", repositorioProcesador.findAll());
//
//		return "inicio";
//	}

	@RequestMapping("/SmartestPhone/añadir/procesador/solicitud")
	public String añadirSmartphone(@RequestParam String marca, @RequestParam String modelo, @RequestParam Double ghz, @RequestParam Integer nucleos, Model model) {

		Procesador procesador = new Procesador(marca, modelo, ghz, nucleos);

		repositorioProcesador.save(procesador);

		return "añadirProcesador";
	}
}
