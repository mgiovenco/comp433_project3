/**
 * 
 */
package com.lmp.partner.service;
import javax.jws.WebService;

import com.lmp.partner.model.PartnerRepresentation;
import com.lmp.partner.model.PartnerRequest;

@WebService
public interface PartnerService 
 {
	public PartnerRepresentation createPartner(PartnerRequest PartnerRequest);
}
