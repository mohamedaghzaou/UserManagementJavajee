package com.userManagementJavaee.beans;

public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String Email;
	private String PhoneNumber;
	private String sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public User() {
		
	}
	public User(int id, String firstName, String lastName, String address, String email, String phoneNumber,
			String sex) {
		this(firstName,lastName,address,email,phoneNumber,sex);
		this.id = id;
		
	}
	public User(String firstName, String lastName, String address, String email, String phoneNumber, String sex) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		Email = email;
		PhoneNumber = phoneNumber;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + ", sex=" + sex + "]";
	}
	
	
}
