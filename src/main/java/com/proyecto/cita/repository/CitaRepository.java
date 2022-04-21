package com.proyecto.cita.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.cita.entity.Cita;

@Repository
public interface CitaRepository extends CrudRepository<Cita,Long> {

}
