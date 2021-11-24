package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TechnologyId.class)
public class Technology {
	private int techid;
	@Id
	private String technology_name;
	@Id
	private String activity_name;
	private String created_by;
	private Date created_date;


	public Technology() {
		// TODO Auto-generated constructor stub
	}

	public int getTechid() {
		return techid;
	}

	public Technology(int techid, String technology_name, String activity_name, String created_by, Date created_date) {
		super();
		this.techid = techid;
		this.technology_name = technology_name;
		this.activity_name = activity_name;
		this.created_by = created_by;
		this.created_date = created_date;
	}

	public void setTechid(int techid) {
		this.techid = techid;
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

	public String getTechnology_name() {
		return technology_name;
	}

	public void setTechnology_name(String technology_name) {
		this.technology_name = technology_name;
	}

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	@Override
	public String toString() {
		return "Technology [techid=" + techid + ", technology_name=" + technology_name + ", activity_name="
				+ activity_name + ", created_by=" + created_by + ", created_date=" + created_date + "]";
	}

	

}
