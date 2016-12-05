package com.lmp.customer.service;

import com.lmp.customer.model.CustomerOrderRepresentation;
import com.lmp.customer.model.CustomerOrderRequest;
import com.lmp.customer.model.CustomerOrderStatusRepresentation;
import com.lmp.customer.model.CustomerRepresentation;

import javax.ws.rs.core.Response;

public interface CustomerOrderService {
	public CustomerOrderRepresentation getCustomerOrder(String orderId);
	public CustomerOrderStatusRepresentation getCustomerOrderStatus(String orderId);
	public CustomerOrderStatusRepresentation cancelCustomerOrder(String orderId);
	public CustomerOrderStatusRepresentation shipCustomerOrder(String orderId);
	public CustomerOrderStatusRepresentation sendFullfillmentAck(String orderId);
	public CustomerOrderStatusRepresentation sendToPartners(String orderId);
	public CustomerOrderRepresentation createCustomerOrder(CustomerOrderRequest customerOrderRequest);
	
	public CustomerRepresentation getCustomer(String custId);
}
