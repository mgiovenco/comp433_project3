package com.company.hr.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.company.hr.Employee;
import com.company.hr.EmployeeManager;
import com.company.hr.dal.EmployeeDAO;
import com.company.hr.service.representation.EmployeeRepresentation;

/**
 * This class' responsibility is to manage the workflow of accessing/creating/updating/deleting resources
 * using the EmployeeDOA object.  
 *
 */
public class EmployeeActivity {

	//private static EmployeeDAO dao = new EmployeeDAO();
	private static EmployeeManager em = new EmployeeManager();
	
	public Set<EmployeeRepresentation> getEmployees() {
		
		Set<Employee> employees = new HashSet<Employee>();
		Set<EmployeeRepresentation> employeeRepresentations = new HashSet<EmployeeRepresentation>();
		//employees = dao.getAllEmployees();
		employees = em.getAllEmployees();
		
		Iterator<Employee> it = employees.iterator();
		while(it.hasNext()) {
          Employee emp = (Employee)it.next();
          EmployeeRepresentation employeeRepresentation = new EmployeeRepresentation();
          employeeRepresentation.setGid(emp.getGid());
          employeeRepresentation.setFirstName(emp.getFirstName());
          employeeRepresentation.setLastName(emp.getLastName());
          
          //now add this representation in the list
          employeeRepresentations.add(employeeRepresentation);
        }
		return employeeRepresentations;
	}
	
	public EmployeeRepresentation getEmployee(String id) {
		
		//Employee emp = dao.getEmployee(id);
		Employee emp = em.getEmployee(id);
		
		EmployeeRepresentation empRep = new EmployeeRepresentation();
		empRep.setFirstName(emp.getFirstName());
		empRep.setLastName(emp.getLastName());
		empRep.setGid(emp.getGid());
		
		return empRep;
	}
	
	public EmployeeRepresentation createEmployee(String firstName, String lastName) {
		
		//Employee emp = dao.addEmployee(firstName, lastName);
		Employee emp = em.addEmployee(firstName, lastName);
		
		EmployeeRepresentation empRep = new EmployeeRepresentation();
		empRep.setFirstName(emp.getFirstName());
		empRep.setLastName(emp.getLastName());
		empRep.setGid(emp.getGid());
		
		return empRep;
	}
	
	public String deleteEmployee(String id) {
		
		//dao.deleteEmployee(id);
		em.deleteEmployee(id);
		
		return "OK";
	}
	
}
