package com.proyecto.cita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.cita.entity.Doctor;
import com.proyecto.cita.repository.DoctoreRepository;
import com.proyecto.cita.service.IDoctorService;


@Service
public class DoctoreServiceimpl implements IDoctorService {

	@Autowired
	DoctoreRepository doctorRepository;
	
	@Override
	public List<Doctor> listarDoctores() {
		return (List<Doctor>) doctorRepository.findAll();
	}
	
	

}
