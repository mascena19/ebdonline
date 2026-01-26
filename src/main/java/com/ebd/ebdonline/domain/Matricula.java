package com.ebd.ebdonline.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Matricula implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generica")
	@SequenceGenerator(
	    name = "seq_generica",
	    sequenceName = "SEQ_GENERICA",
	    allocationSize = 1
	)
	private Integer id;
	private Turma turma;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataMatricula = LocalDate.now();
	private boolean ativa;
	
	
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
	public LocalDate getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public boolean isAtiva() {
		return ativa;
	}
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ativa, dataMatricula, id, turma);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		return ativa == other.ativa && Objects.equals(dataMatricula, other.dataMatricula)
				&& Objects.equals(id, other.id) && Objects.equals(turma, other.turma);
	}
	
	

}
