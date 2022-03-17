package market.services;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CategoryService {

	private final Logger LOG = LogManager.getLogger(ProductService.class);

	private EntityManager entityManager;

	public CategoryService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
