package com.ifpe.sisoco.servico;

import java.util.List;

import com.ifpe.sisoco.models.Professor;

public interface ProfessorServico {
	
	public List<Professor> listarProfessor();
	
	public Professor cadastrarProfessor(Professor professor);

	public Professor obterProfessorPorId(Long id);
	
	public Professor atualizarProfessor(Professor professor); 
	
	public void eliminarProfessor(Long id);

}
