package com.indra.taquentinho.util.promocao;
import static com.indra.taquentinho.util.enums.IngredientesEnum.ALFACE;
import static com.indra.taquentinho.util.enums.IngredientesEnum.BACON;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import com.indra.taquentinho.model.dominio.Ingrediente;
import com.indra.taquentinho.model.dominio.Lanche;
import com.indra.taquentinho.util.enums.IngredientesEnum;;

public abstract class PromocaoUtil {
	
	private static BigDecimal valorIngrediente;
	
	public PromocaoUtil() {
		valorIngrediente = new BigDecimal(0);
	}
	/**
	 * 
	 * @param lanche :será o produto selecionado pelo cliente
	 * @param ingrediente : Ingrediente selecionado pelo cliente
	 * @return retornará o lanche com valor atualizado
	 * 
	 *  Ex: Método irá verificar se existe algum lanche com al
	 */
	public static Lanche isLight(Lanche lanche, Ingrediente ingrediente) {
		boolean isHasAlface = false;
		boolean isNotHasBacon = true;
		lanche.getIngredientes().add(ingrediente);
		for (Ingrediente listIngrediente : lanche.getIngredientes()) {
			if (listIngrediente.getCodigo().equals(ALFACE.getCodigo())) {
				isHasAlface = true;
			} if(listIngrediente.getCodigo().equals(BACON.getCodigo())) {
				isNotHasBacon = false;
			}
		}
		if (isHasAlface && isNotHasBacon) {

			lanche.setValor(lanche.getValor()
					.subtract(lanche.getValor().multiply(new BigDecimal(0.1).setScale(2, RoundingMode.HALF_EVEN))));
		}

		return lanche;
	}
	
	/**
	 * 
	 * @param lanche : será o produto selecionado pelo cliente
	 * @param porcao : tipo de porção que será calculado
	 * @return será retornado o lanche com o valor atualizado do produto 
	 * 
	 * Ex :
	 * 
	 * A cada 3 porções de X produto o cliente só paga 2. Se o lanche tiver 6 porções, o cliente pagará 4. Assim por diante
	 * 
	 */
	public static Lanche calculoDasPorcoes(Lanche lanche,Ingrediente ingrediente ,IngredientesEnum porcao) {
		int quantiadeDePorcaoPaga = calcularQuantidadeDePorcao(lanche, porcao);
		if(quantiadeDePorcaoPaga >= 3) {
			BigDecimal valorReal = new BigDecimal(0); 
			valorReal = new BigDecimal((quantiadeDePorcaoPaga * 2) / 3).multiply(valorIngrediente);
			lanche.setValor(valorReal);
		}
		return lanche;
	}
	
	private static int calcularQuantidadeDePorcao(Lanche lanche, IngredientesEnum porcao) {
		int quantidade = 0;
		
		for (Ingrediente calcIngrediente : lanche.getIngredientes()) {
			if (calcIngrediente.getCodigo().equals(porcao.getCodigo())) {
				quantidade++;
				valorIngrediente = calcIngrediente.getValor();
			}
		}
		return quantidade;
	}
}
