package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.io.Serializable;

public class CustomerId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String activity_name;
	private String customer_name;

	public CustomerId() {
	}

	@Override
	public String toString() {
		return "CustomerId [activity_name=" + activity_name + ", customer_name=" + customer_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activity_name == null) ? 0 : activity_name.hashCode());
		result = prime * result + ((customer_name == null) ? 0 : customer_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerId other = (CustomerId) obj;
		if (activity_name == null) {
			if (other.activity_name != null)
				return false;
		} else if (!activity_name.equals(other.activity_name))
			return false;
		if (customer_name == null) {
			if (other.customer_name != null)
				return false;
		} else if (!customer_name.equals(other.customer_name))
			return false;
		return true;
	}


}