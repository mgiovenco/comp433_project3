package com.lmp.product.service;

import com.company.hr.Employee;
import com.company.hr.service.representation.EmployeeRepresentation;
import com.lmp.product.dao.ProductDao;
import com.lmp.product.model.Product;
import com.lmp.product.model.ProductRepresentation;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This Service is to interact with product entities
 *
 */
public class ProductActivity {

	private ProductDao productDao;

	public ProductActivity(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * Get a product by id.
	 *
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Product getProduct(int id) throws SQLException {
		return productDao.selectProduct(id);
	}

	/**
	 * List all the available products.
	 *
	 * @return
	 * @throws SQLException
	 */
	public Set<ProductRepresentation> getAllProducts() throws SQLException {
		Set<ProductRepresentation> productRepresentations = new HashSet<ProductRepresentation>();
		Set<Product> products = productDao.getAllProducts();
		
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
          Product product = (Product) it.next();
          ProductRepresentation productRepresentation = new ProductRepresentation();
          productRepresentation.setId(product.getId());
          productRepresentation.setName(product.getName());
          productRepresentation.setDescription(product.getDescription());
          productRepresentation.setPartner_id(product.getPartner_id());
          productRepresentation.setPicture(product.getPicture());
          productRepresentation.setVendor_product_id(product.getVendor_product_id());
                    
          productRepresentations.add(productRepresentation);
        }
		
		return productRepresentations;
	}

	/**
	 * Add one product.
	 *
	 * @param product
	 * @throws Exception
	 */
	public void createProduct(Product product) throws Exception {
		productDao.createProduct(product);
	}

	/**
	 * Update a single product.
	 *
	 * @param product
	 */
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	public void updateProductAvailability(int id, boolean status) {
		productDao.updateProductAvailability(id, status);
	}

	/**
	 * Select all products belong to one category.
	 *
	 * @param id
	 */
	public List<Product> selectProductsByCategoryId(int id) throws SQLException {
		return productDao.selectProductsByCategoryId(id);

	}

}
