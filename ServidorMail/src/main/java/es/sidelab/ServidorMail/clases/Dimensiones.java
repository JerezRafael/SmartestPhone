package es.sidelab.ServidorMail.clases;

public class Dimensiones {

	private long idDimensiones;
	private Integer ancho;
	private Integer alto;
	private Integer largo;

	public Dimensiones() {

	}

	public Dimensiones(Integer ancho, Integer alto, Integer largo) {
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

	public Integer getAncho() {
		return ancho;
	}

	public void setAncho(Integer ancho) {
		this.ancho = ancho;
	}

	public Integer getAlto() {
		return alto;
	}

	public void setAlto(Integer alto) {
		this.alto = alto;
	}

	public Integer getLargo() {
		return largo;
	}

	public void setLargo(Integer largo) {
		this.largo = largo;
	}

	@Override
	public String toString() {
		return "Dimensiones [ancho=" + ancho + ", alto=" + alto + ", largo=" + largo + "]";
	}

}
