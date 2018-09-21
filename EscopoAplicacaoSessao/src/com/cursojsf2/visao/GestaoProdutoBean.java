package com.cursojsf2.visao;

import java.util.ArrayList;
import java.util.List;

//import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.cursojsf2.dominio.Produto;
@ManagedBean
//@ApplicationScoped
@SessionScoped
public class GestaoProdutoBean{
	
	private List<Produto> produtos;
	private Produto produto;
	
	public GestaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto  = new Produto();
	}

	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
}
