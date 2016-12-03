package com.lmp.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class generalException extends WebApplicationException{

	/**
	 *  General exception handling
	 */
	private static final long serialVersionUID = 1L;

	public generalException(String message){
		super(Response.status(Response.Status.BAD_REQUEST).entity(message).type(MediaType.TEXT_PLAIN).build());
	}
	public generalException(String message, Response.Status respStatus){
		super(Response.status(respStatus).entity(message).type(MediaType.TEXT_PLAIN).build());
	}
}
