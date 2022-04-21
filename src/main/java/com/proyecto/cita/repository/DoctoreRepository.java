package com.proyecto.cita.repository;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.cita.entity.Doctor;

public interface DoctoreRepository extends CrudRepository<Doctor,Long> {

}
