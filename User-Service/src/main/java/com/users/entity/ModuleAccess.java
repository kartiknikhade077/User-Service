package com.users.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ModuleAccess {
	
	@Id
	@UuidGenerator
	private String moduleAccessId;
	private String companyId;
	private String employeeId;
	private boolean leadAccess;
	private boolean template;
	private boolean email;
	
	public ModuleAccess(String moduleAccessId, String companyId, String employeeId, boolean lead, boolean template,
			boolean email) {
		super();
		this.moduleAccessId = moduleAccessId;
		this.companyId = companyId;
		this.employeeId = employeeId;
		this.leadAccess = lead;
		this.template = template;
		this.email = email;
	}
	
	

	public ModuleAccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getModuleAccessId() {
		return moduleAccessId;
	}



	public void setModuleAccessId(String moduleAccessId) {
		this.moduleAccessId = moduleAccessId;
	}



	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	public String getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}



	public boolean isLeadAccess() {
		return leadAccess;
	}


	public void setLeadAccess(boolean leadAccess) {
		this.leadAccess = leadAccess;
	}



	public boolean isTemplate() {
		return template;
	}

	public void setTemplate(boolean template) {
		this.template = template;
	}

	public boolean isEmail() {
		return email;
	}

	public void setEmail(boolean email) {
		this.email = email;
	}
	
	
	
	
	
	
	

}
