package com.indra.taquentinho.model.negocio.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.indra.taquentinho.model.dao.IngredienteDAO;
import com.indra.taquentinho.model.dao.implementantion.LancheDAOQuery;
import com.indra.taquentinho.model.dominio.Ingrediente;
import com.indra.taquentinho.model.dominio.Lanche;
import com.indra.taquentinho.model.dominio.Venda;
import com.indra.taquentinho.model.negocio.IngredienteNegocio;

@Service
public class LancheNegocioQueryImpl implements LancheNegocioQuery {

	@Autowired
	private LancheDAOQuery lancheDAOQuery;
	
	@Autowired
	private IngredienteNegocio ingredienteNegocio; 
	
	@Autowired
	private IngredienteDAO ingredienteDAO;
	
	private Venda venda;
	
	public LancheNegocioQueryImpl() {
		venda = new Venda();
	}
	
	@Override
	@Transactional
	public List<Lanche> findAll() {
		return lancheDAOQuery.findAll();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Venda adicionarLanche() {
		return null;
	}

	@Override
	public Venda adicionarLanche(Lanche lanche, List<Lanche> lancheComprovante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ingrediente> buscarIngrediente(Lanche lanche) {
		return ingredienteDAO.buscarIngrediente(lanche.getCodigo());
	}

}
