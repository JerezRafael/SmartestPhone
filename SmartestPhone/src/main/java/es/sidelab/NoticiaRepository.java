package es.sidelab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

	List<Noticia> findBySmartphonesIdSmartphone(long idSmartphone);
	
	List<Noticia> findAllByOrderByIdNoticiaDesc();
	
}
