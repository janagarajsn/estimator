package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Report {
	
	@Id
	@GeneratedValue
	private int report_id;
	private int scope_id;
	private int techid;
	private int task_id;
	private int cust_id;
	private int effort;
	private String created_by;
	private Date created_date;
	private String report_name;
	private String scope_Flag;
	
	public Report() {
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

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
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

	public String getReport_name() {
		return report_name;
	}

	public void setReport_name(String report_name) {
		this.report_name = report_name;
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

	@Override
	public String toString() {
		return "Report [report_id=" + report_id + ", scope_id=" + scope_id + ", techid=" + techid + ", task_id="
				+ task_id + ", cust_id=" + cust_id + ", effort=" + effort + ", created_by=" + created_by
				+ ", created_date=" + created_date + ", report_name=" + report_name + ", scope_Flag=" + scope_Flag
				+ "]";
	}

	public Report(int report_id, int scope_id, int techid, int task_id, int cust_id, int effort, String created_by,
			Date created_date, String report_name, String scope_Flag) {
		super();
		this.report_id = report_id;
		this.scope_id = scope_id;
		this.techid = techid;
		this.task_id = task_id;
		this.cust_id = cust_id;
		this.effort = effort;
		this.created_by = created_by;
		this.created_date = created_date;
		this.report_name = report_name;
		this.scope_Flag = scope_Flag;
	}


		
}
