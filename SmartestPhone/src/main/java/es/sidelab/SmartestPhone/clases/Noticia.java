package es.sidelab.SmartestPhone.clases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idNoticia;
	private String titulo;
	private String url;
	@ManyToMany
	@JsonIgnore
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