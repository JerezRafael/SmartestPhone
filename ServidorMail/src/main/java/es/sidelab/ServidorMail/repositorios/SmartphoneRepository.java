package es.sidelab.ServidorMail.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.ServidorMail.clases.Smartphone;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

	Smartphone findByIdSmartphone(long idSmartphone);

}
