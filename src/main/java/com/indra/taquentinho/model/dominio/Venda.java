package com.indra.taquentinho.model.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda implements Serializable{

	private static final long serialVersionUID = 1793047339840908784L;
	
	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private Long codigo;
	
	@Column(name = "data_venda")
	private LocalDate dataVenda;
	
	@Column(name = "valor_lanche")
	private BigDecimal valorLanche;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "lanche_venda", joinColumns = {
			@JoinColumn(name = "lanche_codigo", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "venda_codigo",
					nullable = false, updatable = false) })
	private List<Lanche> lanches;
	
	public Venda() {
	}
	
	public Venda(LocalDate dataVenda,BigDecimal valorLanche) {
		this.dataVenda = dataVenda;
		this.valorLanche = valorLanche;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public BigDecimal getValorLanche() {
		return valorLanche;
	}

	public void setValorLanche(BigDecimal valorLanche) {
		this.valorLanche = valorLanche;
	}

	public List<Lanche> getLanches() {
		return lanches;
	}

	public void setLanches(List<Lanche> lanches) {
		this.lanches = lanches;
	}
	
	
}
