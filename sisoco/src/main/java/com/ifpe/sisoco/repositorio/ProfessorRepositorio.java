package com.ifpe.sisoco.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifpe.sisoco.models.Professor;

@Repository
public interface ProfessorRepositorio extends JpaRepository<Professor, Long>{

}
