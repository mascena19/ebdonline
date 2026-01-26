package com.ebd.ebdonline.domain.enums;

public enum FaixaEtaria {
   
    INFANTIL(0, "INFANTIL") , JUNIORES(1, "JUNIORES"), ADOLESCENTES(2, "ADOLESCENTES")
	,JOVENS(3, "JOVENS"),ADULTOS(4, "ADULTOS"),MELHOR_IDADE(5, "MELHOR_IDADE");
	
	private Integer codigo;
	private String descricao;
	
	private FaixaEtaria(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static FaixaEtaria toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (FaixaEtaria x : FaixaEtaria.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Faixa etária Invalida");
		}
    
    
}