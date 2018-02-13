package com.indra.taquentinho.model.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "lanche")
public class Lanche implements Serializable{

	private static final long serialVersionUID = 6666660179934042072L;
	
	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private Long codigo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "url")
	private String url;
	
	@Transient
	private BigDecimal valor;
	
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="ingrediente_lanche", joinColumns=@JoinColumn(name="ingrediente_codigo"), inverseJoinColumns=@JoinColumn(name="lanche_codigo"))  
	private List<Ingrediente> ingredientes;
	
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="adicional_lanche", joinColumns=@JoinColumn(name="ingrediente_codigo"), inverseJoinColumns=@JoinColumn(name="lanche_codigo"))  
	private List<Ingrediente> ingredientesAdicionais;
	
	public Lanche() {
		// TODO Auto-generated constructor stub
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Ingrediente> getIngredientesAdicionais() {
		return ingredientesAdicionais;
	}

	public void setIngredientesAdicionais(List<Ingrediente> ingredientesAdicionais) {
		this.ingredientesAdicionais = ingredientesAdicionais;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	

}
