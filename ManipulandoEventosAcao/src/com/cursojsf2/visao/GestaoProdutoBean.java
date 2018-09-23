package com.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.cursojsf2.dominio.Produto;


@ManagedBean
@SessionScoped
public class GestaoProdutoBean implements Serializable {
	private List<Produto> produtos;
	private Produto produto;
	
	private Produto produtoSelecionado;
	
	public GestaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void incluir() {
		System.out.println("Incluindo!");
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto getProduto() {
		return produto;
	}
	
	
	
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou o Bean");
	}
	
	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizou o Bean");
	}
	
	public String obterAjuda() {
		if(this.produtos.isEmpty()) {
			return "AjudaGestaoProdto?faces-redirect=true";
		}else {
			return "AjudaGestaoProdtoTelefone?faces-redirect=true";
		}
	}
	
	public void verificarInclusao(ActionEvent event) {
		System.out.println("Verificando....");
		if("".equals(this.produto.getFabricante())) {
			this.produto.setFabricante("Sem Fabricante");
		}
	}
	
	public void excluir() {
		this.produtos.remove(this.produtoSelecionado);
	}
	
	
	
}
