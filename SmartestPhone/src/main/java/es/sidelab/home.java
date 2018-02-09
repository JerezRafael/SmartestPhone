package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class home {
	
	@Autowired
	private SmartPhoneRepository repositorioSmartPhone;
	
	@RequestMapping("/SmartestPhone")
	public String greeting(@RequestParam String arg1, @RequestParam String arg2, @RequestParam String arg3, 
			@RequestParam Integer arg4, @RequestParam Integer arg5, @RequestParam Integer arg6, 
			@RequestParam Integer arg7, @RequestParam String arg8, @RequestParam Double arg9, 
			@RequestParam String arg10, @RequestParam Double arg11, @RequestParam Integer arg12, 
			@RequestParam Integer arg13, @RequestParam String arg14, @RequestParam String arg15, 
			@RequestParam Double arg16, @RequestParam Integer arg17, @RequestParam String arg18, 
			@RequestParam String arg19, @RequestParam Double arg20, @RequestParam Double arg21, 
			@RequestParam Boolean arg22, @RequestParam Double arg23, @RequestParam Double arg24, 
			@RequestParam Double arg25, @RequestParam String accion, Model model) {

		if (accion.equals("Añadir")) {
			
				SO so = new SO();
				so.setNombre(arg8);
				so.setVersion(arg9);
				
				Pantalla pantalla = new Pantalla();
				pantalla.setTipo(arg10);
				pantalla.setPulgadas(arg11);
				pantalla.setResolucion(arg12, arg13);
				
				Procesador procesador = new Procesador();
				procesador.setMarca(arg14);
				procesador.setModelo(arg15);
				procesador.setGHz(arg16);
				procesador.setNucleos(arg17);	
				
				Camara camara = new Camara();
				camara.setMarca(arg18);
				camara.setModelo(arg19);
				camara.setMegapixeles(arg20);
				camara.setSelfie(arg21);
				camara.setDual(arg22);
				
				Dimensiones dimensiones = new Dimensiones();
				dimensiones.setAncho(arg23);
				dimensiones.setAlto(arg24);
				dimensiones.setLargo(arg25);
				
				SmartPhone smartphone = new SmartPhone();
				smartphone.setMarca(arg1);
				smartphone.setModelo(arg2);
				smartphone.setColor(arg3);
				smartphone.setBateria(arg4);
				smartphone.setAlmacenamiento(arg5);
				smartphone.setRam(arg6);
				smartphone.setPeso(arg7);
				smartphone.setSO(so);
				smartphone.setPantalla(pantalla);
				smartphone.setProcesador(procesador);
				smartphone.setCamara(camara);
				smartphone.setDimensiones(dimensiones);
				repositorioSmartPhone.save(smartphone);
		}
		else if (accion.equals("Buscar")) {
				model.addAttribute("smartphone", repositorioSmartPhone.findByMarcaAndModelo(arg1, arg2));
		}
			
		return "home";
	}

}