package com.company.hr;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private String gid;
	private String lastName;
	private String firstName;
	private long salary;
	private Set<String> privileges;


	public Employee() {}

	public long getSalary() {
		return salary;
	}
	
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public Set<String> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<String> privileges) {
		this.privileges = privileges;
	}	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isUserInRole(String role) {
		if(privileges == null) { return false; }
		else { return privileges.contains(role); }
	}
}
