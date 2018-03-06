package es.sidelab.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.clases.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

	List<Noticia> findBySmartphonesIdSmartphoneOrderByIdNoticiaDesc(long idSmartphone);
	
	List<Noticia> findAllByOrderByIdNoticiaDesc();

	Noticia findByIdNoticia(long idNoticia);
	
}
