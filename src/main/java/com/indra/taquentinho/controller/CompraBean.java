package com.indra.taquentinho.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.indra.taquentinho.model.dominio.Ingrediente;
import com.indra.taquentinho.model.dominio.Lanche;
import com.indra.taquentinho.model.dominio.Venda;
import com.indra.taquentinho.model.negocio.IngredienteNegocio;
import com.indra.taquentinho.model.negocio.LancheNegocio;
import com.indra.taquentinho.model.negocio.implementation.LancheNegocioQuery;
import com.indra.taquentinho.util.exception.DaoException;
import com.indra.taquentinho.util.exception.VisaoException;
import com.indra.taquentinho.util.promocao.Promocao;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@ViewScoped
@Component
public class CompraBean implements Serializable {

	private static final long serialVersionUID = -7896742706239508923L;

	@Autowired
	private LancheNegocio lancheNegocio;
	@Autowired
	private IngredienteNegocio ingredienteNegocio;
	@Autowired
	private LancheNegocioQuery lancheNegocioQuery;
	@Autowired
	private Promocao promocao;

	private List<Lanche> lanches;
	private List<Lanche> lancheComprovante;
	private List<Ingrediente> ingredientes;
	private List<Ingrediente> todosIngrediente;
	private List<Ingrediente> ingredienteAdicional;

	private Lanche selectLanche;
	private Venda venda;
	private Lanche lanche;
	private Ingrediente ingrediente;
	private BigDecimal valorDoLanche;
	private BigDecimal valorTotal;

	@PostConstruct
	public void init() {
		lanches = lancheNegocio.findAll();

		if (lanches == null)
			throw new IllegalArgumentException("A lista de lanches está invalido. valor null");

		inicializar();
	}

	private void inicializar() {
		venda = new Venda();
		lanche = new Lanche();
		ingrediente = new Ingrediente();
		valorTotal = new BigDecimal(0);

		lancheComprovante = new ArrayList<>();
		selectLanche = new Lanche();
		todosIngrediente = new ArrayList<>();
		ingredienteAdicional = new ArrayList<>();
	}

	public void adicionarLanche() throws DaoException {
		try {
			valorDoLanche = new BigDecimal(0);
			ingredientes = lancheNegocioQuery.buscarIngrediente(lanche);

			ingredientes.forEach(ingrediente -> {
				valorDoLanche = valorDoLanche.add(ingrediente.getValor());
			});

			formatarValorDoLanche();
		} catch (VisaoException e) {
			throw new VisaoException("Ocorreu algum erro ao adicionar um lanche");
		}
	}

	private void formatarValorDoLanche() {
		lanche.setValor(valorDoLanche);
		valorTotal = valorTotal.add(valorDoLanche);
		lanche.setIngredientes(ingredientes);
		lanche.setIngredientesAdicionais(new ArrayList<>());
		lancheComprovante.add(lanche);
	}

	public void linhaSelecionado(SelectEvent event) throws DaoException {
		if (event == null)
			throw new IllegalArgumentException(
					"Ocorreu algum erro ao selecionar a linhda do comprovante, não conseguiu capturar o objeto selecionado.");

		try {
			todosIngrediente = ingredienteNegocio.findAll();
			ingredientes = lancheNegocioQuery.buscarIngrediente(((Lanche) event.getObject()));
		} catch (VisaoException e) {
			throw new VisaoException("Ocorreu algum erro ao buscar os ingrediente do lanche selecionado.");
		}
	}

	public void removerAdicional(Ingrediente dialogAdicional) {

		if (dialogAdicional == null)
			throw new IllegalArgumentException(
					"Ocorreu um erro ao remover o adicional : Não conseguiu encontrar o objeto que deseja remover.");

		if (selectLanche.getValor() == null || dialogAdicional.getValor() == null)
			throw new IllegalArgumentException(
					"Ocorreu um erro ao remover o adicional : Não conseguiu subtrair os valores dos adicionais removido.");
		selectLanche.setValor(selectLanche.getValor().subtract(dialogAdicional.getValor()).abs());

		try {
			selectLanche.getIngredientesAdicionais().remove(dialogAdicional);
		} catch (VisaoException e) {
			throw new VisaoException("Ocorreu um erro ao remover o adicional : " + e.getCause());
		}
		valorTotal = valorTotal.subtract(dialogAdicional.getValor()).abs();
	}

	public void removerIngrediente(Ingrediente ingrediente) {
		if (ingrediente == null)
			throw new IllegalArgumentException(
					"Ocorreu um erro ao remover o Ingrediente : Não conseguiu encontrar o objeto que deseja remover.");
		
		
		if (lanche.getValor() == null || ingrediente.getValor() == null)
			throw new IllegalArgumentException("Ocorreu um erro ao remover o Ingrediente : Não consegui subtrair o valor do ingrediente que deseja remover com o valor total");
		lanche.setValor(lanche.getValor().subtract(ingrediente.getValor()).abs());
		
		valorTotal = valorTotal.subtract(ingrediente.getValor()).abs();
		
		try {
			ingredientes.remove(ingrediente);
		} catch (VisaoException e) {
			throw new VisaoException("Ocorreu um erro ao remover o ingrediente" + e.getCause());
		}
	}

	/**
	 * promocao Method : responsável para informar ao ingrediente adicionais todos
	 * os ingredientes extras que o cliente clicar no dialog do lanche.
	 * 
	 * @throws Exception
	 **/
	public void adicionarIngrediente() throws Exception {

		lanche = promocao.verificar(selectLanche, ingrediente);
		if(lanche == null)
			throw new IllegalArgumentException("Ocorreu algum erro ao adicionar ingredienete ");
		selectLanche = lanche;
		
		definirValorComprovanteEValorTotal(ingrediente);
	}

	/**
	 * responsável para informar os valores } individuais dos lanches e o valor
	 * total, ou seja, todas as vezes que o usuario selecionar um novo ingrediente
	 * adicional será somando com valor total da compra e com valor respectivo do
	 * lanche. ex: hamburguer X-Egg Bacon
	 **/
	private void definirValorComprovanteEValorTotal(Ingrediente ingrediente) {
		if(ingrediente == null)
				throw new IllegalArgumentException("Ocorreu um erro ao definir os valores do comprovante.");
		valorTotal = valorTotal.add(ingrediente.getValor()).abs();
	}

	public List<Lanche> getLanches() {
		return lanches;
	}

	public void setLanches(List<Lanche> lanches) {
		this.lanches = lanches;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Lanche getLanche() {
		return lanche;
	}

	public void setLanche(Lanche lanche) {
		this.lanche = lanche;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public List<Lanche> getLancheComprovante() {
		return lancheComprovante;
	}

	public void setLancheComprovante(List<Lanche> lancheComprovante) {
		this.lancheComprovante = lancheComprovante;
	}

	public BigDecimal getValorDoLanche() {
		return valorDoLanche;
	}

	public void setValorDoLanche(BigDecimal valorDoLanche) {
		this.valorDoLanche = valorDoLanche;
	}

	public Lanche getSelectLanche() {
		return selectLanche;
	}

	public void setSelectLanche(Lanche selectLanche) {
		this.selectLanche = selectLanche;
	}

	public List<Ingrediente> getTodosIngrediente() {
		return todosIngrediente;
	}

	public void setTodosIngrediente(List<Ingrediente> todosIngrediente) {
		this.todosIngrediente = todosIngrediente;
	}

	public List<Ingrediente> getIngredienteAdicional() {
		return ingredienteAdicional;
	}

	public void setIngredienteAdicional(List<Ingrediente> ingredienteAdicional) {
		this.ingredienteAdicional = ingredienteAdicional;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
