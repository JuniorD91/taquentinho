package com.indra.taquentinho.model.negocio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.indra.taquentinho.model.dominio.Lanche;

public interface LancheNegocio extends JpaRepository<Lanche, Long>{
	
}
