package com.lmp.product.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.lmp.global.AbstractRepresentation;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRepresentation extends AbstractRepresentation {

    private int id;
    private String vendor_product_id;
    private String name;
    private String description;
    private boolean product_available;
    private int category_id;
    private int partner_id;
    private String picture;
    private BigDecimal price;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductRepresentation [id=" + id + ", vendor_product_id=" + vendor_product_id + ", name=" + name
				+ ", description=" + description + ", product_available=" + product_available + ", category_id="
				+ category_id + ", partner_id=" + partner_id + ", picture=" + picture + ", price=" + price + "]";
	}
	
    
}
