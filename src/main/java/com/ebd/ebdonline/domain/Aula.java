package com.ebd.ebdonline.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Aula implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generica")
	@SequenceGenerator(
	    name = "seq_aula",
	    sequenceName = "SEQ_AULA",
	    allocationSize = 1
	)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAula;
	
	private String tema;
	private String licao;
	private double oferta;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public LocalDate getDataAula() {
		return dataAula;
	}
	public void setDataAula(LocalDate dataAula) {
		this.dataAula = dataAula;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getLicao() {
		return licao;
	}
	public void setLicao(String licao) {
		this.licao = licao;
	}
	public double getOferta() {
		return oferta;
	}
	public void setOferta(double oferta) {
		this.oferta = oferta;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, licao);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(id, other.id) && Objects.equals(licao, other.licao);
	}
		

}
