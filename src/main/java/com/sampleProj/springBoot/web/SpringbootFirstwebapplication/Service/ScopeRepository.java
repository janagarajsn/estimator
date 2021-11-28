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

	@Query(value = "select s.scope_id, s.scope_name from Scope s,Customer c where  c.id = :custId and (s.activity_type = c.activity_type or s.activity_type='both')")
	public List<Object> findBycustId(int custId);

}
