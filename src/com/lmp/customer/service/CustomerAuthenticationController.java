package com.lmp.customer.service;

import com.lmp.util.Authenticator;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/authentication")
public class CustomerAuthenticationController {

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/login")
	public boolean login(String email, String password) {
		System.out.println("###login invoked for email=" + email);

		try {
			return Authenticator.authenticate(email, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
