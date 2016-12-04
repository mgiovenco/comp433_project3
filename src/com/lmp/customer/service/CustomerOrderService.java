package com.lmp.customer.service;

import com.lmp.customer.model.CustomerOrderRepresentation;
import com.lmp.customer.model.CustomerOrderRequest;
import com.lmp.customer.model.CustomerOrderStatusRepresentation;
import java.util.Set;

import javax.ws.rs.core.Response;

@WebService
public interface CustomerOrderService {
	public CustomerOrderRepresentation getCustomerOrder(String orderId);
	public CustomerOrderStatusRepresentation getCustomerOrderStatus(String orderId);
	public Response cancelCustomerOrder(String orderId);
	public Response shipCustomerOrder(String orderId);
	public Response sendFullfillmentAck(String orderId);
	public Response sendToPartners(String orderId);
	public CustomerOrderRepresentation createCustomerOrder(CustomerOrderRequest customerOrderRequest);
}
