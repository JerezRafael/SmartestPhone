package es.sidelab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Noticia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idNoticia;
	private String titulo;
	private String url;
	
	public Noticia() {
		
	}

	public Noticia(String titulo, String url) {
		this.titulo = titulo;
		this.url = url;
	}

	@Override
	public String toString() {
		return "Noticia: " + titulo + ". \b" + url;
	}
}