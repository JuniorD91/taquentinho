package com.indra.taquentinho.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.indra.taquentinho.model.dominio.Ingrediente;
import com.indra.taquentinho.model.dominio.Lanche;
import com.indra.taquentinho.util.exception.DaoException;

@Repository
public class IngredienteDAOImpl implements IngredienteDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Ingrediente> buscarIngrediente(Long codigo)throws DaoException{
		return manager
				.createQuery(
						"select i from Ingrediente i left JOIN FETCH i.lanches l where l.codigo=:codigoIgrediente ")
				.setParameter("codigoIgrediente", codigo).getResultList();
	}

}
