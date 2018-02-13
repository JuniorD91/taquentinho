package com.indra.taquentinho.util.promocao;

import static com.indra.taquentinho.util.enums.IngredientesEnum.HAMBURGUER_DE_CARNE;
import static com.indra.taquentinho.util.enums.IngredientesEnum.QUEIJO;

import com.indra.taquentinho.model.dominio.Ingrediente;
import com.indra.taquentinho.model.dominio.Lanche;
enum TipoDePromocao {

	LIGHT(1L) {
		@Override
		Lanche valid(Lanche lanche,Ingrediente ingrediente) {
			return PromocaoUtil.isLight(lanche,ingrediente);
		}
	},
	MUITA_CARNE(2L) {
		@Override
		Lanche valid(Lanche lanche,Ingrediente ingrediente) {
			return PromocaoUtil.calculoDasPorcoes(lanche,ingrediente,HAMBURGUER_DE_CARNE);
		}
	},
	MUITO_QUEIJO(3L) {
		@Override
		Lanche valid(Lanche lanche,Ingrediente ingrediente){
			return PromocaoUtil.calculoDasPorcoes(lanche,ingrediente,QUEIJO);
		}
	};

	private Long codigo;
	
	private TipoDePromocao(Long codigo) {
		this.codigo = codigo;
	}
		
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	abstract Lanche valid(Lanche lanche, Ingrediente ingrediente);

	static Lanche percorrerIsCheckPromocao(Lanche lanche,Ingrediente ingrediente) throws Exception {
		try {
			for (TipoDePromocao promocao : MUITO_QUEIJO.values()) {
				promocao.valid(lanche, ingrediente);
			}
			lanche.getIngredientesAdicionais().add(ingrediente);
		} catch (Exception e) {
			throw new Exception();
		}
		return lanche;
	}

}
