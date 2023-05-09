package com.codingdojo.cynthia.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="El campo de nombre es obligatorio.")
	@Size(min=2, message="El nombre debe tener al menos 2 caracteres")
	private String nombre;
	
	@NotEmpty(message="El campo de email es obligatorio.")
	@Email(message="Ingresa un correo válido") //Verifica que sea un email válido
	private String email; //correo
	
	@NotEmpty(message="El campo de contraseña es obligatorio.")
	@Size(min=6, message="La contraseña debe tener al menos 6 caracteres")
	private String contrasena;
	
	@Transient //No me guarda el dato en la BD
	@NotEmpty(message="El campo de confirmación es obligatorio.")
	@Size(min=6, message="La confirmación debe tener al menos 6 caracteres")
	private String confirmacion;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
