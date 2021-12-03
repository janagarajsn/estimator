package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
	@Query(value = "SELECT max(techid) + 1 FROM Technology")
	public Integer max();

	@Query(value = "SELECT techid,technology_name FROM Technology")
	public List<Object> findByActivityName();
	
	@Query(value = "SELECT technology_name FROM Technology")
	public String findByTechName(String technology_name);

}
