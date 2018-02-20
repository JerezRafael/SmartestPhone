package es.sidelab;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Procesador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProcesador;
	private String marca;
	private String modelo;
	private Double ghz;
	private Integer nucleos;
	@OneToMany(mappedBy="procesador")
	private List<Smartphone> smartphones;
	
	public Procesador() {
		
	}

	public Procesador(String marca, String modelo, Double ghz, Integer nucleos) {
		this.marca = marca;
		this.modelo = modelo;
		this.ghz = ghz;
		this.nucleos = nucleos;
	}

	public long getIdProcesador() {
		return idProcesador;
	}
	
	public void setIdProcesador(long idProcesador) {
		this.idProcesador = idProcesador;
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

	public Double getGhz() {
		return ghz;
	}

	public void setGhz(Double ghz) {
		this.ghz = ghz;
	}
	
	public Integer getNucleos() {
		return nucleos;
	}

	public void setNucleos(Integer nucleos) {
		this.nucleos = nucleos;
	}
	
	public List<Smartphone> getSmartphones() {
		return smartphones;
	}
	
	public void setSmartphones(Smartphone smartphone) {
		smartphones.add(smartphone);
	}

	@Override
	public String toString() {
		return "Procesador [marca=" + marca + ", modelo=" + modelo + ", GHz=" + ghz + ", nucleos=" + nucleos + "]";
	}

}
