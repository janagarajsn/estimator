package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Model;

import java.util.ArrayList;
import java.util.List;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Customer;

public class GenerateReportPOJO {
	private String report_name;
	private String technology_name;
	private String task_name;
	private String scope_Flag;
	private String effort;
	private String customer_name;
	private int report_id;
	private String scope_name;
	private String activity_type;
	private List<Object> customerList = new ArrayList<Object>();

	public String getReport_name() {
		return report_name;
	}

	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}

	public String getTechnology_name() {
		return technology_name;
	}

	public void setTechnology_name(String technology_name) {
		this.technology_name = technology_name;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public GenerateReportPOJO() {
		// TODO Auto-generated constructor stub
	}

	public String getEffort() {
		return effort;
	}

	public void setEffort(String effort) {
		this.effort = effort;
	}

	public String getScope_Flag() {
		return scope_Flag;
	}

	public void setScope_Flag(String scope_Flag) {
		this.scope_Flag = scope_Flag;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public String getScope_name() {
		return scope_name;
	}

	public void setScope_name(String scope_name) {
		this.scope_name = scope_name;
	}

	public String getActivity_type() {
		return activity_type;
	}

	public void setActivity_type(String activity_type) {
		this.activity_type = activity_type;
	}

	public List<Object> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Object> customerList) {
		this.customerList = customerList;
	}

}
