package es.sidelab.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.clases.Procesador;

public interface ProcesadorRepository extends JpaRepository<Procesador, Long>{

	Procesador findByIdProcesador(long id);
	
	List<Procesador> findBySmartphonesIsNull();
	
}
