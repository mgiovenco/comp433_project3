package com.lmp.product.service;

import java.util.Set;

import javax.jws.WebService;

import com.lmp.product.model.ProductRepresentation;

@WebService
public interface ProductService {
	public Set<ProductRepresentation> getProducts();
}
