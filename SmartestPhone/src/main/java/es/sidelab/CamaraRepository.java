package es.sidelab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CamaraRepository extends JpaRepository<Camara, Long>{
	
	List<Smartphone> findSmartphonesByidCamara(long idCamara);

	Camara findByidCamara(long id);
	
}