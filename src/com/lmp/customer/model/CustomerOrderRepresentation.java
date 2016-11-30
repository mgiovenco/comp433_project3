package com.lmp.customer.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.lmp.global.AbstractRepresentation;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class CustomerOrderRepresentation extends AbstractRepresentation {

    private int id;
    private BigDecimal orderTotal;
    private String orderStatus;
    private String trackingId;
    
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
	
}
