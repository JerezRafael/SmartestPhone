package es.sidelab;

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
	private String resolucion;
	private Double pulgadas;

	public Pantalla() {

	}

	public Pantalla(String tipo, String resolucion, Double pulgadas) {
		this.tipo = tipo;
		this.resolucion = resolucion;
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

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(Integer res1, Integer res2) {
		this.resolucion = res1 + "x" + res2;
	}
	
	public Double getPulgadas() {
		return pulgadas;
	}
	
	public void setPulgadas(Double pulgadas) {
		this.pulgadas = pulgadas;
	}

	@Override
	public String toString() {
		return "Pantalla [tipo=" + tipo + ", resolucion=" + resolucion + ", pulgadas=" + pulgadas + "]";
	}
}
