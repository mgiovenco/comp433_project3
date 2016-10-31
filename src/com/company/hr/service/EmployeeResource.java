package com.company.hr.service;


import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.CacheControl;

import com.company.hr.service.representation.EmployeeRepresentation;
import com.company.hr.service.representation.EmployeeRequest;
import com.company.hr.service.workflow.EmployeeActivity;

@Path("/employeeservice/")
public class EmployeeResource implements EmployeeService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/employee")
	//@Cacheable(cc="public, maxAge=3600") example for caching
	public Set<EmployeeRepresentation> getEmployees() {
		System.out.println("GET METHOD Request for all employees .............");
		EmployeeActivity empActivity = new EmployeeActivity();
		return empActivity.getEmployees();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/employee/{employeeId}")
	public EmployeeRepresentation getEmployee(@PathParam("employeeId") String id) {
		System.out.println("GET METHOD Request from Client with employeeRequest String ............." + id);
		EmployeeActivity empActivity = new EmployeeActivity();
		return empActivity.getEmployee(id);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/employee")
	public EmployeeRepresentation createEmployee(EmployeeRequest  employeeRequest) {
		System.out.println("POST METHOD Request from Client with ............." + employeeRequest.getFirstName() + "  " + employeeRequest.getLastName());
		EmployeeActivity empActivity = new EmployeeActivity();
		return empActivity.createEmployee(employeeRequest.getFirstName(), employeeRequest.getLastName());
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/employee/{employeeId}")
	public Response deleteEmployee(@PathParam("employeeId") String id) {
		System.out.println("Delete METHOD Request from Client with employeeRequest String ............." + id);
		EmployeeActivity empActivity = new EmployeeActivity();
		String res = empActivity.deleteEmployee(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
}