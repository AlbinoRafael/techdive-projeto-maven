package market.services;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductService {

	private final Logger LOG = LogManager.getLogger(ProductService.class);

	private EntityManager entityManager;

	public ProductService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
