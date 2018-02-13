package com.indra.taquentinho.model.dao;

import java.util.List;
import com.indra.taquentinho.model.dominio.Ingrediente;

public interface IngredienteDAO {

	List<Ingrediente> buscarIngrediente(Long codigo);

}
