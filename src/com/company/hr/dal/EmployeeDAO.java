package com.company.hr.dal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.company.hr.Employee;

public class EmployeeDAO{

	private static Set<Employee> employees = new HashSet<Employee>();
		
	public  EmployeeDAO() {
		Employee employee = new Employee();
	    
		employee.setGid("XY1111");
		employee.setFirstName("John");
		employee.setLastName("Smith");
		employee.setSalary(2350);
		Set<String> privileges = new HashSet<String>();
		privileges.add("Free Lunch");
		privileges.add("Medical Benefits");
		employee.setPrivileges(privileges);
	
		employees.add(employee);
	}
		
	public Set<Employee> getAllEmployees(){
		return employees;
	}
	
	public Employee getEmployee(String id) {
		Iterator<Employee> it = employees.iterator();
		while(it.hasNext()) {
          Employee emp = (Employee)it.next();
          if (emp.getGid().equals(id)) {
        	  return emp;
          }
        }
		return null;
	}
	
	public Employee addEmployee(String firstName, String lastName) {
		Employee employee = new Employee();
		
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    long randomLong = randomGenerator.nextLong();
	    String id = "XY" + randomInt;
	    
		employee.setGid(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(randomLong);
		Set<String> privileges = new HashSet<String>();
		privileges.add("Free Lunch");
		employee.setPrivileges(privileges);
	
		employees.add(employee);
		
		return employee;
	}
	
	public void updateEmployee(String id, long salary) {
		Iterator<Employee> it = employees.iterator();
		while(it.hasNext()) {
          Employee emp = (Employee)it.next();
          if (emp.getGid().equals(id)) {
        	  emp.setSalary(salary);
        	  return;
          }
        }
	}
	
	public void deleteEmployee(String id) {
		Iterator<Employee> it = employees.iterator();
		while(it.hasNext()) {
          Employee emp = (Employee)it.next();
          if (emp.getGid().equals(id)) {
        	  employees.remove(emp);
        	  return;
          }
        }
	}
		
}