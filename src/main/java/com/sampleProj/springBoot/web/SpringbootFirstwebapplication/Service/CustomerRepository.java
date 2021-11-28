package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query(value = "SELECT max(id) + 1 FROM Customer")
	public Integer max();

	@Query(value = "SELECT id,customer_name FROM Customer where activity_name = :activityName ")
	public List<Object> findByActivityName(String activityName);

	@Query(value = "SELECT customer_name FROM Customer where id = :customerId ")
	public String findCustomerName(int customerId);
	
}
