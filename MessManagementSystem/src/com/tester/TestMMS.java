package com.tester;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static com.utils.CustomerUtils.*;
import static com.customerValidations.CustomerValidations.*;

import com.core.Customer;
import com.core.MessPlan;
import com.customOrdering.SortByFirstName;
import com.customOrdering.SortByMessPlan;
import com.customOrdering.SortByRegistrationDate;

import static com.utils.CustomerMethods.*;

public class TestMMS {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			List<Customer> customer = populateCustomer();
			boolean exit = false;

			while (!exit) {
				System.out.println("\n1. SIGN UP 2. SIGN IN 3. Show All 4. Change Password 5. Sort by FirstName\n"
						+ "6. Sort by Mess Plan 7. Sort by Registration Date 8. Unsubscribe Customer");

				try {

					switch (sc.nextInt()) {
					case 1:
						System.out.println("firstName, lastName, email, password, address, registrationDate, phoneNumber, plan");
						Customer cust = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), customer);

						customer.add(cust);
						System.out.println("Customer Registered successfully...!");
						break;
						
					case 2:
						System.out.println("Enter Email and Password");
						authenticateUser(sc.next(), sc.next(), customer);
						
						break;
						
					case 3:
						System.out.println("All Customers:");
						Iterator<Customer> it = customer.iterator();
						while(it.hasNext())
						{
							System.out.println(it.next());
						}
						
						LocalDate l = LocalDate.parse("2023-05-06");
						System.out.println(l.plusMonths(6));
						
						
						break;
						
					case 4:
						System.out.println("Enter Email, OldPassword and NewPassword");
						changePassword(sc.next(), sc.next(), sc.next(), customer);
						break;
						
					case 5:
						Collections.sort(customer, new SortByFirstName());
						System.out.println("Data Sorted By First Name...!");
						
						break;
						
					case 6:
						Collections.sort(customer, new SortByMessPlan());
						System.out.println("Data Sorted By Mess Plan...!");
						break;
						
					case 7:
						Collections.sort(customer, new SortByRegistrationDate());
						System.out.println("Data Sorted By Registration Date...!");
						break;
					}

				} catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();
				}

			}

		}

	}

}
