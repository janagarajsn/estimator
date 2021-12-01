package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.io.Serializable;

public class ReportDetailsKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int report_id;
	private int scope_id;
	private int techid;
	private int task_id;

	public ReportDetailsKey(int report_id, int scope_id, int techid, int task_id) {
		super();
		this.report_id = report_id;
		this.scope_id = scope_id;
		this.techid = techid;
		this.task_id = task_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + report_id;
		result = prime * result + scope_id;
		result = prime * result + task_id;
		result = prime * result + techid;
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
		ReportDetailsKey other = (ReportDetailsKey) obj;
		if (report_id != other.report_id)
			return false;
		if (scope_id != other.scope_id)
			return false;
		if (task_id != other.task_id)
			return false;
		if (techid != other.techid)
			return false;
		return true;
	}

	public ReportDetailsKey() {
		super();
		// TODO Auto-generated constructor stub
	}

}
