package es.sidelab.SmartestPhone.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.SmartestPhone.clases.Camara;

public interface CamaraRepository extends JpaRepository<Camara, Long> {

	Camara findByIdCamara(long id);

	List<Camara> findBySmartphonesIsNull();

}
