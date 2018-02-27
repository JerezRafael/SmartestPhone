package es.sidelab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcesadorRepository extends JpaRepository<Procesador, Long>{

	Procesador findByIdProcesador(long id);
	
	List<Procesador> findBySmartphonesIsNull();
	
	List<Procesador> findBySmartphonesIsNotNull();
	
}
