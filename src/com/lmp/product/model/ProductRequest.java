package com.lmp.product.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRequest {
	
    private String vendor_product_id;
    private String name;
    private String description;
    private boolean product_available;
    private int category_id;
    private int partner_id;
    private String picture;
	
	public String getVendor_product_id() {
		return vendor_product_id;
	}
	public void setVendor_product_id(String vendor_product_id) {
		this.vendor_product_id = vendor_product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isProduct_available() {
		return product_available;
	}
	public void setProduct_available(boolean product_available) {
		this.product_available = product_available;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

}
