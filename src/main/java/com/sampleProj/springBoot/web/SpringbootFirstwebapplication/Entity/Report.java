package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@IdClass(ReportKey.class)
public class Report {
	
	@GeneratedValue
	private int report_id;
	@Id
	@PrimaryKeyJoinColumn
	private String report_name;
	@Id
	private String activity_type;
	private int cust_id;
	private String created_by;
	private Date created_date;
	
	
	public Report() {
		// TODO Auto-generated constructor stub
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}


	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
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


	public String getActivity_type() {
		return activity_type;
	}

	public void setActivity_type(String activity_type) {
		this.activity_type = activity_type;
	}

	public Report(int report_id, String report_name, String activity_type, int cust_id, String created_by,
			Date created_date) {
		super();
		this.report_id = report_id;
		this.report_name = report_name;
		this.activity_type = activity_type;
		this.cust_id = cust_id;
		this.created_by = created_by;
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "Report [report_id=" + report_id + ", report_name=" + report_name + ", activity_type=" + activity_type
				+ ", cust_id=" + cust_id + ", created_by=" + created_by + ", created_date=" + created_date + "]";
	}



		
}
