package es.sidelab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
	
	List<Smartphone> findByMarcaAndModelo(String marca, String modelo);
	
	Smartphone findByidSmartPhone(long idSmartPhone);
	
	List<Smartphone> findByCamaraMarca(String marcacamara);
	
	List<Smartphone> findByProcesadorMarcaAndProcesadorModelo(String marcaprocesador, String modeloprocesador);
	
}
