package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CustomerId.class)
public class Customer {
	private int id;
	@Id
	private String activity_name;
	@Id
	private String customer_name;
	private String created_by;
	private Date created_date;

	public Customer(int id, String activity_name, String customer_name, String created_by, Date created_date) {
		super();
		this.id = id;
		this.activity_name = activity_name;
		this.customer_name = customer_name;
		this.created_by = created_by;
		this.created_date = created_date;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", activity_name=" + activity_name + ", customer_name=" + customer_name
				+ ", created_by=" + created_by + ", created_date=" + created_date + "]";
	}

}
