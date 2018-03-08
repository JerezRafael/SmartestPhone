package es.sidelab.ServidorMail.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.ServidorMail.clases.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

	Noticia findByIdNoticia(long idNoticia);

}
