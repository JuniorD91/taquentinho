package com.indra.taquentinho.util.enums;

public enum IngredientesEnum {
	
	ALFACE(1L),BACON(2L),HAMBURGUER_DE_CARNE(3L), OVO(4L), QUEIJO(5L);
	
	private Long codigo;
	
	private IngredientesEnum(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
}
