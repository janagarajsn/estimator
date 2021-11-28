package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.ScopeTechRel;

public interface ScopeTechRepository extends JpaRepository<ScopeTechRel, Integer> {
	@Query(value = "SELECT REL.techid,TECH.technology_name FROM ScopeTechRel REL,Technology TECH where REL.techid = TECH.techid and REL.scopeId = :scopeId")
	List<Object> findByScopeId(int scopeId);

}
