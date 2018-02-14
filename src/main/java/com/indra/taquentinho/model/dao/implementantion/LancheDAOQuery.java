package com.indra.taquentinho.model.dao.implementantion;

import java.util.List;

import com.indra.taquentinho.model.dominio.Lanche;
import com.indra.taquentinho.util.exception.DaoException;

public interface LancheDAOQuery {

	List<Lanche> findAll() throws DaoException;

}
