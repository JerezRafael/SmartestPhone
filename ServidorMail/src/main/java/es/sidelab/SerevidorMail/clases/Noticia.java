package es.sidelab.SerevidorMail.clases;

import java.util.ArrayList;
import java.util.List;

public class Noticia {
	private long idNoticia;
	private String titulo;
	private String url;
	private List<Smartphone> smartphones = new ArrayList<Smartphone>();

	public Noticia() {

	}

	public Noticia(String titulo, String url) {
		this.titulo = titulo;
		this.url = url;
	}

	public long getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(long idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Smartphone> getSmartphones() {
		return smartphones;
	}

	public void setSmartphones(Smartphone smartphone) {
		smartphones.add(smartphone);
	}

	@Override
	public String toString() {
		return "Noticia: " + titulo + ". \b" + url;
	}
}