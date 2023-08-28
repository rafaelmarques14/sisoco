package com.ifpe.sisoco.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifpe.sisoco.models.Estudante;

@Repository
public interface EstudanteRepositorio extends JpaRepository<Estudante, Long>{


	
}
