package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class añadir {

	@Autowired
	private SmartPhoneRepository repositorioSmartPhone;

	@RequestMapping("/SmartestPhone/añadir")
	public String greeting() {

		return "añadir";
	}

	@RequestMapping("/SmartestPhone/añadir/solicitud")
	public String añadirSmartphone(@RequestParam String marca, @RequestParam String modelo, @RequestParam String color,
			@RequestParam Integer bateria, @RequestParam Integer almacenamiento, @RequestParam Integer ram,
			@RequestParam Integer peso, @RequestParam String nombre, @RequestParam Double version,
			@RequestParam String marcacamara, @RequestParam String modelocamara, @RequestParam Integer megapixeles,
			@RequestParam Integer selfie, @RequestParam String tipo,
			@RequestParam Double pulgadas, @RequestParam Integer resolucion1, @RequestParam Integer resolucion2,
			@RequestParam String marcacpu, @RequestParam String modelocpu, @RequestParam Double ghz,
			@RequestParam Integer nucleos, @RequestParam Double ancho, @RequestParam Double alto,
			@RequestParam Double largo, @RequestParam String accion, Model model) {

		if (accion.equals("Añadir")) {

			 SO so = new SO();
			 so.setNombre(nombre);
			 so.setVersion(version);
			
			 Pantalla pantalla = new Pantalla();
			 pantalla.setTipo(tipo);
			 pantalla.setPulgadas(pulgadas);
			 pantalla.setResolucion(resolucion1, resolucion2);
			
			 Procesador procesador = new Procesador();
			 procesador.setMarca(marcacpu);
			 procesador.setModelo(modelocpu);
			 procesador.setGHz(ghz);
			 procesador.setNucleos(nucleos);
			
			 Camara camara = new Camara();
			 camara.setMarca(marcacamara);
			 camara.setModelo(modelocamara);
			 camara.setMegapixeles(megapixeles);
			 camara.setSelfie(selfie);
			 
			
			 Dimensiones dimensiones = new Dimensiones();
			 dimensiones.setAncho(ancho);
			 dimensiones.setAlto(alto);
			 dimensiones.setLargo(largo);
			
			 SmartPhone smartphone = new SmartPhone();
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
		}

		return "añadir";
	}

}