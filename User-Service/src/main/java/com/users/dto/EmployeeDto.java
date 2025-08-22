package com.users.dto;

import jakarta.persistence.Column;

public class EmployeeDto {
	
	private int employeeId;
	private int userId;
	private int companyId;
	private String name;
	private String email;
	private String password;
	private String phone;
	@Column(length = 5000)
	private String description;
	private String department;
	private String gender;
	private String departmentId;
	private String roleId;
	private String roleName;
	
	//access module
	
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
	private boolean leadModuleAccess;
	private boolean leadViewAll;
	private boolean leadCreate;
	private boolean leadDelete;
	private boolean leadEdit;
	public EmployeeDto(int employeeId,int companyId, int userId, String name, String email, String phone, String description,
			String department, String gender, boolean leadAccess, boolean templateAccess, boolean emailAccess,String password) {
		super();
		this.employeeId = employeeId;
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.description = description;
		this.department = department;
		this.gender = gender;
		this.leadAccess = leadAccess;
		this.templateAccess = templateAccess;
		this.emailAccess = emailAccess;
		this.companyId=companyId;
		this.password=password;
		
	}
	
	
	// this is dto use while create employee

   

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(int employeeId, int userId, int companyId, String name, String email, String password,
			String phone, String description, String department, String gender, String departmentId, String roleId,
			String roleName, boolean leadAccess, boolean templateAccess, boolean emailAccess, boolean customerViewAll,
			boolean customerOwnView, boolean customerCreate, boolean customerDelete, boolean customerEdit,
			boolean projectViewAll, boolean projectOwnView, boolean projectCreate, boolean projectDelete,
			boolean projectEdit, boolean timeSheetAccess, boolean timeSheetViewAll, boolean timeSheetCreate,
			boolean timeSheetDelete, boolean timeSheetEdit, boolean leadModuleAccess, boolean leadViewAll,
			boolean leadCreate, boolean leadDelete, boolean leadEdit) {
		super();
		this.employeeId = employeeId;
		this.userId = userId;
		this.companyId = companyId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.description = description;
		this.department = department;
		this.gender = gender;
		this.departmentId = departmentId;
		this.roleId = roleId;
		this.roleName = roleName;
		this.leadAccess = leadAccess;
		this.templateAccess = templateAccess;
		this.emailAccess = emailAccess;
		this.customerViewAll = customerViewAll;
		this.customerOwnView = customerOwnView;
		this.customerCreate = customerCreate;
		this.customerDelete = customerDelete;
		this.customerEdit = customerEdit;
		this.projectViewAll = projectViewAll;
		this.projectOwnView = projectOwnView;
		this.projectCreate = projectCreate;
		this.projectDelete = projectDelete;
		this.projectEdit = projectEdit;
		this.timeSheetAccess = timeSheetAccess;
		this.timeSheetViewAll = timeSheetViewAll;
		this.timeSheetCreate = timeSheetCreate;
		this.timeSheetDelete = timeSheetDelete;
		this.timeSheetEdit = timeSheetEdit;
		this.leadModuleAccess = leadModuleAccess;
		this.leadViewAll = leadViewAll;
		this.leadCreate = leadCreate;
		this.leadDelete = leadDelete;
		this.leadEdit = leadEdit;
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


	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public void setTemplateAccess(boolean templateAccess) {
		this.templateAccess = templateAccess;
	}
	public boolean isEmailAccess() {
		return emailAccess;
	}
	public void setEmailAccess(boolean emailAccess) {
		this.emailAccess = emailAccess;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
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


	public boolean isLeadModuleAccess() {
		return leadModuleAccess;
	}


	public void setLeadModuleAccess(boolean leadModuleAccess) {
		this.leadModuleAccess = leadModuleAccess;
	}


	public boolean isLeadViewAll() {
		return leadViewAll;
	}


	public void setLeadViewAll(boolean leadViewAll) {
		this.leadViewAll = leadViewAll;
	}


	public boolean isLeadCreate() {
		return leadCreate;
	}


	public void setLeadCreate(boolean leadCreate) {
		this.leadCreate = leadCreate;
	}


	public boolean isLeadDelete() {
		return leadDelete;
	}


	public void setLeadDelete(boolean leadDelete) {
		this.leadDelete = leadDelete;
	}


	public boolean isLeadEdit() {
		return leadEdit;
	}


	public void setLeadEdit(boolean leadEdit) {
		this.leadEdit = leadEdit;
	}
	
	
	
	

}
