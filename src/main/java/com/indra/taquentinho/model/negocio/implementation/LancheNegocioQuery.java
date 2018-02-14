package com.indra.taquentinho.model.negocio.implementation;

import java.util.List;

import com.indra.taquentinho.model.dominio.Ingrediente;
import com.indra.taquentinho.model.dominio.Lanche;
import com.indra.taquentinho.model.dominio.Venda;
import com.indra.taquentinho.util.exception.DaoException;

public interface LancheNegocioQuery {

	List<Lanche> findAll() throws DaoException;

	Venda adicionarLanche(Lanche lanche, List<Lanche> lancheComprovante);

	List<Ingrediente> buscarIngrediente(Lanche lanche) throws DaoException;

}
