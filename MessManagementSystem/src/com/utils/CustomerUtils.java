package com.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.core.Customer;
import com.core.MessPlan;

public class CustomerUtils {
	
	public static List<Customer> populateCustomer()
	{/*
		String firstName, String lastName, String email, String password, 
		String address, LocalDate registrationDate, LocalDate planEndDate, 
		String phoneNumber, MessPlan plan, double finalAmount
		*/
		List<Customer> customer = new ArrayList<>();
		
		customer.add(new Customer("vishal", "Ingle", "vishal@gmail.com", "vishal@123", "Beed", LocalDate.parse("2023-07-05"), LocalDate.parse("2023-08-05"), "9145037873", MessPlan.MONTHLY, MessPlan.MONTHLY.getPlanAmount()));
		customer.add(new Customer("pranav", "Patil", "pranav@gmail.com", "pranav@123", "Pune", LocalDate.parse("2023-04-01"), LocalDate.parse("2023-10-01"), "9875894724", MessPlan.HALFYEAR, MessPlan.HALFYEAR.getPlanAmount()));
		customer.add(new Customer("ajay", "Singh", "ajay@gmail.com", "ajay@123", "Latur", LocalDate.parse("2023-02-03"), LocalDate.parse("2024-02-03"), "7854789687", MessPlan.YEARLY, MessPlan.YEARLY.getPlanAmount()));
		customer.add(new Customer("vaibhav", "Ingle", "vaibhav@gmail.com", "vaibhav@123", "Kaij", LocalDate.parse("2023-03-03"), LocalDate.parse("2024-06-03"), "9875698747", MessPlan.QUARTERLY, MessPlan.QUARTERLY.getPlanAmount()));
		
		return customer;
		
	}

}
