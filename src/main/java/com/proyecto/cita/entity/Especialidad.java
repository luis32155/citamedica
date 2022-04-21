package com.proyecto.cita.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="especialidad")
public class Especialidad implements Serializable {

	

	private static final long serialVersionUID = 134234234L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="idEspecialidad")
	private long id;
	@Column(name="nomEspecialidad")
	private String nombre;
	
	public Especialidad() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}