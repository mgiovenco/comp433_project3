package com.lmp.order.service;

import com.lmp.order.service.TestFulfillOrder;

public class TestFulfillOrder {

	public static void main(String[] args) {
		
		boolean isOrderFulfilled = false;
		int orderID = 1;
		OrderDomain orderDomain = new OrderDomain();
		isOrderFulfilled = orderDomain.fulfillOrder(orderID);
		if(isOrderFulfilled){
			System.out.println("Order Delivered");
		}
	}

}

