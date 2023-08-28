package com.ifpe.sisoco.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.sisoco.models.Estudante;
import com.ifpe.sisoco.repositorio.EstudanteRepositorio;

@Service
public class EstudanteServicoImpl implements EstudanteServico{

	@Autowired
	public EstudanteRepositorio repositorio;
	
	
	@Override
	public List<Estudante> listarEstudantes() {
		return repositorio.findAll();
	}


	@Override
	public Estudante cadastrarEstudante(Estudante estudante) {
		return repositorio.save(estudante);
	}


	@Override
	public Estudante obterEstudantePorId(Long id) {
		return repositorio.findById(id).get();
	}


	@Override
	public Estudante atualizarEstudante(Estudante estudante) {
		return repositorio.save(estudante);
	}


	@Override
	public void  eliminarEstudante(Long id) {
		repositorio.deleteById(id);
	}


}
