package market.application;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import market.connection.JpaConnectionFactory;
import market.services.ProductService;

public class Program {
	
	private static final Logger LOG = LogManager.getLogger(Program.class);
	
	public static void main(String[] args) {
		EntityManager entityManager = new JpaConnectionFactory().getEntityManager();
		ProductService productService = new ProductService(entityManager);

		productService.delete(1L);
	}
}
