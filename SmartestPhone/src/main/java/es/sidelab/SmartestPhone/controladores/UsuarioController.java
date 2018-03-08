package es.sidelab.SmartestPhone.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.sidelab.SmartestPhone.clases.Usuario;
import es.sidelab.SmartestPhone.repositorios.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositorioUsuario;

	@PostMapping("/SmartestPhone/registrarse/solicitud")
	public String registrarUsuario(@RequestParam String nombreusuario, @RequestParam String contraseña,
			@RequestParam String mail, Model model, HttpServletRequest request) {

		Usuario user = repositorioUsuario.findByNombre(nombreusuario);

		if (user != null) {
			model.addAttribute("usuario", user.getNombre());
			return "registrarse";
		} else {
			Usuario usuario = new Usuario(nombreusuario, contraseña, mail, "ROLE_USER");
			repositorioUsuario.save(usuario);
		}

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "acceder";
	}
}
