package com.api.mercadoria.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.api.mercadoria.model.Mercadoria;

public class MercadoriaDto {

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private Integer quantidade;
	
	public MercadoriaDto(Mercadoria m) {
		this.id = m.getId();
		this.nome = m.getNome();
		this.descricao = m.getDescricao();
		this.preco = m.getPreco();
		this.quantidade = m.getQuantidade();
	}
	
	public MercadoriaDto() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	//Usando API de streams para fazer o mapeamento da mercadoria Entidade (Mercadoria)
	//para uma mercadoria Dto (MercadoriaDto), evitando assim de
	//passar qualquer tipo de acesso a classe entidade.
	public static List<MercadoriaDto> converter(List<Mercadoria> mercadorias) {
		return mercadorias.stream().map(MercadoriaDto::new).collect(Collectors.toList());
	}
}
