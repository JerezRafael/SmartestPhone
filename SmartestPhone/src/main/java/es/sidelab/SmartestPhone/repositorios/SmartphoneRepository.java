package es.sidelab.SmartestPhone.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.SmartestPhone.clases.Smartphone;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

	List<Smartphone> findByMarcaAndModelo(String marca, String modelo);

	Smartphone findByIdSmartphone(long idSmartphone);

	List<Smartphone> findByCamaraIdCamara(long idCamara);

	List<Smartphone> findByProcesadorIdProcesador(long idProcesador);

}
