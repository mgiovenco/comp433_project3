package com.lmp.partner.service;


import com.lmp.customer.model.CustomerOrderRepresentation;
import com.lmp.global.Link;
import com.lmp.partner.dao.PartnerDao;
import com.lmp.partner.model.Partner;
import com.lmp.partner.model.PartnerRepresentation;
import com.lmp.partner.model.PartnerRequest;
import com.lmp.product.dao.ProductDao;
import com.lmp.product.model.Product;
import com.lmp.product.model.ProductRepresentation;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PartnerActivity {
	
	private PartnerDao partnerDao;

	public PartnerActivity(PartnerDao partnerDao) {
		this.partnerDao = partnerDao;
		}
		
	public PartnerRepresentation createPartner(int id, String companyName, String address, String city, String state, String postalCode, String country, String phone, String email, String URL, String logo) throws Exception {
		Partner partner = new Partner( id,companyName,  address,  city,  state,  postalCode,  country,  phone,  email,  URL,  logo);
		
		
        PartnerRepresentation partnerRepresentation = new PartnerRepresentation();

        partnerRepresentation.setCompanyName(partner.getCompanyName());      
        partnerRepresentation.setId(partner.getId());
        partnerRepresentation.setAddress(partner.getAddress());
        partnerRepresentation.setCity(partner.getCity());
        partnerRepresentation.setState(partner.getState());
        partnerRepresentation.setPostalCode(partner.getPostalCode());
        partnerRepresentation.setCountry(partner.getCountry());
        partnerRepresentation.setPhone(partner.getPhone());
        partnerRepresentation.setEmail(partner.getEmail());
        partnerRepresentation.setURL(partner.getURL());
        partnerRepresentation.setLogo(partner.getLogo());
        
     // Add the links
     		setLinks(partnerRepresentation);
       
        return partnerRepresentation;
	}

	/**
	 * Sets all the links appropriately, for each kind of representation based on state
	 * @param orderRep
	 */
	private void setLinks(PartnerRepresentation partnerRepresentation) {
		// Set up the activities that can be performed on orders
		Link create = new Link("createPartner", "http://api.mississippi.com:8080/bookstore/books/order?book_id=" + "123");	
		partnerRepresentation.setLinks(create);
	}


}
