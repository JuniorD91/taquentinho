package com.indra.taquentinho.model.dao;

import java.util.List;

import com.indra.taquentinho.model.dominio.Lanche;

public interface VendaDAO {

	List<Lanche> findAll();

}
