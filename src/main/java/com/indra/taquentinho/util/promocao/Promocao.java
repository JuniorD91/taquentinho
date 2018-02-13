package com.indra.taquentinho.util.promocao;

import com.indra.taquentinho.model.dominio.Ingrediente;
import com.indra.taquentinho.model.dominio.Lanche;

public 	interface Promocao {

	Lanche verificar(Lanche lanche, Ingrediente ingrediente) throws Exception;

}
