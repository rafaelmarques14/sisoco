package com.ifpe.sisoco.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ocorrencia")
public class Ocorrencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String data;
	private String local;
	private String descricao;
	private String infoAdicional;
	
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name="estudante_id")
	private Estudante estudante;

		
	public Estudante getEstudante() {
		return estudante;
	}


	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}


	public Ocorrencia(String data, String local, String descricao, String infoAdicional, Professor professor) {
		super();
		this.data = data;
		this.local = local;
		this.descricao = descricao;
		this.infoAdicional = infoAdicional;
		this.professor = professor;
	}


	public Ocorrencia(Long id, String data, String local, String descricao, String infoAdicional, Professor professor) {
		super();
		this.id = id;
		this.data = data;
		this.local = local;
		this.descricao = descricao;
		this.infoAdicional = infoAdicional;
		this.professor = professor;
	}


	public Ocorrencia() {
		// TODO Auto-generated constructor stub
	}


	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getInfoAdicional() {
		return infoAdicional;
	}


	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}


	

}
