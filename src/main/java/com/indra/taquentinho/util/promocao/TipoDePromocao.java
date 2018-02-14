package com.indra.taquentinho.util.promocao;

import static com.indra.taquentinho.util.enums.IngredientesEnum.HAMBURGUER_DE_CARNE;
import static com.indra.taquentinho.util.enums.IngredientesEnum.QUEIJO;

import com.indra.taquentinho.model.dominio.Ingrediente;
import com.indra.taquentinho.model.dominio.Lanche;
import com.indra.taquentinho.util.exception.VisaoException;
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

	static Lanche percorrerIsCheckPromocao(Lanche lanche,Ingrediente ingrediente) throws VisaoException {
		try {
			for (TipoDePromocao promocao : TipoDePromocao.values()) {
				promocao.valid(lanche, ingrediente);
			}
			lanche.getIngredientesAdicionais().add(ingrediente);
		} catch (VisaoException e) {
			throw new VisaoException("Ocorreu algum erro ao percorrer as promoções.");
		}
		return lanche;
	}

}
