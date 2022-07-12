package br.com.fabio.gerenciamento.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fabio.gerenciamento.model.Produto;

public class ProdutoService {
	EntityManager entityManager = Persistence.createEntityManagerFactory("ServicoVendas").createEntityManager();


	public void insertProduto(Produto produto) {
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(produto);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}


	public Produto bucaProdutoPorId(int id) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("ServicoVendas").createEntityManager();
		
		Produto produto = entityManager.find(Produto.class, id);
		
		return produto;

	}

	public Produto[] buscaTodosProdutos() {
		
		EntityManager entityManager = Persistence.createEntityManagerFactory("ServicoVendas").createEntityManager();
		Produto[][] retorno = null;
		List<Produto> produtos;

		try {
			produtos = entityManager.createQuery("select a from Produto a", Produto.class)
					.getResultList();
		} finally {
			entityManager.close();
		}
		

		Produto[] retVal = new Produto[produtos.size()];
		for (int i = 0; i < produtos.size(); i++) {
		    retVal[i] = (Produto) produtos.get(i);
		}		
		
		return retVal;
	}
	
	
	public String retornaNome() {
		return "Fábio Damas";
	}
	
	
	

	
}
