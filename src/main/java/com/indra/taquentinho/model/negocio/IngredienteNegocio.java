package com.indra.taquentinho.model.negocio;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.indra.taquentinho.model.dominio.Ingrediente;

public interface IngredienteNegocio extends JpaRepository<Ingrediente, Long>{

	@Query(value = "SELECT sum(valor) valor_do_produto  FROM ingrediente_lanche il INNER JOIN ingrediente i ON il.ingrediente_codigo = i.codigo where il.lanche_codigo = ?",nativeQuery = true)
	BigDecimal somarValorIngrediente(Long codigo);


}
