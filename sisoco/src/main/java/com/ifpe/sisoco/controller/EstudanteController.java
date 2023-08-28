package com.ifpe.sisoco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.ifpe.sisoco.models.Estudante;
import com.ifpe.sisoco.servico.EstudanteServico;

@Controller
public class EstudanteController {
	
	@Autowired
	private EstudanteServico servico;
	
	@GetMapping("/estudante")
	public String listarEstudante(Model modelo) {
		modelo.addAttribute("estudante", servico.listarEstudantes());
		return "estudante";
	}
	
		
	@GetMapping("/estudante/cadastrarestudante")
	public String mostrarformcadastrarEstudante(Model modelo) {
		Estudante estudante = new Estudante();
		modelo.addAttribute("estudante", estudante);
		return "cadastrarestudante";
	}
	
	@PostMapping("/estudante")
	public String cadastrarEstudante(@ModelAttribute("estudante") Estudante estudante) {
		servico.cadastrarEstudante(estudante);
		return "redirect:/estudante";
	}
	
	@GetMapping("/estudante/editar/{id}")
	public String mostrarformeditarEstudante(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("estudante", servico.obterEstudantePorId(id));
		return "editarestudante";
	}
	
	@PostMapping("/estudante/{id}")
	public String atualizarEstudante(@PathVariable Long id, @ModelAttribute("estudante") Estudante estudante, Model modelo) {
		Estudante estudanteExiste = servico.obterEstudantePorId(id);
		estudanteExiste.setId(id);
		estudanteExiste.setNome(estudante.getNome());
		estudanteExiste.setCurso(estudante.getCurso());
		estudanteExiste.setAnoEntrada(estudante.getAnoEntrada());
		
		servico.atualizarEstudante(estudanteExiste);
		return "redirect:/estudante";
	}
	
		@GetMapping("/estudante/{id}")
		public String eliminarEstudante(@PathVariable Long id) {
			servico.eliminarEstudante(id);
			return "redirect:/estudante";
		}
}
	

