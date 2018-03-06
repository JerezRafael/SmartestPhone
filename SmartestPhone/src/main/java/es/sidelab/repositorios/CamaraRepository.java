package es.sidelab.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.clases.Camara;

public interface CamaraRepository extends JpaRepository<Camara, Long>{

	Camara findByIdCamara(long id);
	
	List<Camara> findBySmartphonesIsNull();
	
}
