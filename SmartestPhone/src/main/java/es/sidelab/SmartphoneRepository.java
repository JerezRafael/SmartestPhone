package es.sidelab;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
	
	Smartphone findByMarcaAndModelo(String marca, String modelo);
	
	Smartphone findByidSmartPhone(long idSmartPhone);
	
}
