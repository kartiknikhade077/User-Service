package com.users.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Departments {
    @Id
    @UuidGenerator
	private String departmentId;
	private String companyId;
	private String departmentName;
	private String departmentEmail;
	
	
	public Departments(String departmentId, String companyId, String departmentName,String departmentEmail) {
		super();
		this.departmentId = departmentId;
		this.companyId = companyId;
		this.departmentName = departmentName;
		this.departmentEmail=departmentEmail;
	}
	
	
	public Departments() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
    

	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getDepartmentEmail() {
		return departmentEmail;
	}


	public void setDepartmentEmail(String departmentEmail) {
		this.departmentEmail = departmentEmail;
	}

	
	
	
}
