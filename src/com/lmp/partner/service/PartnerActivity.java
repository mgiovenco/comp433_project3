package com.lmp.partner.service;


import com.lmp.global.Link;
import com.lmp.partner.dao.PartnerDao;
import com.lmp.partner.model.Partner;
import com.lmp.partner.model.PartnerRepresentation;
import com.lmp.partner.model.PartnerRequest;

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
        

        // Add the link with other representations
        Link searchPartner = new Link("partner by ID", "http://localhost:8081/partnerservice/partners?partnerId="+partner.getId(),"GET");	
        partnerRepresentation.setLinks(searchPartner);
        return partnerRepresentation;
        }
		
	public Set<PartnerRepresentation> selectAllPartners() throws SQLException {
		Set<PartnerRepresentation> partnerRepresentations = new HashSet<PartnerRepresentation>();
		List<Partner> partners = partnerDao.selectAllPartners();
		
		Iterator<Partner> it = partners.iterator();
		while(it.hasNext()) {
			Partner partner = (Partner) it.next();

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
            
	        partnerRepresentations.add(partnerRepresentation);
          
	        // Add the link with other representations
			
			Link selectAllPartners = new Link("Select All Partners", "http://localhost:8081/partnerservice/allPartners","GET");	
			partnerRepresentation.setLinks(selectAllPartners);
			
		
		}
		return partnerRepresentations;
	}
	
	public PartnerRepresentation createPartner( String companyName, String address, String city, String state, String postalCode, String country, String phone, String email, String URL, String logo) throws Exception {
		Partner partner = new Partner(companyName,  address,  city,  state,  postalCode,  country,  phone,  email,  URL,  logo);
		
		partnerDao.createPartner(partner);
		
        PartnerRepresentation partnerRepresentation = new PartnerRepresentation();


        partnerRepresentation.setCompanyName(partner.getCompanyName());      
        partnerRepresentation.setAddress(partner.getAddress());
        partnerRepresentation.setCity(partner.getCity());
        partnerRepresentation.setState(partner.getState());
        partnerRepresentation.setPostalCode(partner.getPostalCode());
        partnerRepresentation.setCountry(partner.getCountry());
        partnerRepresentation.setPhone(partner.getPhone());
        partnerRepresentation.setEmail(partner.getEmail());
        partnerRepresentation.setURL(partner.getURL());
        partnerRepresentation.setLogo(partner.getLogo());
        
     // Add the link with other representations
        Link createPartner = new Link("createPartner", "http://localhost:8081/partnerservice/newPartner","POST");	
		partnerRepresentation.setLinks(createPartner);
       
        return partnerRepresentation;
	}




}
