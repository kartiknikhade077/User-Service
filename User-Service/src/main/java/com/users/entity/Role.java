package com.users.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Role {
	@Id
	@UuidGenerator
	private String roleId;
	private String departmentId;
	private String companyId;
	private String roleName;
	
	// access module Name
	private boolean leadAccess;
	private boolean templateAccess;
	private boolean emailAccess;
	private boolean customerViewAll;
	private boolean customerOwnView;
	private boolean customerCreate;
	private boolean customerDelete;
	private boolean customerEdit;
	private boolean projectViewAll;
	private boolean projectOwnView;
	private boolean projectCreate;
	private boolean projectDelete;
	private boolean projectEdit;
	private boolean timeSheetAccess;
	private boolean timeSheetViewAll;
	private boolean timeSheetCreate;
	private boolean timeSheetDelete;
	private boolean timeSheetEdit;
	public Role(String roleId, String departmentId, String companyId, String roleName, boolean leadAccess,
			boolean templateAccess, boolean emailAccess) {
		super();
		this.roleId = roleId;
		this.departmentId = departmentId;
		this.companyId = companyId;
		this.roleName = roleName;
		this.leadAccess = leadAccess;
		this.templateAccess = templateAccess;
		this.emailAccess = emailAccess;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public boolean isLeadAccess() {
		return leadAccess;
	}
	public void setLeadAccess(boolean leadAccess) {
		this.leadAccess = leadAccess;
	}
	public boolean isTemplateAccess() {
		return templateAccess;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public void setTemplateAccess(boolean templateAccess) {
		this.templateAccess = templateAccess;
	}
	public boolean isEmailAccess() {
		return emailAccess;
	}
	public void setEmailAccess(boolean emailAccess) {
		this.emailAccess = emailAccess;
	}
	public boolean isCustomerViewAll() {
		return customerViewAll;
	}
	public void setCustomerViewAll(boolean customerViewAll) {
		this.customerViewAll = customerViewAll;
	}
	public boolean isCustomerOwnView() {
		return customerOwnView;
	}
	public void setCustomerOwnView(boolean customerOwnView) {
		this.customerOwnView = customerOwnView;
	}
	public boolean isCustomerCreate() {
		return customerCreate;
	}
	public void setCustomerCreate(boolean customerCreate) {
		this.customerCreate = customerCreate;
	}
	public boolean isCustomerDelete() {
		return customerDelete;
	}
	public void setCustomerDelete(boolean customerDelete) {
		this.customerDelete = customerDelete;
	}
	public boolean isCustomerEdit() {
		return customerEdit;
	}
	public void setCustomerEdit(boolean customerEdit) {
		this.customerEdit = customerEdit;
	}
	public boolean isProjectViewAll() {
		return projectViewAll;
	}
	public void setProjectViewAll(boolean projectViewAll) {
		this.projectViewAll = projectViewAll;
	}
	public boolean isProjectOwnView() {
		return projectOwnView;
	}
	public void setProjectOwnView(boolean projectOwnView) {
		this.projectOwnView = projectOwnView;
	}
	public boolean isProjectCreate() {
		return projectCreate;
	}
	public void setProjectCreate(boolean projectCreate) {
		this.projectCreate = projectCreate;
	}
	public boolean isProjectDelete() {
		return projectDelete;
	}
	public void setProjectDelete(boolean projectDelete) {
		this.projectDelete = projectDelete;
	}
	public boolean isProjectEdit() {
		return projectEdit;
	}
	public void setProjectEdit(boolean projectEdit) {
		this.projectEdit = projectEdit;
	}
	public boolean isTimeSheetAccess() {
		return timeSheetAccess;
	}
	public void setTimeSheetAccess(boolean timeSheetAccess) {
		this.timeSheetAccess = timeSheetAccess;
	}
	public boolean isTimeSheetViewAll() {
		return timeSheetViewAll;
	}
	public void setTimeSheetViewAll(boolean timeSheetViewAll) {
		this.timeSheetViewAll = timeSheetViewAll;
	}
	public boolean isTimeSheetCreate() {
		return timeSheetCreate;
	}
	public void setTimeSheetCreate(boolean timeSheetCreate) {
		this.timeSheetCreate = timeSheetCreate;
	}
	public boolean isTimeSheetDelete() {
		return timeSheetDelete;
	}
	public void setTimeSheetDelete(boolean timeSheetDelete) {
		this.timeSheetDelete = timeSheetDelete;
	}
	public boolean isTimeSheetEdit() {
		return timeSheetEdit;
	}
	public void setTimeSheetEdit(boolean timeSheetEdit) {
		this.timeSheetEdit = timeSheetEdit;
	}
	
	
	

}
