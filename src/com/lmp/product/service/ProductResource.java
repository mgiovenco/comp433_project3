package com.lmp.product.service;

import java.sql.SQLException;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.company.hr.service.representation.EmployeeRepresentation;
import com.company.hr.service.representation.EmployeeRequest;
import com.company.hr.service.workflow.EmployeeActivity;
import com.lmp.product.dao.ProductDao;
import com.lmp.product.model.ProductRepresentation;
import com.lmp.product.model.ProductRequest;

import javax.ws.rs.core.CacheControl;

@Path("/productservice/")
public class ProductResource implements ProductService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	public Set<ProductRepresentation> getProducts() {
		System.out.println("GET METHOD Request for all products");
        ProductActivity productActivity = new ProductActivity(new ProductDao());
        try {
			return productActivity.getAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}    
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products/{productId}")
	public ProductRepresentation getProduct(@PathParam("productId") String productId) {
		System.out.println("GET METHOD Request for single product, productId=" + productId);
        ProductActivity productActivity = new ProductActivity(new ProductDao());
		try {
			return productActivity.getProduct(productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	public ProductRepresentation createProduct(ProductRequest  productRequest) {
		System.out.println("POST METHOD Request: productRequest=" + productRequest);
        ProductActivity productActivity = new ProductActivity(new ProductDao());
        try {
			return productActivity.createProduct(productRequest.getVendor_product_id(), productRequest.getName(), productRequest.getDescription(), productRequest.isProduct_available(), productRequest.getCategory_id(), productRequest.getPartner_id(), productRequest.getPicture());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
}
