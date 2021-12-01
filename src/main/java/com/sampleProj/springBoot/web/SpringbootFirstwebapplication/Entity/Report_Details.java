package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ReportDetailsKey.class)
public class Report_Details {
	
	@Id
	private int report_id;
	@Id
	private int scope_id;
	@Id
	private int techid;
	@Id
	private int task_id;
	private int effort;
	private String scope_Flag;
	private String created_by;
	private Date created_date;
	
	public Report_Details() {
		// TODO Auto-generated constructor stub
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public int getTechid() {
		return techid;
	}

	public void setTechid(int techid) {
		this.techid = techid;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public int getEffort() {
		return effort;
	}

	public void setEffort(int effort) {
		this.effort = effort;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_date() {
		return created_date;
	}


	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public int getScope_id() {
		return scope_id;
	}

	public void setScope_id(int scope_id) {
		this.scope_id = scope_id;
	}

	public String getScope_Flag() {
		return scope_Flag;
	}

	public void setScope_Flag(String scope_Flag) {
		this.scope_Flag = scope_Flag;
	}

	public Report_Details(int report_id, int scope_id, int techid, int task_id, int effort, String created_by,
			Date created_date, String scope_Flag) {
		super();
		this.report_id = report_id;
		this.scope_id = scope_id;
		this.techid = techid;
		this.task_id = task_id;
		this.effort = effort;
		this.created_by = created_by;
		this.created_date = created_date;
		this.scope_Flag = scope_Flag;
	}

	@Override
	public String toString() {
		return "Report_Details [report_id=" + report_id + ", scope_id=" + scope_id + ", techid=" + techid + ", task_id="
				+ task_id + ", effort=" + effort + ", created_by=" + created_by + ", created_date=" + created_date
				+ ", scope_Flag=" + scope_Flag + "]";
	}



		
}
