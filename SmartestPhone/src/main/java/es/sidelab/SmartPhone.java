package es.sidelab;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SmartPhone {

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
	@OneToOne(cascade=CascadeType.ALL)
	private SO so;
	@OneToOne(cascade=CascadeType.ALL)
	private Camara camara;
	@OneToOne(cascade=CascadeType.ALL)
	private Dimensiones dimensiones;
	@OneToOne(cascade=CascadeType.ALL)
	private Pantalla pantalla;
	@OneToOne(cascade=CascadeType.ALL)
	private Procesador procesador;

	public SmartPhone() {

	}

	public SmartPhone(String marca, String modelo, String color, Integer bateria, 
			Integer almacenamiento, Integer ram, Integer peso) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.bateria = bateria;
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.peso = peso;
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
	
	public SO getSO() {
		return so;
	}
	
	public void setSO(SO so) {
		this.so = so;
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
	bateria + ", almacenamiento=" + almacenamiento + ", ram=" + ram + ", peso=" + peso + ", SO=" + so + 
	", camara=" + camara + ", dimensiones=" + dimensiones + ", pantalla=" + pantalla + ", procesador=" 
	+ procesador + "]";
	}

}