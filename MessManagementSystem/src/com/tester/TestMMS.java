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
				System.out.println("\n1. SIGN UP 2. SIGN IN 3. Show All 4. Change Password 5. Sort Data  8. Unsubscribe Customer");
				System.out.println("6. Unsubscribe customer by plan(month wise (1, 3, 6, 12))");
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
						
						
						break;
						
					case 4:
						System.out.println("Enter Email, OldPassword and NewPassword");
						changePassword(sc.next(), sc.next(), sc.next(), customer);
						break;
						
					case 5:
						
						System.out.println("1. Sort by FirstName");
						System.out.println("2. Sort by Mess Plan");
						System.out.println("3. Sort by Registration Date");
						int ch = sc.nextInt();
						if(ch == 1)
						{
							Collections.sort(customer, new SortByFirstName());
							System.out.println("Data Sorted By First Name...!");
						}
						else if(ch == 2)
						{
							Collections.sort(customer, new SortByMessPlan());
							System.out.println("Data Sorted By Mess Plan...!");
						}
						else if(ch == 3)
						{
							Collections.sort(customer, new SortByRegistrationDate());
							System.out.println("Data Sorted By Registration Date...!");
						}
						else
						{
							System.out.println("Invalid Choice...!");
						}
						
						break;
						
					case 6:
						removeUserByPlan(customer);
						System.out.println("Expired Plan Customers removed...! ");
						break;
						
					case 7:
						changeFirstName(customer);
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
