package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Task;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Technology;
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

	public  void addTechnology(String technology_name, String activity_name) {
		if (techRepository.max() == null) {
			tech.setTechid(1);
		} else {
			tech.setTechid(techRepository.max());
		}
		tech.setCreated_by("Admin");
		tech.setCreated_date(new Date());
		tech.setActivity_name(activity_name);
		tech.setTechnology_name(technology_name);
		techRepository.save(tech);

	}

	public void addTask(String technology_name, int techId, String activity_name, String task_name, String task_desc) {
		
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

}
