package es.sidelab;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
	
	Noticia findByidNoticia(long idNoticia);
	
}
