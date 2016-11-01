package com.lmp.partner.service;


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
		
	public PartnerRepresentation getPartner(String id) throws SQLException {
		Partner partner = partnerDao.selectPartner(Integer.parseInt(id));
		
        PartnerRepresentation partnerRepresentation = new PartnerRepresentation();

        PartnerRepresentation.setCompanyName(partner.getCompanyName());
        PartnerRepresentation.setAddress(partner.getAddress());
        PartnerRepresentation.setCity(partner.getCity());
        PartnerRepresentation.setState(partner.getState());
        PartnerRepresentation.setPostalCode(partner.getPostalCode());
        PartnerRepresentation.setCountry(partner.getCountry());
        PartnerRepresentation.setPhone(partner.getPhone());
        PartnerRepresentation.setEmail(partner.getEmail());
        PartnerRepresentation.setURL(partner.getURL());
        PartnerRepresentation.set(partner.getLogo());
       
        return partnerRepresentation;
	}


}
