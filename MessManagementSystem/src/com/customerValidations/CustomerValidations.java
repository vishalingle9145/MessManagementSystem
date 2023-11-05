package com.customerValidations;

import java.time.LocalDate;
import java.util.List;

import com.core.Customer;
import com.core.MessPlan;
import com.customExceptions.InvalidInputException;

public class CustomerValidations {

	public static void parseAndValidateEmail(String email, List<Customer> list) throws InvalidInputException {
		Customer c = new Customer(email);

		if (list.contains(c)) {
			throw new InvalidInputException("Duplicate Email Id....!");
		}

	}
	
//	Email validation
	public static void validateEmail(String email, List<Customer> custList) throws InvalidInputException
	{
		//regex
		String pattern = "[a-z]+[a-z0-9]+@[a-z]*\\.(com)";
		if(!email.matches(pattern))
			throw new InvalidInputException("Invalid Email...Try again!!!");
	}

//	validate course
	public static MessPlan parseAndValidatePlan(String plan) throws InvalidInputException {
		return MessPlan.valueOf(plan.toUpperCase());
	}

//	Calculate next date on the basis of current date
	public static LocalDate validateEndDate(String startDate, String plan, List<Customer> list) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = null;
		MessPlan messplan = MessPlan.valueOf(plan.toUpperCase());

		if (messplan.equals(MessPlan.MONTHLY)) {
			end = start.plusMonths(1);

		} else if (messplan.equals(MessPlan.QUARTERLY)) {
			end = start.plusMonths(3);

		} else if (messplan.equals(MessPlan.HALFYEAR)) {
			end = start.plusMonths(6);

		} else if (messplan.equals(MessPlan.YEARLY)) {
			end = start.plusMonths(12);

		}
		return end;
	}

//	validate all inputs
	public static Customer validateAllInputs(String firstName, String lastName, String email, String password,
			String address, String registrationDate, String phoneNumber, String plan,
			List<Customer> list) throws InvalidInputException {

		validateEmail(email, list);
		parseAndValidateEmail(email, list);
		MessPlan messPlan = parseAndValidatePlan(plan);
		LocalDate endDate = validateEndDate(registrationDate, plan, list);

		return new Customer(firstName, lastName, email, password, address, LocalDate.parse(registrationDate), endDate,
				phoneNumber, messPlan, messPlan.getPlanAmount());
	}

}
