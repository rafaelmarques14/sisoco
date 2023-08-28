package com.ifpe.sisoco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifpe.sisoco.models.Professor;
import com.ifpe.sisoco.servico.ProfessorServico;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorServico servico;
	
	
	@GetMapping("/professor")
	public String listarProfessor(Model modelo) {
		modelo.addAttribute("professor", servico.listarProfessor());
		return "professor";
	}
	
		
	@GetMapping("/professor/cadastrarprofessor")
	public String mostrarformcadastrarProfessor(Model modelo) {
		Professor professor = new Professor();
		modelo.addAttribute("professor", professor);
		return "cadastrarprofessor";
	}
	
	@PostMapping("/professor")
	public String cadastrarProfessor(@ModelAttribute("professor") Professor professor) {
		servico.cadastrarProfessor(professor);
		return "redirect:/";
	}
	
	@GetMapping("/professor/editar/{id}")
	public String mostrarformeditarProfessor(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("professor", servico.obterProfessorPorId(id));
		return "editarprofessor";
	}
	
	@PostMapping("/professor/{id}")
	public String atualizarProfessor(@PathVariable Long id, @ModelAttribute("professor") Professor professor, Model modelo) {
		Professor professorExiste = servico.obterProfessorPorId(id);
		professorExiste.setId(id);
		professorExiste.setNome(professor.getNome());
		professorExiste.setCurso(professor.getCurso());
		professorExiste.setMateriaLecionada(professor.getMateriaLecionada());
		
		servico.atualizarProfessor(professorExiste);
		return "redirect:/professor";
	}
	
		@GetMapping("/professor/{id}")
		public String eliminarProfessor(@PathVariable Long id) {
			servico.eliminarProfessor(id);
			return "redirect:/professor";
		}
}
