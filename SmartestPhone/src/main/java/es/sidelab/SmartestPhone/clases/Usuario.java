package es.sidelab.SmartestPhone.clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	private String nombre;
	private String hashContraseña;
	private String mail;

	@ElementCollection(fetch = FetchType.EAGER)
	@JsonIgnore
	private List<String> roles;

	public Usuario() {

	}

	public Usuario(String nombre, String contraseña, String mail, String... roles) {
		this.nombre = nombre;
		this.hashContraseña = new BCryptPasswordEncoder().encode(contraseña);
		this.mail = mail;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}