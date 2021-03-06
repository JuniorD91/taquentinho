package com.indra.taquentinho.model.dao;

import java.util.List;
import com.indra.taquentinho.model.dominio.Ingrediente;
import com.indra.taquentinho.util.exception.DaoException;

public interface IngredienteDAO {

	List<Ingrediente> buscarIngrediente(Long codigo) throws DaoException;

}
