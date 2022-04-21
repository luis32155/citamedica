package com.proyecto.cita.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cita")
public class Cita {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="idCita")
	private long idcita;
	@ManyToOne
	@JoinColumn(name="idDoctor")
	private Doctor doctor;
	@ManyToOne
	@JoinColumn(name="idEspecialidad")
	private Especialidad  especialidad;
	@Column(name="codigoCita")
	private String codigocita;
	@Column(name="nombPaciente")
	private String nombrepaciente;
	@Column(name="dni")
	private String dnipaciente;
	
	
	
	public Cita() {
		
	}



	public Cita(long idcita, Doctor doctor, Especialidad especialidad, String codigocita, String nombrepaciente,
			String dnipaciente) {
		super();
		this.idcita = idcita;
		this.doctor = doctor;
		this.especialidad = especialidad;
		this.codigocita = codigocita;
		this.nombrepaciente = nombrepaciente;
		this.dnipaciente = dnipaciente;
	}



	public long getIdcita() {
		return idcita;
	}



	public void setIdcita(long idcita) {
		this.idcita = idcita;
	}



	public Doctor getDoctor() {
		return doctor;
	}



	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}



	public Especialidad getEspecialidad() {
		return especialidad;
	}



	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}



	public String getCodigocita() {
		return codigocita;
	}



	public void setCodigocita(String codigocita) {
		this.codigocita = codigocita;
	}



	public String getNombrepaciente() {
		return nombrepaciente;
	}



	public void setNombrepaciente(String nombrepaciente) {
		this.nombrepaciente = nombrepaciente;
	}



	public String getDnipaciente() {
		return dnipaciente;
	}



	public void setDnipaciente(String dnipaciente) {
		this.dnipaciente = dnipaciente;
	}



	@Override
	public String toString() {
		return "Cita [idcita=" + idcita + ", doctor=" + doctor + ", especialidad=" + especialidad + ", codigocita="
				+ codigocita + ", nombrepaciente=" + nombrepaciente + ", dnipaciente=" + dnipaciente + "]";
	}
	
	

}