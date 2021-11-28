package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Scope {
	@Id
	private int scope_id;
	private String scope_name;
	private String activity_type;
	private String created_by;
	private Date created_date;


	public Scope(int scope_id, String scope_name, String activity_type, String created_by, Date created_date) {
		super();
		this.scope_id = scope_id;
		this.scope_name = scope_name;
		this.activity_type = activity_type;
		this.created_by = created_by;
		this.created_date = created_date;
	}


	public Scope() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Scope [scope_id=" + scope_id + ", scope_name=" + scope_name + ", activity_type=" + activity_type
				+ ", created_by=" + created_by + ", created_date=" + created_date + "]";
	}


	public String getActivity_type() {
		return activity_type;
	}


	public void setActivity_type(String activity_type) {
		this.activity_type = activity_type;
	}


	public int getScope_id() {
		return scope_id;
	}

	public void setScope_id(int scope_id) {
		this.scope_id = scope_id;
	}

	public String getScope_name() {
		return scope_name;
	}

	public void setScope_name(String scope_name) {
		this.scope_name = scope_name;
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

}
