package com.ifpe.sisoco.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String curso;
	private String materiaLecionada;
	
	@OneToMany
	@JoinColumn(name="professor_id")
	private List<Ocorrencia> ocorrencia = new ArrayList<>();
	
	
	
	public List<Ocorrencia> getOcorrencia() {
		return ocorrencia;
	}


	public void setOcorrencia(List<Ocorrencia> ocorrencia) {
		this.ocorrencia = ocorrencia;
	}



	
	public Professor(Long id, String nome, String curso, String materiaLecionada, List<Ocorrencia> ocorrencia) {
		super();
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.materiaLecionada = materiaLecionada;
		this.ocorrencia = ocorrencia;
	}
	
	public Professor(Long id) {
		super();
		this.id = id;
		
	}
	
	public Professor(String nome, String curso, String materiaLecionada, List<Ocorrencia> ocorrencia) {
		super();
		this.nome = nome;
		this.curso = curso;
		this.materiaLecionada = materiaLecionada;
		this.ocorrencia = ocorrencia;
	}
	
	public Professor() {
		super();
	
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getMateriaLecionada() {
		return materiaLecionada;
	}

	public void setMateriaLecionada(String materiaLecionada) {
		this.materiaLecionada = materiaLecionada;
	}


	@Override
	public String toString() {
		return "" + nome + "";
	}


	

}
