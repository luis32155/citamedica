package com.proyecto.cita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.cita.entity.Especialidad;
import com.proyecto.cita.repository.EspecialidadRepository;
import com.proyecto.cita.service.IEspecialidadService;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

	@Autowired
	EspecialidadRepository repositoryespecialidad;
	
	@Override
	public List<Especialidad> listarEspecialidad() {
	   return (List<Especialidad>) repositoryespecialidad.findAll();
	}

}
