package com.lmp.customer.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

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
        Link getCustomerOrder = new Link("Get Customer Order", "http://localhost:8081/orderservice/orders?orderId="+customerOrder.getId(),"GET");	
        customerOrderRepresentation.setLinks(getCustomerOrder);
        
        return customerOrderRepresentation;
    }

    public CustomerOrderStatusRepresentation getCustomerOrderStatus(String id) throws SQLException {
        CustomerOrder customerOrder = customerOrderDao.selectCustomerOrder(Integer.parseInt(id));
        
        CustomerOrderStatusRepresentation customerOrderStatusRepresentation = new CustomerOrderStatusRepresentation();
        customerOrderStatusRepresentation.setOrderStatus(customerOrder.getOrderStatus());
        
        
     // Add the link with other representations
        Link CustomerOrderStatus = new Link("Get Customer Order Status ", "http://localhost:8081/orderservice/orders?orderId="+customerOrder.getId()+"/status","GET");	
        customerOrderStatusRepresentation.setLinks(CustomerOrderStatus);
        
        return customerOrderStatusRepresentation;
    }


    public String cancelCustomerOrder(String id) throws Exception {
    	CustomerOrder customerOrder = customerOrderDao.selectCustomerOrder(Integer.parseInt(id));
    	
    	customerOrder.setOrderStatus("CANCELED");
    	customerOrderDao.updateCustomerOrder(customerOrder);
    	
    	 // Add the link with other representations
        CustomerOrderStatusRepresentation customerOrderStatusRepresentation = new CustomerOrderStatusRepresentation();

        Link cancelCustomerOrder = new Link("cancelCustomerOrder", "http://localhost:8081/orderservice/orders?orderId="+customerOrder.getId(),"DELETE");	
        customerOrderStatusRepresentation.setLinks(cancelCustomerOrder);
    	
    	return "OK";
    }
    
    public String shipCustomerOrder(String id) throws Exception {
    	CustomerOrder customerOrder = customerOrderDao.selectCustomerOrder(Integer.parseInt(id));
    	
    	customerOrder.setOrderStatus("SHIPPED");
    	customerOrderDao.updateCustomerOrder(customerOrder);
    	
    	 // Add the link with other representations
        CustomerOrderStatusRepresentation customerOrderStatusRepresentation = new CustomerOrderStatusRepresentation();

        Link shipCustomerOrder = new Link("Ship Customer Order", "http://localhost:8081/orderservice/orders?orderId="+customerOrder.getId()+"/ship","POST");	
        customerOrderStatusRepresentation.setLinks(shipCustomerOrder);
    	
    	return "OK";
    }
    
    public String sendFullfilmentAck(String id) throws Exception {
    	CustomerOrder customerOrder = customerOrderDao.selectCustomerOrder(Integer.parseInt(id));
    	
    	// TODO: This would interact with another system.  In the meantime, will just do nothing as long as something is found.
    	
    	 // Add the link with other representations
        CustomerOrderStatusRepresentation customerOrderStatusRepresentation = new CustomerOrderStatusRepresentation();

        Link sendFullfilmentAck = new Link("Send Fullfilment Ack", "http://localhost:8081/orderservice/orders?orderId="+customerOrder.getId()+"/sendfullfillmentack","POST");	
        customerOrderStatusRepresentation.setLinks(sendFullfilmentAck);
    	
    	return "OK";
    }
    
    public String sendToPartners(String id) throws Exception {
    	customerOrderDao.selectCustomerOrder(Integer.parseInt(id));
    	
    	// TODO: This would interact with another system.  In the meantime, will just do nothing as long as something is found.
    	
    	return "OK";
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
        Link sendToPartners = new Link("Send To Partners", "http://localhost:8081/orderservice/orders?orderId="+customerOrder.getId()+"/sendtopartners","POST");	
        customerOrderRepresentation.setLinks(sendToPartners);
        
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
