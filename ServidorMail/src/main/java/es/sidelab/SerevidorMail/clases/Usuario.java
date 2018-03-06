package es.sidelab.SerevidorMail.clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Usuario {

	private String nombre;

	private String hashContraseña;

	private List<String> roles;

	public Usuario() {
	}

	public Usuario(String nombre, String contraseña, String... roles) {
		this.nombre = nombre;
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHashContraseña() {
		return hashContraseña;
	}

	public void setHashContraseña(String hashContraseña) {
		this.hashContraseña = hashContraseña;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}