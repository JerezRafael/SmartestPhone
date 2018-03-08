package es.sidelab.ServidorMail.repositorios;

import org.springframework.data.repository.CrudRepository;

import es.sidelab.ServidorMail.clases.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findByNombre(String nombre);

}