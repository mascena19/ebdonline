package com.ebd.ebdonline.domain.enums;

import java.util.Iterator;

public enum Perfil {
	
	ADMIN(0, "ROLE_ADMIN") , ALUNO(1, "ROLE_ALUNO"), SECRETADRIO(2, "ROLE_SECRETARIO")
	,VISITANTE(3, "ROLE_VISITANTE");
	
	private Integer codigo;
	private String descricao;
	
	private Perfil(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (Perfil x : Perfil.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil Inválido");
		}

}
