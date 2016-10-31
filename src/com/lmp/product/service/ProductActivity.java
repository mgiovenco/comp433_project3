package com.lmp.product.service;

import com.lmp.product.dao.ProductDao;
import com.lmp.product.model.Product;
import com.lmp.product.model.ProductRepresentation;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProductActivity {

	private ProductDao productDao;

	public ProductActivity(ProductDao productDao) {
		this.productDao = productDao;
	}

	public ProductRepresentation getProduct(String id) throws SQLException {
		Product product = productDao.selectProduct(Integer.parseInt(id));
		
        ProductRepresentation productRepresentation = new ProductRepresentation();
        productRepresentation.setId(product.getId());
        productRepresentation.setName(product.getName());
        productRepresentation.setDescription(product.getDescription());
        productRepresentation.setCategory_id(product.getCategory_id());
        productRepresentation.setPartner_id(product.getPartner_id());
        productRepresentation.setPicture(product.getPicture());
        productRepresentation.setVendor_product_id(product.getVendor_product_id());
        
        return productRepresentation;
	}

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
          productRepresentation.setCategory_id(product.getCategory_id());
          productRepresentation.setPartner_id(product.getPartner_id());
          productRepresentation.setPicture(product.getPicture());
          productRepresentation.setVendor_product_id(product.getVendor_product_id());
                    
          productRepresentations.add(productRepresentation);
        }
		
		return productRepresentations;
	}

	public ProductRepresentation createProduct(String vendorProductId, String name, String description, boolean productAvailable, int categoryId, int partnerId, String picture) throws Exception {
		Product product = new Product(vendorProductId, name, description, productAvailable, categoryId, partnerId, picture);
		
		productDao.createProduct(product);
		
        ProductRepresentation productRepresentation = new ProductRepresentation();
        productRepresentation.setId(product.getId());
        productRepresentation.setName(product.getName());
        productRepresentation.setDescription(product.getDescription());
        productRepresentation.setCategory_id(product.getCategory_id());
        productRepresentation.setPartner_id(product.getPartner_id());
        productRepresentation.setPicture(product.getPicture());
        productRepresentation.setVendor_product_id(product.getVendor_product_id());
        
        return productRepresentation;
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
