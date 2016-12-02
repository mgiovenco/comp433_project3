/**
 * 
 */
package com.lmp.partner.service;
import java.util.Set;

import javax.jws.WebService;

import com.lmp.partner.model.PartnerRepresentation;
import com.lmp.partner.model.PartnerRequest;

@WebService
public interface PartnerService 
 {
	public Set<PartnerRepresentation> getPartners();
	public PartnerRepresentation getPartner(String partnerId);
	public PartnerRepresentation createPartner(PartnerRequest PartnerRequest);
}
