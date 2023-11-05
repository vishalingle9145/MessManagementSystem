package com.utils;

import java.util.List;

import com.core.Customer;
import com.customExceptions.InvalidInputException;

public class CustomerMethods {

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

}
