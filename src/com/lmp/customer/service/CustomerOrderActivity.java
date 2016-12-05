package com.lmp.customer.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.lmp.customer.dao.CustomerOrderDao;
import com.lmp.customer.model.CustomerOrder;
import com.lmp.customer.model.CustomerOrderDetail;
import com.lmp.customer.model.CustomerOrderRepresentation;
import com.lmp.customer.model.CustomerOrderRequest;
import com.lmp.customer.model.CustomerOrderStatusRepresentation;
import com.lmp.customer.model.Payment;
import com.lmp.global.Link;


public class CustomerOrderActivity {

    private CustomerOrderDao customerOrderDao;

    public CustomerOrderActivity(CustomerOrderDao customerOrderDao) {
        this.customerOrderDao = customerOrderDao;
    }

    public CustomerOrderRepresentation getCustomerOrder(String id) throws SQLException {
        CustomerOrder customerOrder = customerOrderDao.selectCustomerOrder(Integer.parseInt(id));

        CustomerOrderRepresentation customerOrderRepresentation = new CustomerOrderRepresentation();
        customerOrderRepresentation.setId(customerOrder.getId());
        customerOrderRepresentation.setOrderTotal(customerOrder.getOrderTotal());
        customerOrderRepresentation.setOrderStatus(customerOrder.getOrderStatus());
        customerOrderRepresentation.setTrackingId(customerOrder.getTrackingId());
        
     // Add the link with other representations
        Link getCustomerOrder = new Link("Get Customer Order", "GET", "http://localhost:8081/orderservice/orders?orderId="+customerOrder.getId(), "application/json");	
        customerOrderRepresentation.setLinks(getCustomerOrder);
        
        return customerOrderRepresentation;
    }

    public CustomerOrderStatusRepresentation getCustomerOrderStatus(String id) throws SQLException {
        CustomerOrder customerOrder = customerOrderDao.selectCustomerOrder(Integer.parseInt(id));
        
        CustomerOrderStatusRepresentation customerOrderStatusRepresentation = new CustomerOrderStatusRepresentation();
        customerOrderStatusRepresentation.setOrderStatus(customerOrder.getOrderStatus());
        
        
        // Add the link with other representations
        Link orderStatusLink = new Link("Check Order Status", "GET", "http://localhost:8081/orderservice/orders/" + id + "/status", "application/json");
        customerOrderStatusRepresentation.setLinks(orderStatusLink);
        
        return customerOrderStatusRepresentation;
    }


    public CustomerOrderStatusRepresentation cancelCustomerOrder(String id) throws Exception {
    	CustomerOrder customerOrder = customerOrderDao.selectCustomerOrder(Integer.parseInt(id));
    	
    	customerOrder.setOrderStatus("CANCELED");
    	customerOrderDao.updateCustomerOrder(customerOrder);
    	
    	 // Add the link with other representations
        CustomerOrderStatusRepresentation customerOrderStatusRepresentation = new CustomerOrderStatusRepresentation();
        customerOrderStatusRepresentation.setOrderStatus(customerOrder.getOrderStatus());
        
        Link orderStatusLink = new Link("Check Order Status", "GET", "http://localhost:8081/orderservice/orders/" + id + "/status", "application/json");
        customerOrderStatusRepresentation.setLinks(orderStatusLink);
    	
        return customerOrderStatusRepresentation;
    }
    
    public CustomerOrderStatusRepresentation shipCustomerOrder(String id) throws Exception {
    	CustomerOrder customerOrder = customerOrderDao.selectCustomerOrder(Integer.parseInt(id));
    	
    	customerOrder.setOrderStatus("SHIPPED");
    	customerOrderDao.updateCustomerOrder(customerOrder);
    	
        CustomerOrderStatusRepresentation customerOrderStatusRepresentation = new CustomerOrderStatusRepresentation();

        Link orderStatusLink = new Link("Check Order Status", "GET", "http://localhost:8081/orderservice/orders/" + id + "/status", "application/json");
        customerOrderStatusRepresentation.setLinks(orderStatusLink);
    	
        return customerOrderStatusRepresentation;
    }
    
    public CustomerOrderStatusRepresentation sendFullfilmentAck(String id) throws Exception {
    	CustomerOrder customerOrder = customerOrderDao.selectCustomerOrder(Integer.parseInt(id));
    	
    	// TODO: This would interact with another system.  In the meantime, will just do nothing as long as something is found.
        CustomerOrderStatusRepresentation customerOrderStatusRepresentation = new CustomerOrderStatusRepresentation();

        Link orderStatusLink = new Link("Check Order Status", "GET", "http://localhost:8081/orderservice/orders/" + id + "/status", "application/json");
        customerOrderStatusRepresentation.setLinks(orderStatusLink);
    	
        return customerOrderStatusRepresentation;
    }
    
    public CustomerOrderStatusRepresentation sendToPartners(String id) throws Exception {
    	customerOrderDao.selectCustomerOrder(Integer.parseInt(id));
    	
    	// TODO: This would interact with another system.  In the meantime, will just do nothing as long as something is found.
        CustomerOrderStatusRepresentation customerOrderStatusRepresentation = new CustomerOrderStatusRepresentation();
    	
        Link orderStatusLink = new Link("Check Order Status", "GET", "http://localhost:8081/orderservice/orders/" + id + "/status", "application/json");
        customerOrderStatusRepresentation.setLinks(orderStatusLink);
    	
        return customerOrderStatusRepresentation;
    }
    

    public CustomerOrderRepresentation createCustomerOrder(CustomerOrderRequest customerOrderRequest) throws Exception {
        
    	CustomerOrder customerOrder = new CustomerOrder(customerOrderRequest.getId(), customerOrderRequest.getOrderTotal(), customerOrderRequest.getOrderStatus(), customerOrderRequest.getTrackingId(), customerOrderRequest.getCustomerId(),customerOrderRequest.getBillingInfoId(),customerOrderRequest.getShippingInfoId());
        
        int orderId = customerOrderDao.createCustomerOrder(customerOrder);
    	
        CustomerOrderRepresentation customerOrderRepresentation = new CustomerOrderRepresentation();
        customerOrderRepresentation.setId(orderId);
        customerOrderRepresentation.setOrderStatus(customerOrder.getOrderStatus());
        customerOrderRepresentation.setOrderTotal(customerOrder.getOrderTotal());
        customerOrderRepresentation.setTrackingId(customerOrder.getTrackingId());
        
        // Add the link with other representations
        Link orderStatusLink = new Link("Check Order Status", "GET", "http://localhost:8081/orderservice/orders/" + orderId + "/status","application/json");
        Link cancelOrderLink = new Link("Cancel Order", "DELETE", "http://localhost:8081/orderservice/orders/" + orderId, "application/json");
        
        customerOrderRepresentation.setLinks(orderStatusLink, cancelOrderLink);
        
        return customerOrderRepresentation;
    }
    

    /**
     * ADd single payment.
     *
     * @param payment
     */
    public void addPayment(Payment payment) throws Exception {
        customerOrderDao.createPayment(payment);
    }

    /**
     * Get payment by id.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Payment getPayment(int id) throws SQLException {
        return customerOrderDao.selectPayment(id);
    }

    /**
     * Update a single payment.
     *
     * @param id
     * @param status
     */
    public void updatePayment(int id, String status) {
        customerOrderDao.updatePayment(id, status);
    }

    /**
     * Get all payments by customer order id.
     *
     * @param id
     * @return
     */
    public List<Payment> getPaymentsByOrderId(int id) {
        return customerOrderDao.selectPaymentsByOrderId(id);
    }

    /**
     * Create single customer order detail.
     *
     * @param customerOrderDetail
     */
    public void addCustomerOrderDetail(CustomerOrderDetail customerOrderDetail) throws Exception {
        customerOrderDao.createCustomerOrderDetail(customerOrderDetail);
    }
    
	
}
