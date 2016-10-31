package com.company.hr.service;


import java.util.Set;

import javax.jws.WebService;

import com.company.hr.service.representation.EmployeeRepresentation;
import com.company.hr.service.representation.EmployeeRequest;

@WebService
public interface EmployeeService {
	   
	public Set<EmployeeRepresentation> getEmployees();
	public EmployeeRepresentation getEmployee(String employeeId);
	public EmployeeRepresentation createEmployee(EmployeeRequest employeeRequest);
   
    //public Response updateEmployee(EmployeeRequest employeeRequest);
    //public Response deleteEmployee(String employeeId);
	
	

}
