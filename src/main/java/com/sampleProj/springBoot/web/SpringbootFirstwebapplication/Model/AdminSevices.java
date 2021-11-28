package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Scope;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.ScopeTechRel;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Task;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Technology;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.ScopeRepository;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.ScopeTechRepository;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.TaskRepository;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.TechnologyRepository;

@Service
public class AdminSevices {
	@Autowired
	TechnologyRepository techRepository;
	Technology tech = new Technology();

	@Autowired
	TaskRepository taskRepository;
	Task task = new Task();

	@Autowired
	ScopeRepository scopeRepository;
	Scope scope = new Scope();

	@Autowired
	ScopeTechRepository scopetechRepo;
	ScopeTechRel scopeRel = new ScopeTechRel();

	public void addTechnology(String technology_name) {
		if (techRepository.max() == null) {
			tech.setTechid(1);
		} else {
			tech.setTechid(techRepository.max());
		}
		tech.setCreated_by("Admin");
		tech.setCreated_date(new Date());
		tech.setTechnology_name(technology_name);
		techRepository.save(tech);

	}

	public void addTask(String technology_name, int techId, String task_name, String task_desc) {

		if (taskRepository.max() == null) {
			task.setTask_id(1);
		} else {
			task.setTask_id(taskRepository.max());
		}
		task.setCreated_by("Admin");
		task.setCreated_date(new Date());
		task.setTechid(techId);
		task.setTask_name(task_name);
		task.setTask_description(task_desc);
		taskRepository.save(task);
	}

	public void addScope(String activityType, String scopeName) {
		if (scopeRepository.max() == null) {
			scope.setScope_id(1);
		} else {
			scope.setScope_id(scopeRepository.max());
		}
		scope.setCreated_by("Admin");
		scope.setCreated_date(new Date());
		scope.setScope_name(scopeName);
		scope.setActivity_type(activityType);
		scopeRepository.save(scope);
	}

	public void addScopeTech(int scope_id, int technology_id) {
		scopeRel.setScopeId(scope_id);
		scopeRel.setTechid(technology_id);
		scopetechRepo.save(scopeRel);

	}

}
