package es.sidelab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcesadorRepository extends JpaRepository<Procesador, Long>{

	List<Smartphone> findSmartphonesByMarcaAndModelo(String marca, String modelo);
	
	List<Smartphone> findSmartphonesByidProcesador(long idProcesador);

	Procesador findByidProcesador(long id);
	
}
