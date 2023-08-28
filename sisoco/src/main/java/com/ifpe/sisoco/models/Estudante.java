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
@Table(name = "estudante")
public class Estudante {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String matricula;
	private String nome;
	private String curso;
	private String anoEntrada;
		
	
	@OneToMany
	@JoinColumn(name="estudante_id")
	private List<Ocorrencia> ocorrencia = new ArrayList<>();
	
	

	public Estudante(Long id, String matricula, String nome, String curso, String anoEntrada,
			List<Ocorrencia> ocorrencia) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.anoEntrada = anoEntrada;
		this.ocorrencia = ocorrencia;
	}
	
	public Estudante(Long id) {
		super();
		
	}
	
	public Estudante(String matricula, String nome, String curso, String anoEntrada,
			List<Ocorrencia> ocorrencia) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.anoEntrada = anoEntrada;
		this.ocorrencia = ocorrencia;
	}
	
	public Estudante() {
		super();
	
	}


	public List<Ocorrencia> getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(List<Ocorrencia> ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public String getAnoEntrada() {
		return anoEntrada;
	}

	public void setAnoEntrada(String anoEntrada) {
		this.anoEntrada = anoEntrada;
	}

	@Override
	public String toString() {
		return "" + nome + "";
	}
	

	

}
