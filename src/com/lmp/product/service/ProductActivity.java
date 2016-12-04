package com.lmp.product.service;

import com.lmp.global.Link;
import com.lmp.product.dao.ProductDao;
import com.lmp.product.model.Product;
import com.lmp.product.model.ProductRepresentation;

import java.math.BigDecimal;
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
		
		ProductRepresentation productRepresentation = null;
        if(product != null){
        	productRepresentation = new ProductRepresentation();
        	productRepresentation.setId(product.getId());
            productRepresentation.setName(product.getName());
            productRepresentation.setDescription(product.getDescription());
            productRepresentation.setCategory_id(product.getCategory_id());
            productRepresentation.setPartner_id(product.getPartner_id());
            productRepresentation.setPicture(product.getPicture());
            productRepresentation.setVendor_product_id(product.getVendor_product_id());
            productRepresentation.setPrice(new BigDecimal(9.95)); // just faking this out now for demo purposes
            
            // Add the link with other representations
            Link searchProduct = new Link("order product", "http://localhost:8081/orderservice/orders", "POST");	
            productRepresentation.setLinks(searchProduct);
        }
        
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
    
          // Add the link with other representations
          Link getAllProducts = new Link("Get All Products", "http://localhost:8081/productservice/products","GET");	
          productRepresentation.setLinks(getAllProducts);
                     
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
        
        // Add the link with other representations
        Link creatProduct = new Link("Creat Product", "http://localhost:8081/productservice/products","POST");	
        productRepresentation.setLinks(creatProduct);
        
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
