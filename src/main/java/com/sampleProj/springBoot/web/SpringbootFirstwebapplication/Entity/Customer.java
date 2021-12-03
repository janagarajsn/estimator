package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CustomerId.class)
public class Customer {
	
	@Id
	private String activity_name;
	@Id
	private String customer_name;
	private int id;
	private String address;
	private String vertical;
	private String location;
	private int duration;
	private int numberOfServer;
	private String cloud_Vendor;
	private String created_by;
	private Date created_date;

	public String getCloud_Vendor() {
		return cloud_Vendor;
	}

	public void setCloud_Vendor(String cloud_Vendor) {
		this.cloud_Vendor = cloud_Vendor;
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


	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getNumberOfServer() {
		return numberOfServer;
	}

	public void setNumberOfServer(int numberOfServer) {
		this.numberOfServer = numberOfServer;
	}


	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the vertical
	 */
	public String getVertical() {
		return vertical;
	}

	/**
	 * @param vertical the vertical to set
	 */
	public void setVertical(String vertical) {
		this.vertical = vertical;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

}
