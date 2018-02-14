package com.indra.taquentinho.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.indra.taquentinho.model.dominio.Lanche;
import com.indra.taquentinho.util.exception.VisaoException;

@Repository
public class VendaDAOImpl implements VendaDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Lanche> findAll()throws VisaoException{
		return manager.createQuery(
			    "select l from Lanche as l")
			    .getResultList();
	}
	
}
