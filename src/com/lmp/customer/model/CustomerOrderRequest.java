package com.lmp.customer.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class CustomerOrderRequest {

    private int id;
    private BigDecimal orderTotal;
    private String orderStatus;
    private String trackingId;
    private int customerId;
    private int billingInfoId;
    private int shippingInfoId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBillingInfoId() {
		return billingInfoId;
	}
	public void setBillingInfoId(int billingInfoId) {
		this.billingInfoId = billingInfoId;
	}
	public int getShippingInfoId() {
		return shippingInfoId;
	}
	public void setShippingInfoId(int shippingInfoId) {
		this.shippingInfoId = shippingInfoId;
	}
    
}
