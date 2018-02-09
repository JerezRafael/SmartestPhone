package es.sidelab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dimensiones {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDimensiones;
	private Double ancho;
	private Double alto;
	private Double largo;

	public Dimensiones() {

	}

	public Dimensiones(Double ancho, Double alto, Double largo) {
		this.ancho = ancho;
		this.alto = alto;
		this.largo = largo;
	}

	public long getIdDimensiones() {
		return idDimensiones;
	}
	
	public void setIdDimensiones(long idDimensiones) {
		this.idDimensiones = idDimensiones;
	}
	
	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Double getAlto() {
		return alto;
	}

	public void setAlto(Double alto) {
		this.alto = alto;
	}

	public Double getLargo() {
		return largo;
	}

	public void setLargo(Double largo) {
		this.largo = largo;
	}

	@Override
	public String toString() {
		return "Dimensiones [ancho=" + ancho + ", alto=" + alto + ", largo=" + largo + "]";
	}

}
