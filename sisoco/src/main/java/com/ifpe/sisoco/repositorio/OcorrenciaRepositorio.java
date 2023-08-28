package com.ifpe.sisoco.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifpe.sisoco.models.Ocorrencia;

@Repository
public interface OcorrenciaRepositorio extends JpaRepository<Ocorrencia, Long>{

}
