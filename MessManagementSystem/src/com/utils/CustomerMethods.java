package com.utils;

import java.time.LocalDate;
import java.util.List;

import com.core.Customer;
import com.core.MessPlan;
import com.customExceptions.InvalidInputException;

public class CustomerMethods {

//	authenticate user (Login)
	public static void authenticateUser(String email, String password, List<Customer> list)
			throws InvalidInputException {
		Customer c = new Customer(email);
		int index = list.indexOf(c);

		if (index != -1) {
			c = list.get(index);

			if (c.getPassword().equals(password)) {
				System.out.println("Login Successful...!");
				System.out.println("WELCOME: " + email);
			} else {
				throw new InvalidInputException("Invalid Password....!!!");
			}
		} else {
			throw new InvalidInputException("Invalid Email...!!!");
		}
	}

//	Change the password
	public static void changePassword(String email, String oldPassword, String newPassword, List<Customer> list) throws InvalidInputException {
		Customer c = new Customer(email);

		int index = list.indexOf(c);

		if (index != -1) {
			c = list.get(index);
			
			if(c.getPassword().equals(oldPassword))
			{
				c.setPassword(newPassword);
				System.out.println("Password Changed...!");
			}
			else
			{
				throw new InvalidInputException("Incorrect old password...!!!");
			}

		} else {
			throw new InvalidInputException("Invalid Email...!!!");
		}
	}
	
//	remove user according to plan
	public static void removeUserByPlan(List<Customer> list)
	{
		
		list.removeIf(p->p.getPlanEndDate().isBefore(LocalDate.now()));
	}
	
	
//	Modify all customers first name (make first Letter capital of customers first name)
	public static void changeFirstName(List<Customer> list)
	{
		list.stream().forEach(p-> 
		{
		p.setFirstName(p.getFirstName().substring(0,1).toUpperCase()+p.getFirstName().substring(1));		
		}
		);
	}
}
