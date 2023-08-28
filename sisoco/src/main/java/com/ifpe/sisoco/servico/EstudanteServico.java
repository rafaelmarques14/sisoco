package com.ifpe.sisoco.servico;

import java.util.List;

import com.ifpe.sisoco.models.Estudante;

public interface EstudanteServico {
	
	public List<Estudante> listarEstudantes();
		
	public Estudante cadastrarEstudante(Estudante estudante);

	public Estudante obterEstudantePorId(Long id);
	
	public Estudante atualizarEstudante(Estudante estudante); 
	
	public void eliminarEstudante(Long id);



}
