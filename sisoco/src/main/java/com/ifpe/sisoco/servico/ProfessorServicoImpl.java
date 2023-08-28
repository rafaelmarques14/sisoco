package com.ifpe.sisoco.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.sisoco.models.Professor;
import com.ifpe.sisoco.repositorio.ProfessorRepositorio;

@Service
public class ProfessorServicoImpl implements ProfessorServico{
	
	@Autowired
	public ProfessorRepositorio repositorio;
	
	@Override
	public List<Professor> listarProfessor() {
		return repositorio.findAll();
	}

	@Override
	public Professor cadastrarProfessor(Professor professor) {
		return repositorio.save(professor);
	}

	@Override
	public Professor obterProfessorPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Professor atualizarProfessor(Professor professor) {
		return repositorio.save(professor);
	}

	@Override
	public void  eliminarProfessor(Long id) {
		repositorio.deleteById(id);
	}

}
