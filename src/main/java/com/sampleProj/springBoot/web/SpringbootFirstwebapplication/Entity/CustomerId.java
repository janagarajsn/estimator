package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.io.Serializable;

public class CustomerId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String activity_name;
	private String customer_name;
	private String activity_type;

	public CustomerId() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activity_name == null) ? 0 : activity_name.hashCode());
		result = prime * result + ((activity_type == null) ? 0 : activity_type.hashCode());
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
		if (activity_type == null) {
			if (other.activity_type != null)
				return false;
		} else if (!activity_type.equals(other.activity_type))
			return false;
		if (customer_name == null) {
			if (other.customer_name != null)
				return false;
		} else if (!customer_name.equals(other.customer_name))
			return false;
		return true;
	}

	public CustomerId(String activity_name, String customer_name, String activity_type) {
		super();
		this.activity_name = activity_name;
		this.customer_name = customer_name;
		this.activity_type = activity_type;
	}

}