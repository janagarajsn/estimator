package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.io.Serializable;
import java.util.Objects;

public class CustomerId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String activity_name;
	private String customer_name;

	public CustomerId() {
	}

	public CustomerId(String customer_name, String activity_name) {
		this.customer_name = customer_name;
		this.activity_name = activity_name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CustomerId CustomerId = (CustomerId) o;
		return customer_name.equals(CustomerId.customer_name) && activity_name.equals(CustomerId.activity_name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer_name, activity_name);
	}
}
