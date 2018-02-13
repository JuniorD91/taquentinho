package com.indra.taquentinho.model.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.taquentinho.model.dao.VendaDAO;
import com.indra.taquentinho.model.dominio.Lanche;

@Service
public class VendaNegocioImpl{
	
	@Autowired
	private VendaDAO vendaDAO;
	
	@Transactional
	public List<Lanche> findAll() {
		return vendaDAO.findAll();
	}

}
