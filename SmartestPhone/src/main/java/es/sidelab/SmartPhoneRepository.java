package es.sidelab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartPhoneRepository extends JpaRepository<SmartPhone, Long> {
	
	SmartPhone findByMarcaAndModelo(String arg1, String arg2);
	
}
