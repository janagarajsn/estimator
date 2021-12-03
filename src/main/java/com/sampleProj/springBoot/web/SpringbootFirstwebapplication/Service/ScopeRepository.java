package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Scope;

public interface ScopeRepository extends JpaRepository<Scope, Integer> {
	@Query(value = "SELECT max(scope_id) + 1 FROM Scope")
	public Integer max();

	@Query(value = "SELECT scope_id,scope_name FROM Scope")
	public List<Object> findByActivityName();

	@Query(value = "SELECT scope_name FROM Scope where scope_name = :scopeName and activity_type=:activityType")
	public String findByScopeName(String scopeName, String activityType);
	
	@Query(value = "SELECT scope_id,scope_name FROM Scope where activity_type in (:activityType,'Both')")
	public List<Object> findByActivityType(String activityType);

}
