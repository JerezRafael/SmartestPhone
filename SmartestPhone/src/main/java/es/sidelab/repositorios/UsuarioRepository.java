package es.sidelab.repositorios;

import org.springframework.data.repository.CrudRepository;

import es.sidelab.clases.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByNombre(String nombre);

}