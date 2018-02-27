package es.sidelab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CamaraRepository extends JpaRepository<Camara, Long>{

	Camara findByIdCamara(long id);
	
	List<Camara> findBySmartphonesIsNull();
	
	List<Camara> findBySmartphonesIsNotNull();
	
}
