package com.indra.taquentinho.model.negocio.implementation;

import java.util.List;

import com.indra.taquentinho.model.dominio.Ingrediente;
import com.indra.taquentinho.model.dominio.Lanche;
import com.indra.taquentinho.model.dominio.Venda;

public interface LancheNegocioQuery {

	List<Lanche> findAll();

	Venda adicionarLanche(Lanche lanche, List<Lanche> lancheComprovante);

	List<Ingrediente> buscarIngrediente(Lanche lanche);

	Venda adicionarLanche();

}
