package com.lmp.product.service;

import java.util.Set;

import javax.jws.WebService;

import com.company.hr.service.representation.EmployeeRepresentation;
import com.lmp.product.model.ProductRepresentation;
import com.lmp.product.model.ProductRequest;

@WebService
public interface ProductService {
	public Set<ProductRepresentation> getProducts();
	public ProductRepresentation getProduct(String productId);
	public ProductRepresentation createProduct(ProductRequest productRequest);
}
