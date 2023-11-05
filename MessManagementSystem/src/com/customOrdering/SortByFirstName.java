package com.customOrdering;

import java.util.Comparator;

import com.core.Customer;

public class SortByFirstName implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		
		return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
	}
	
	

}
