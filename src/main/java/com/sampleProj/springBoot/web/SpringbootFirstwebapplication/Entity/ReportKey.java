package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.io.Serializable;

public class ReportKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String report_name;
	private String activity_type;

	
	public ReportKey() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "ReportKey [report_name=" + report_name + ", activity_type=" + activity_type + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activity_type == null) ? 0 : activity_type.hashCode());
		result = prime * result + ((report_name == null) ? 0 : report_name.hashCode());
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
		ReportKey other = (ReportKey) obj;
		if (activity_type == null) {
			if (other.activity_type != null)
				return false;
		} else if (!activity_type.equals(other.activity_type))
			return false;
		if (report_name == null) {
			if (other.report_name != null)
				return false;
		} else if (!report_name.equals(other.report_name))
			return false;
		return true;
	}

}
