package br.com.starwars.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planeta")
public class Planeta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idplaneta")
	private Integer idPlaneta;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="clima")
	private String clima;
	
	@Column(name="terreno")
	private String terreno;
	
	public Planeta() {}

	public Integer getIdPlaneta() {
		return idPlaneta;
	}

	public void setIdPlaneta(Integer idPlaneta) {
		this.idPlaneta = idPlaneta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	

}
