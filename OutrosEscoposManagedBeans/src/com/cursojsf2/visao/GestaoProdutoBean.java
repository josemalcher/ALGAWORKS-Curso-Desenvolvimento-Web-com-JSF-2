package com.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.cursojsf2.dominio.Produto;

@ManagedBean
//@ViewScoped
@RequestScoped //padr�o
//@NoneScoped
public class GestaoProdutoBean implements Serializable {
	private List<Produto> produtos;
	private Produto produto;
	
	public GestaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto getProduto() {
		return produto;
	}
	
	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou o Bean");
	}
	
	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizou o Bean");
	}
	
	
	
	
	
}
