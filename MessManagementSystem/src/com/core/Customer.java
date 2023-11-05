package com.core;

import java.time.LocalDate;

public class Customer {
	/*
	 * Customer id(int) , first name(String), last name (String), email(String),
	 * password(String), Address String, RegisterDate(LocalDate),
	 * planEndDate(LocalDate), Address(String), Phone No(String),plan Enum,
	 * final_amount double
	 */

	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private LocalDate registrationDate;
	private LocalDate planEndDate;
	private String phoneNumber;
	private MessPlan plan;
	private double finalAmount;

	private static int idGenerator;

	static {

		idGenerator = 1001;
	}

	public Customer(String firstName, String lastName, String email, String password, String address,
			LocalDate registrationDate, LocalDate planEndDate, String phoneNumber, MessPlan plan, double finalAmount) {
		super();
		this.customerId = idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.registrationDate = registrationDate;
		this.planEndDate = planEndDate;
		this.phoneNumber = phoneNumber;
		this.plan = plan;
		this.finalAmount = finalAmount;
		idGenerator++;
	}

	public Customer(String email) {
		super();
		this.email = email;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public MessPlan getPlan() {
		return plan;
	}

	public void setPlan(MessPlan plan) {
		this.plan = plan;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public static int getIdGenerator() {
		return idGenerator;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", address=" + address + ", registrationDate=" + registrationDate
				+ ", planEndDate=" + planEndDate + ", phoneNumber=" + phoneNumber + ", plan=" + plan + ", finalAmount="
				+ finalAmount + "]";
	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof Customer) {
			return this.email.equals(((Customer) o).email);
		}

		return false;
	}

}
