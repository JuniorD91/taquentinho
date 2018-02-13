package com.indra.taquentinho.model.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingrediente")
public class Ingrediente implements Serializable {

	private static final long serialVersionUID = 6041078847293818081L;

	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "valor")
	private BigDecimal valor;

	@Column(name = "url")
	private String url;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ingrediente_lanche", joinColumns = @JoinColumn(name = "ingrediente_codigo"), inverseJoinColumns = @JoinColumn(name = "lanche_codigo"))
	private List<Lanche> lanches;
	
	public Ingrediente() {
	}

	public Ingrediente(Long codigo) {
		this.codigo = codigo;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Lanche> getLanches() {
		return lanches;
	}

	public void setLanches(List<Lanche> lanches) {
		this.lanches = lanches;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
