package es.sidelab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SmartPhone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSmartPhone;
	private String marca;
	private String modelo;
	private String color;

	public SmartPhone() {

	}

	public SmartPhone(String marca, String modelo, String color) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
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

	@Override
	public String toString() {
		return "SmartPhone [marca=" + marca + ", modelo=" + modelo + ", color=" + color + "]";
	}

}