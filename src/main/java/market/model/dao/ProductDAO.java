package market.model.dao;

import javax.persistence.EntityManager;

import market.model.persistence.Product;

public class ProductDAO {

	private EntityManager entityManager;
	
	public ProductDAO(EntityManager entityManager) {
	this.entityManager = entityManager;
	}

	public void create(Product product) {
		this.entityManager.persist(product);
	}
}
