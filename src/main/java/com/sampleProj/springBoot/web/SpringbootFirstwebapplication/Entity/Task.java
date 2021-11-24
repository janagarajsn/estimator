package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TaskId.class)
public class Task {
	private int task_id;
	@Id
	private String task_name;
	@Id
	private int techid;
	private String task_description;
	private String created_by;
	private Date created_date;

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public Task(int task_id, String task_name, int techid, String task_description, String created_by,
			Date created_date) {
		super();
		this.task_id = task_id;
		this.task_name = task_name;
		this.techid = techid;
		this.task_description = task_description;
		this.created_by = created_by;
		this.created_date = created_date;
	}

	public Task() {
		// TODO Auto-generated constructor stub
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public int getTechid() {
		return techid;
	}

	public void setTechid(int techid) {
		this.techid = techid;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
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

	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", task_name=" + task_name + ", techid=" + techid + ", task_description="
				+ task_description + ", created_by=" + created_by + ", created_date=" + created_date + "]";
	}
}
