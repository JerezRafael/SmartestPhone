package es.sidelab.ServidorMail.clases;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Camara {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCamara;
	private String marcac;
	private String modeloc;
	private Integer megapixeles;
	@OneToMany(mappedBy = "camara")
	@JsonIgnore
	private List<Smartphone> smartphones;

	public Camara() {

	}

	public Camara(String marcac, String modeloc, Integer megapixeles) {
		this.marcac = marcac;
		this.modeloc = modeloc;
		this.megapixeles = megapixeles;
	}

	public long getIdCamara() {
		return idCamara;
	}

	public void setIdCamara(long idCamara) {
		this.idCamara = idCamara;
	}

	public String getMarcac() {
		return marcac;
	}

	public void setMarcac(String marca) {
		this.marcac = marca;
	}

	public String getModeloc() {
		return modeloc;
	}

	public void setModeloc(String modeloc) {
		this.modeloc = modeloc;
	}

	public Integer getMegapixeles() {
		return megapixeles;
	}

	public void setMegapixeles(Integer megapixeles) {
		this.megapixeles = megapixeles;
	}

	public List<Smartphone> getSmartphones() {
		return smartphones;
	}

	public void setSmartphones(Smartphone smartphone) {
		smartphones.add(smartphone);
	}

	@Override
	public String toString() {
		return "Camara [marca=" + marcac + ", modelo=" + modeloc + ", megapixeles=" + megapixeles + "]";
	}

}
