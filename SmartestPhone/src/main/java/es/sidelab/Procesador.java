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
	private String marcap;
	private String modelop;
	private Double ghz;
	private Integer nucleos;
	@OneToMany(mappedBy="procesador")
	private List<Smartphone> smartphones;
	
	public Procesador() {
		
	}

	public Procesador(String marcap, String modelop, Double ghz, Integer nucleos) {
		this.marcap = marcap;
		this.modelop = modelop;
		this.ghz = ghz;
		this.nucleos = nucleos;
	}

	public long getIdProcesador() {
		return idProcesador;
	}
	
	public void setIdProcesador(long idProcesador) {
		this.idProcesador = idProcesador;
	}
	
	public String getMarcap() {
		return marcap;
	}

	public void setMarcap(String marcap) {
		this.marcap = marcap;
	}

	public String getModelop() {
		return modelop;
	}

	public void setModelop(String modelop) {
		this.modelop = modelop;
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
		return "Procesador [marca=" + marcap + ", modelo=" + modelop + ", GHz=" + ghz + ", nucleos=" + nucleos + "]";
	}

}
