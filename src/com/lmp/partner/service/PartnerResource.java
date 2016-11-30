package com.lmp.partner.service;


import java.sql.SQLException;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import com.lmp.partner.dao.PartnerDao;
import com.lmp.partner.model.PartnerRepresentation;
import com.lmp.partner.model.PartnerRequest;
import com.lmp.product.dao.ProductDao;
import javax.ws.rs.core.CacheControl;

@Path("/partnerservice/")

public class PartnerResource implements PartnerService {
	

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partners")
	public Set<PartnerRepresentation> getPartners() {
		System.out.println("GET METHOD Request for all partners");
        PartnerActivity partnerActivity = new PartnerActivity(new PartnerDao());
        try {
			return partnerActivity.selectAllPartners();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}    
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partners/{partnerId}")
	public PartnerRepresentation getPartner(@PathParam("partnerId") String partnerId) {
		System.out.println("GET METHOD Request for one partner, partnerId=" + partnerId);
        PartnerActivity partnerActivity = new PartnerActivity(new PartnerDao());
		try {
			return partnerActivity.getPartner(partnerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/partner")
	public PartnerRepresentation createPartner(PartnerRequest  partnerRequest) {
		System.out.println("POST METHOD Request: partnerRequest=" + partnerRequest);
        PartnerActivity partnerActivity = new PartnerActivity(new PartnerDao());
        try {
			return partnerActivity.createPartner(partnerRequest.getId(),partnerRequest.getCompanyName(), partnerRequest.getAddress(), partnerRequest.getCity(), partnerRequest.getState(), partnerRequest.getPostalCode(), partnerRequest.getCountry(), partnerRequest.getPhone(), partnerRequest.getEmail(), partnerRequest.getURL(),partnerRequest.getLogo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
}
