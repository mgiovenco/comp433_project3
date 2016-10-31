package com.lmp.product.service;

import java.sql.SQLException;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lmp.product.dao.ProductDao;
import com.lmp.product.model.ProductRepresentation;

import javax.ws.rs.core.CacheControl;

@Path("/productservice/")
public class ProductResource implements ProductService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/product")
	public Set<ProductRepresentation> getProducts() {
		System.out.println("GET METHOD Request for all products .............");
        ProductActivity productActivity = new ProductActivity(new ProductDao());
        try {
			return productActivity.getAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}    
	}
}
