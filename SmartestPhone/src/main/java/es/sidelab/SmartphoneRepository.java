package es.sidelab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
	
	List<Smartphone> findByMarcaAndModelo(String marca, String modelo);
	
	Smartphone findByIdSmartphone(long idSmartPhone);
	
	List<Smartphone> findByCamaraIdCamara(long idCamara);
	
	List<Smartphone> findByProcesadorIdProcesador(long idProcesador);
	
}
