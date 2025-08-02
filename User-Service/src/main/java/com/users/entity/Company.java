package com.users.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Company {
	

	@Id
	@UuidGenerator
	private String companyId;
	private int userId;
	private String companyName;
	private String companyEmail;
	private String companyLoginEmail;
	private String companyDescription;
	@Lob
    @Column(columnDefinition = "MEDIUMBLOB")
	private byte[] favicon;
	@Lob
    @Column(columnDefinition = "MEDIUMBLOB")
	private byte[] mainLogo;
	@Lob
    @Column(columnDefinition = "MEDIUMBLOB")
	private byte[] applogo;
	private String address;
	private String country;
	private String state;
	private String city;
	private String zipcode;
	private String phoneNumber;
	private String gstinNumber;
	private String defaultTimezone;
	public Company(String companyId, int userId, String companyName, String companyEmail, String companyDescription) {
		super();
		this.companyId = companyId;
		this.userId = userId;
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.companyDescription = companyDescription;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyDescription() {
		return companyDescription;
	}
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public byte[] getFavicon() {
		return favicon;
	}
	public void setFavicon(byte[] favicon) {
		this.favicon = favicon;
	}
	public byte[] getMainLogo() {
		return mainLogo;
	}
	public void setMainLogo(byte[] mainLogo) {
		this.mainLogo = mainLogo;
	}
	public byte[] getApplogo() {
		return applogo;
	}
	public void setApplogo(byte[] applogo) {
		this.applogo = applogo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGstinNumber() {
		return gstinNumber;
	}
	public void setGstinNumber(String gstinNumber) {
		this.gstinNumber = gstinNumber;
	}
	public String getDefaultTimezone() {
		return defaultTimezone;
	}
	public void setDefaultTimezone(String defaultTimezone) {
		this.defaultTimezone = defaultTimezone;
	}
	public String getCompanyLoginEmail() {
		return companyLoginEmail;
	}
	public void setCompanyLoginEmail(String companyLoginEmail) {
		this.companyLoginEmail = companyLoginEmail;
	}
	
	

}
