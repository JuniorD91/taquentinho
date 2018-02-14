package com.indra.taquentinho.util.promocao;

import static com.indra.taquentinho.util.promocao.TipoDePromocao.percorrerIsCheckPromocao;

import org.springframework.stereotype.Component;

import com.indra.taquentinho.model.dominio.Ingrediente;
import com.indra.taquentinho.model.dominio.Lanche;
import com.indra.taquentinho.util.exception.VisaoException;

@Component
public class PromocaoImpl implements Promocao{

	@Override
	public Lanche verificar(Lanche lanche,Ingrediente ingrediente) throws VisaoException {
		return percorrerIsCheckPromocao(lanche, ingrediente);
	}

}
