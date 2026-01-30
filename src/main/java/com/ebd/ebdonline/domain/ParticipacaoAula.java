package com.ebd.ebdonline.domain;

import java.io.Serializable;
import java.util.Objects;

import com.ebd.ebdonline.domain.enums.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class ParticipacaoAula implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generica")
	@SequenceGenerator(
	    name = "seq_participacao",
	    sequenceName = "SEQ_PARTICIPACAO",
	    allocationSize = 1
	)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "aula_id")
	private Aula aula;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	private boolean presente;
	private boolean estudo;
	private boolean visitante;
	
	
	public ParticipacaoAula() {
		super();
	}
	
	public ParticipacaoAula(Aula aula, Pessoa pessoa, boolean presente) {
        this.aula = aula;
        this.pessoa = pessoa;
        this.presente = presente;
        this.visitante = pessoa.getPerfis().contains(Perfil.VISITANTE);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public boolean isPresente() {
		return presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}
		
	public boolean isEstudo() {
		return estudo;
	}

	public void setEstudo(boolean estudo) {
		this.estudo = estudo;
	}

	public boolean isVisitante() {
		return visitante;
	}

	public void setVisitante(boolean visitante) {
		this.visitante = visitante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aula, pessoa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipacaoAula other = (ParticipacaoAula) obj;
		return Objects.equals(aula, other.aula) && Objects.equals(pessoa, other.pessoa);
	}
	

	

}
