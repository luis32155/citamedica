package com.proyecto.cita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.cita.entity.Cita;
import com.proyecto.cita.repository.CitaRepository;
import com.proyecto.cita.service.ICitaService;

@Service
public class CitaServiceImpl implements ICitaService {

	@Autowired
	CitaRepository citarepository;
	
	@Override
	public List<Cita> listarTodos() {
		return (List<Cita>) citarepository.findAll();
	}

	@Override
	public void guardar(Cita cita) {
		citarepository.save(cita);
		
	}

	@Override
	public Cita buscarPorId(Long id) {
		return citarepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		citarepository.deleteById(id);
		
	}

}
