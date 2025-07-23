package com.users.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CompanyBankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long companyBankId;
	private long companyId;
	private String bankName;
	private String accountNumber;
	private String ifscCode;
	private String swiftCode;
	private String upi;
	private String panNumber;
	private String email;
	public CompanyBankDetails(long companyBankId, long companyId, String bankName, String accountNumber,
			String ifscCode, String swiftCode, String upi, String panNumber, String email) {
		super();
		this.companyBankId = companyBankId;
		this.companyId = companyId;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.swiftCode = swiftCode;
		this.upi = upi;
		this.panNumber = panNumber;
		this.email = email;
	}
	public CompanyBankDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCompanyBankId() {
		return companyBankId;
	}
	public void setCompanyBankId(long companyBankId) {
		this.companyBankId = companyBankId;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getSwiftCode() {
		return swiftCode;
	}
	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}
	public String getUpi() {
		return upi;
	}
	public void setUpi(String upi) {
		this.upi = upi;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
