package market.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.RuntimeCryptoException;

import market.model.dao.ProductDAO;
import market.model.persistence.Product;

public class ProductService {

	private final Logger LOG = LogManager.getLogger(ProductService.class);

	private EntityManager entityManager;

	private ProductDAO productDAO;

	public ProductService(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.productDAO = new ProductDAO(entityManager);
	}

	public void create(Product product) {
		this.LOG.info("Preparando para a criação de um produto!");
		if (product == null) {
			this.LOG.error("O produto informado está nulo!");
			throw new RuntimeException("O produto está nulo!");
		}
		try {
			getBeginTransaction();
			this.productDAO.create(product);
			commitAndCloseTransaction();
		} catch (Exception e) {
			this.LOG.error("Erro ao criar um produto, causado por: " + e.getMessage());
			throw new RuntimeException("The ID is null");
		}
		this.LOG.info("Produto foi criado com sucesso");
	}

	private void commitAndCloseTransaction() {
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	private void getBeginTransaction() {
		entityManager.getTransaction().begin();
	}
	
	public void delete(Long id) {
		this.LOG.info("Preparando para procurar o produto");
		if(id==null) {
			this.LOG.error("o ID do produto está nulo");
			throw new RuntimeException("The ID is null");
		}
		Product product = this.productDAO.getById(id);
		if(product == null) {
			this.LOG.error("O produto não existe");
			throw new EntityNotFoundException("Product not found");
		}
		this.LOG.info("Produto encontrado com sucesso");
		getBeginTransaction();
		this.productDAO.delete(product);
		this.LOG.info("Produto deletado com sucesso");
		commitAndCloseTransaction();
	}
}
