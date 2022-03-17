package market.model.dao;

import javax.persistence.EntityManager;

public class CategoryDAO {

private EntityManager entityManager;
	
	public CategoryDAO(EntityManager entityManager) {
	this.entityManager = entityManager;
	}
	
}
