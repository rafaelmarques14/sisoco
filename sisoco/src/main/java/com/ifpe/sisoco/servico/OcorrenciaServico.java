package com.ifpe.sisoco.servico;

import java.util.List;

import com.ifpe.sisoco.models.Ocorrencia;

public interface OcorrenciaServico {
	
	public List<Ocorrencia> listarOcorrencia();
	
	public Ocorrencia cadastrarOcorrencia(Ocorrencia ocorrencia);

	public Ocorrencia obterOcorrenciaPorId(Long id);
	
	public Ocorrencia atualizarOcorrencia(Ocorrencia ocorrencia); 
	
	public void eliminarOcorrencia(Long id);

}
