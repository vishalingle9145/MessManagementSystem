package com.customOrdering;

import java.util.Comparator;

import com.core.Customer;

public class SortByRegistrationDate implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		
		return o1.getRegistrationDate().compareTo(o2.getRegistrationDate());
	}

}
