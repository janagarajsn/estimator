package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.io.Serializable;
import java.util.Objects;

public class TechnologyId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String technology_name;
	private String activity_name;

	public TechnologyId() {
	}

	public TechnologyId(String technology_name, String activity_name) {
		this.technology_name = technology_name;
		this.activity_name = activity_name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TechnologyId CustomerId = (TechnologyId) o;
		return technology_name.equals(CustomerId.technology_name) && activity_name.equals(CustomerId.activity_name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(technology_name, activity_name);
	}
}
