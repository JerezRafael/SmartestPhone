package es.sidelab.configuracion;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.sidelab.clases.Usuario;
import es.sidelab.repositorios.UsuarioRepository;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UsuarioRepository repositorioUsuario;

    @PostConstruct
    private void initDatabase() {
    	
    	Usuario user1 = repositorioUsuario.findByNombre("smartphone");
    	Usuario user2 = repositorioUsuario.findByNombre("smartestphone");
    	
    	if (user1 == null && user2 == null) {
	    	repositorioUsuario.save(new Usuario("smartphone", "smart", "ROLE_USER"));
	    	repositorioUsuario.save(new Usuario("smartestphone", "smartest", "ROLE_USER", "ROLE_ADMIN"));
    	}
    }

}