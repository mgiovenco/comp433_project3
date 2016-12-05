package com.lmp.customer.service;

import java.sql.SQLException;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lmp.customer.dao.CustomerOrderDao;
import com.lmp.customer.model.CustomerOrderRepresentation;
import com.lmp.customer.model.CustomerOrderRequest;
import com.lmp.customer.model.CustomerOrderStatusRepresentation;
import com.lmp.product.dao.ProductDao;
import com.lmp.product.service.ProductActivity;
import javax.ws.rs.core.CacheControl;

@Path("/orderservice")
public class CustomerOrderResource implements CustomerOrderService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/orders/{orderId}")
	public CustomerOrderRepresentation getCustomerOrder(@PathParam("orderId") String orderId) {
		System.out.println("###getCustomerOrder invoked for orderId=" + orderId);
		CustomerOrderActivity customerOrderActivity = new CustomerOrderActivity(new CustomerOrderDao());
		
		try {
			return customerOrderActivity.getCustomerOrder(orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/orders/{orderId}/status")
	public CustomerOrderStatusRepresentation getCustomerOrderStatus(@PathParam("orderId") String orderId) {
		System.out.println("###getCustomerOrderStatus invoked for orderId=" + orderId);
		CustomerOrderActivity customerOrderActivity = new CustomerOrderActivity(new CustomerOrderDao());
		
		try {
			return customerOrderActivity.getCustomerOrderStatus(orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/orders/{orderId}")
	public CustomerOrderStatusRepresentation cancelCustomerOrder(@PathParam("orderId") String orderId) {
		System.out.println("###cancelOrder invoked for orderId=" + orderId);
		CustomerOrderActivity customerOrderActivity = new CustomerOrderActivity(new CustomerOrderDao());

		try {
			return customerOrderActivity.cancelCustomerOrder(orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/orders/{orderId}/ship")
	public CustomerOrderStatusRepresentation shipCustomerOrder(@PathParam("orderId") String orderId) {
		System.out.println("###shipCustomerOrder invoked for orderId=" + orderId);
		CustomerOrderActivity customerOrderActivity = new CustomerOrderActivity(new CustomerOrderDao());
		
		try {
			return customerOrderActivity.shipCustomerOrder(orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/orders/{orderId}/sendfullfillmentack")
	public CustomerOrderStatusRepresentation sendFullfillmentAck(@PathParam("orderId") String orderId) {
		System.out.println("###sendFullfillmentAck invoked for orderId=" + orderId);
		CustomerOrderActivity customerOrderActivity = new CustomerOrderActivity(new CustomerOrderDao());
		
		try {
			return customerOrderActivity.sendFullfilmentAck(orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/orders/{orderId}/sendtopartners")
	public CustomerOrderStatusRepresentation sendToPartners(@PathParam("orderId") String orderId) {
		System.out.println("###sendToPartners invoked for orderId=" + orderId);
		CustomerOrderActivity customerOrderActivity = new CustomerOrderActivity(new CustomerOrderDao());
		
		try {
			return customerOrderActivity.sendFullfilmentAck(orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/orders")
	public CustomerOrderRepresentation createCustomerOrder(CustomerOrderRequest customerOrderRequest) {
		System.out.println("POST METHOD Request: customerOrderRequest=" + customerOrderRequest);
		CustomerOrderActivity customerOrderActivity = new CustomerOrderActivity(new CustomerOrderDao());
        try {
			return customerOrderActivity.createCustomerOrder(customerOrderRequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
