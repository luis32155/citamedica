package com.proyecto.cita.service;

import java.util.List;

import com.proyecto.cita.entity.Cita;



public interface ICitaService {
	
	public List<Cita> listarTodos();
	public void guardar(Cita cita);
	public Cita buscarPorId(Long id);
	public void eliminar(Long id);

}
