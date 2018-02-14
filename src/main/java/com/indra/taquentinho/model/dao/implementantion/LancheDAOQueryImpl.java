package com.indra.taquentinho.model.dao.implementantion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.indra.taquentinho.model.dominio.Lanche;
import com.indra.taquentinho.util.exception.DaoException;

@Repository
public class LancheDAOQueryImpl implements LancheDAOQuery{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Lanche> findAll()throws DaoException {
		return manager.createQuery("select l from Lanche l").getResultList();
	}

}
