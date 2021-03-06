package es.sidelab.ServidorMail.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pantalla {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPantalla;
	private String tipo;
	private Integer resolucion1;
	private Integer resolucion2;
	private Double pulgadas;

	public Pantalla() {

	}

	public Pantalla(String tipo, Integer resolucion1, Integer resolucion2, Double pulgadas) {
		this.tipo = tipo;
		this.resolucion1 = resolucion1;
		this.resolucion2 = resolucion2;
		this.pulgadas = pulgadas;
	}

	public long getIdPantalla() {
		return idPantalla;
	}

	public void setIdPantalla(long idPantalla) {
		this.idPantalla = idPantalla;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getResolucion1() {
		return resolucion1;
	}

	public void setResolucion1(Integer resolucion1) {
		this.resolucion1 = resolucion1;
	}

	public Integer getResolucion2() {
		return resolucion2;
	}

	public void setResolucion2(Integer resolucion2) {
		this.resolucion2 = resolucion2;
	}

	public Double getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(Double pulgadas) {
		this.pulgadas = pulgadas;
	}

	@Override
	public String toString() {
		return "Pantalla [tipo=" + tipo + ", resolucion=" + resolucion1 + "x" + resolucion2 + ", pulgadas=" + pulgadas
				+ "]";
	}
}
