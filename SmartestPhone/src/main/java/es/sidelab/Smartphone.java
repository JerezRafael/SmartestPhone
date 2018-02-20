package es.sidelab;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Smartphone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSmartPhone;
	private String marca;
	private String modelo;
	private String color;
	private Integer bateria;
	private Integer almacenamiento;
	private Integer ram;
	private Integer peso;
	private String SO;
	private Integer versionSO;
	@OneToOne(cascade=CascadeType.ALL)
	private Camara camara;
	@OneToOne(cascade=CascadeType.ALL)
	private Dimensiones dimensiones;
	@OneToOne(cascade=CascadeType.ALL)
	private Pantalla pantalla;
	@OneToOne(cascade=CascadeType.ALL)
	private Procesador procesador;
	
	public Smartphone() {
		
	}

	public Smartphone(String marca, String modelo, String color, Integer bateria, 
			Integer almacenamiento, Integer ram, Integer peso, String SO, Integer versionSO, Camara camara, Dimensiones dimensiones, Pantalla pantalla, Procesador procesador) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.bateria = bateria;
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.peso = peso;
		this.SO = SO;
		this.versionSO = versionSO;
		this.camara = camara;
		this.dimensiones = dimensiones;
		this.pantalla = pantalla;
		this.procesador = procesador;
	}

	public long getIdSmartPhone() {
		return idSmartPhone;
	}
	
	public void setIdSmartPhone(long idSmartPhone) {
		this.idSmartPhone = idSmartPhone;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Integer getBateria() {
		return bateria;
	}
	
	public void setBateria(Integer bateria) {
		this.bateria = bateria;
	}
	
	public Integer getAlmacenamiento() {
		return almacenamiento;
	}
	
	public void setAlmacenamiento(Integer almacenamiento) {
		this.almacenamiento = almacenamiento;
	}
	
	public Integer getRam() {
		return ram;
	}
	
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	
	public Integer getPeso() {
		return peso;
	}
	
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
	public String getSO() {
		return SO;
	}
	
	public void setSO(String SO) {
		this.SO = SO;
	}
	
	public Integer getVersionSO() {
		return versionSO;
	}
	
	public void setVersionSO(Integer versionSO) {
		this.versionSO = versionSO;
	}
	
	public Camara getCamara() {
		return camara;
	}
	
	public void setCamara(Camara camara) {
		this.camara = camara;
	}
	
	public Dimensiones getDimensiones() {
		return dimensiones;
	}
	
	public void setDimensiones(Dimensiones dimensiones) {
		this.dimensiones = dimensiones;
	}
	
	public Pantalla getPantalla() {
		return pantalla;
	}
	
	public void setPantalla(Pantalla pantalla) {
		this.pantalla = pantalla;
	}
	
	public Procesador getProcesador() {
		return procesador;
	}
	
	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	@Override
	public String toString() {
		return "SmartPhone [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", bateria=" + 
	bateria + ", almacenamiento=" + almacenamiento + ", ram=" + ram + ", peso=" + peso + ", SO=" + SO + " " + versionSO + 
	", camara=" + camara + ", dimensiones=" + dimensiones + ", pantalla=" + pantalla + ", procesador=" 
	+ procesador + "]";
	}

}