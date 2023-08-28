package com.ifpe.sisoco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifpe.sisoco.models.Estudante;
import com.ifpe.sisoco.models.Ocorrencia;
import com.ifpe.sisoco.models.Professor;
import com.ifpe.sisoco.repositorio.EstudanteRepositorio;
import com.ifpe.sisoco.repositorio.ProfessorRepositorio;
import com.ifpe.sisoco.servico.OcorrenciaServico;

@Controller
public class OcorrenciaController {
	
	@Autowired
	private OcorrenciaServico servico;
	
	@Autowired
	private ProfessorRepositorio professorRepositorio;
	
	@Autowired
	private EstudanteRepositorio estudanteRepositorio;
	
	@GetMapping({"/ocorrencia","/"})
	public String listarOcorrencia(Model modelo) {
		modelo.addAttribute("ocorrencia", servico.listarOcorrencia());
		return "ocorrencia";
	}
	
		
	@GetMapping("/ocorrencia/cadastrarocorrencia")
	public String mostrarformcadastrarOcorrencia(Model modelo) {
		List<Professor> listarProfessor = professorRepositorio.findAll();
		List<Estudante> listarEstudante = estudanteRepositorio.findAll();
		modelo.addAttribute("listarProfessor", listarProfessor);
		modelo.addAttribute("listarEstudante", listarEstudante);
		modelo.addAttribute("ocorrencia", new Ocorrencia());
		return "cadastrarocorrencia";
	}
	
	@PostMapping("/ocorrencia")
	public String cadastrarOcorrencia(@ModelAttribute("ocorrencia") Ocorrencia ocorrencia) {
		servico.cadastrarOcorrencia(ocorrencia);
		return "redirect:/ocorrencia";
	}
	
	@GetMapping("/ocorrencia/editar/{id}")
	public String mostrarformeditarOcorrencia(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("ocorrencia", servico.obterOcorrenciaPorId(id));
		return "editarocorrencia";
	}
	
	@PostMapping("/ocorrencia/{id}")
	public String atualizarOcorrencia(@PathVariable Long id, @ModelAttribute("ocorrencia") Ocorrencia ocorrencia, Model modelo) {
		Ocorrencia ocorrenciaExiste = servico.obterOcorrenciaPorId(id);
		ocorrenciaExiste.setId(id);
		ocorrenciaExiste.setData(ocorrencia.getData());
		ocorrenciaExiste.setLocal(ocorrencia.getLocal());
		ocorrenciaExiste.setDescricao(ocorrencia.getDescricao());
		ocorrenciaExiste.setInfoAdicional(ocorrencia.getInfoAdicional());
		
		servico.atualizarOcorrencia(ocorrenciaExiste);
		return "redirect:/ocorrencia";
	}
	
		@GetMapping("/ocorrencia/{id}")
		public String eliminarOcorrencia(@PathVariable Long id) {
			servico.eliminarOcorrencia(id);
			return "redirect:/ocorrencia";
		}

}
