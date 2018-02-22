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

	@RequestMapping("/SmartestPhone/añadir/procesador/solicitud")
	public String añadirSmartphone(@RequestParam String marcap, @RequestParam String modelop, @RequestParam Double ghz, @RequestParam Integer nucleos, Model model) {

		Procesador procesador = new Procesador(marcap, modelop, ghz, nucleos);

		repositorioProcesador.save(procesador);

		return "añadirProcesador";
	}
}
