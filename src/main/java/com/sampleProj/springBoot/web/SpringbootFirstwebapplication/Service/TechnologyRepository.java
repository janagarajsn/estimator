package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
	@Query(value = "SELECT max(techid) + 1 FROM Technology")
	public Integer max();

	@Query(value = "SELECT techid,technology_name FROM Technology where activity_name = :activityName")
	public List<Object> findByActivityName(String activityName);

}
