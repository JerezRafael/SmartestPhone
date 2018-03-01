package es.sidelab;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UsuarioRepository repositorioUsuario;

    @PostConstruct
    private void initDatabase() {
    	
    	repositorioUsuario.save(new Usuario("smartphone", "smart", "ROLE_USER"));
    	repositorioUsuario.save(new Usuario("smartestphone", "smartest", "ROLE_USER", "ROLE_ADMIN"));
    }

}