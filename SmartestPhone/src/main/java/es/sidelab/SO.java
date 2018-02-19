package es.sidelab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSO;
	private String nombre;
	private Integer version;
	
	public SO() {
		
	}

	public SO(String nombre, Integer version) {
		this.nombre = nombre;
		this.version = version;
	}

	public long getIdSO() {
		return idSO;
	}
	
	public void setIdSO(long idSO) {
		this.idSO = idSO;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Sistema Operativo [nombre=" + nombre + ", version=" + version + "]";
	}

}
