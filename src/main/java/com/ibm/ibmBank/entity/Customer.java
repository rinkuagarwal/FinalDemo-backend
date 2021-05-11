package com.ibm.ibmBank.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Customer {
	@NotNull
	private String name;
	
	@NotNull
	private long mobileNumber;
	@NotNull
	private Address address;
	@Email
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
