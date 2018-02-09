package es.sidelab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Camara {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCamara;
	private String marca;
	private String modelo;
	private Integer megapixeles;
	private Integer selfie;
	private Boolean dual;

	public Camara() {

	}

	public Camara(String marca, String modelo, Integer megapixeles, Integer selfie, Boolean dual) {
		this.marca = marca;
		this.modelo = modelo;
		this.megapixeles = megapixeles;
		this.selfie = selfie;
		this.dual = dual;
	}

	public long getIdCamara() {
		return idCamara;
	}
	
	public void setIdCamara(long idCamara) {
		this.idCamara = idCamara;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getMegapixeles() {
		return megapixeles;
	}

	public void setMegapixeles(Integer megapixeles) {
		this.megapixeles = megapixeles;
	}
	
	public Integer getSelfie() {
		return selfie;
	}

	public void setSelfie(Integer selfie) {
		this.selfie = selfie;
	}
	
	public Boolean getDual() {
		return dual;
	}

	public void setDual(Boolean dual) {
		this.dual = dual;
	}

	@Override
	public String toString() {
		return "Camara [marca=" + marca + ", modelo=" + modelo + ", megapixeles=" + megapixeles + ", selfie=" + selfie + ", dual=" + dual + "]";
	}

}
