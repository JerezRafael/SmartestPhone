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
<<<<<<< Upstream, based on origin/master
	
=======
>>>>>>> d07d8d3 Página de detalles creada y correcciones

	public Camara() {

	}

	public Camara(String marca, String modelo, Integer megapixeles, Integer selfie) {
		this.marca = marca;
		this.modelo = modelo;
		this.megapixeles = megapixeles;
		this.selfie = selfie;
<<<<<<< Upstream, based on origin/master
		
=======
>>>>>>> d07d8d3 Página de detalles creada y correcciones
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
<<<<<<< Upstream, based on origin/master
	

=======
>>>>>>> d07d8d3 Página de detalles creada y correcciones

	@Override
	public String toString() {
<<<<<<< Upstream, based on origin/master
		return "Camara [marca=" + marca + ", modelo=" + modelo + ", megapixeles=" + megapixeles + ", selfie=" + selfie  + "]";
=======
		return "Camara [marca=" + marca + ", modelo=" + modelo + ", megapixeles=" + megapixeles + ", selfie=" + selfie + "]";
>>>>>>> d07d8d3 Página de detalles creada y correcciones
	}

}
