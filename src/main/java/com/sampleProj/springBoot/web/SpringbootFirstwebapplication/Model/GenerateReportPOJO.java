package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Model;

public class GenerateReportPOJO {
	private String report_name;
	private String technology_name;
	private String task_name;
	private String effort;

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

	public GenerateReportPOJO(String report_name, String technology_name, String task_name, String effort) {
		super();
		this.report_name = report_name;
		this.technology_name = technology_name;
		this.task_name = task_name;
		this.effort = effort;
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

}
