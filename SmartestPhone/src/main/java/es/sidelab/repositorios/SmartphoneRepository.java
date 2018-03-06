package es.sidelab.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.clases.Smartphone;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
	
	List<Smartphone> findByMarcaAndModelo(String marca, String modelo);
	
	Smartphone findByIdSmartphone(long idSmartPhone);
	
	List<Smartphone> findByCamaraIdCamara(long idCamara);
	
	List<Smartphone> findByProcesadorIdProcesador(long idProcesador);
	
}