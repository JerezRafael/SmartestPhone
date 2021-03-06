package es.sidelab.SmartestPhone.repositorios;

import org.springframework.data.repository.CrudRepository;

import es.sidelab.SmartestPhone.clases.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findByNombre(String nombre);

}