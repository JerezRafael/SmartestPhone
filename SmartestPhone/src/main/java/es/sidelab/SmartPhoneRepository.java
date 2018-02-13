package es.sidelab;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartPhoneRepository extends JpaRepository<SmartPhone, Long> {
	
	SmartPhone findByMarcaAndModelo(String arg1, String arg2);
	
	SmartPhone findByidSmartPhone(long idSmartPhone);
	
}
