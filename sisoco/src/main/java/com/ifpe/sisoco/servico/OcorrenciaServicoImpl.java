package com.ifpe.sisoco.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ifpe.sisoco.models.Ocorrencia;
import com.ifpe.sisoco.repositorio.OcorrenciaRepositorio;

@Service
public class OcorrenciaServicoImpl implements OcorrenciaServico{
	
	@Autowired
	public OcorrenciaRepositorio repositorio;
	
	
	@Override
	public List<Ocorrencia> listarOcorrencia() {
		return repositorio.findAll();
	}


	@Override
	public Ocorrencia cadastrarOcorrencia(Ocorrencia ocorrencia) {
		return repositorio.save(ocorrencia);
	}


	@Override
	public Ocorrencia obterOcorrenciaPorId(Long id) {
		return repositorio.findById(id).get();
	}


	@Override
	public Ocorrencia atualizarOcorrencia(Ocorrencia ocorrencia) {
		return repositorio.save(ocorrencia);
	}


	@Override
	public void  eliminarOcorrencia(Long id) {
		repositorio.deleteById(id);
	}

}
