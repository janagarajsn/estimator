package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.io.Serializable;
import java.util.Objects;

public class TaskId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int techid;
	private String task_name;

	public TaskId() {
	}


	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TaskId taskId = (TaskId) o;
		return task_name.equals(taskId.task_name) && techid == taskId.techid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(task_name, techid);
	}


	public int getTechid() {
		return techid;
	}


	public void setTechid(int techid) {
		this.techid = techid;
	}


	public String getTask_name() {
		return task_name;
	}


	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}



}
