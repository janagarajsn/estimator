package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Task;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Technology;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Model.AdminSevices;

@Controller
public class AdminController {
	@Autowired
	AdminSevices adminService;
	
	@RequestMapping(value = "/technology", method = RequestMethod.GET)
	public ModelAndView showTechnologyForm() {
		return new ModelAndView("AddTechnology", "technology", new Technology());
	}

	@RequestMapping(value = "/addTechnology", method = RequestMethod.POST)
	public String addTechnology(@RequestParam String technology_name, @RequestParam String activity_name) {
		adminService.addTechnology(technology_name, activity_name);
		return "DC";
	}
	
	@RequestMapping(value = "/task", method = RequestMethod.GET)
	public ModelAndView showTaskForm() {
		return new ModelAndView("AddTask", "technology", new Task());
	}
	
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public String addTechnology(@RequestParam String tech_name,@RequestParam int techId, @RequestParam String activity_name,@RequestParam String task_name, @RequestParam String task_desc) {
		adminService.addTask(tech_name,techId, activity_name,task_name,task_desc);
		return "DC";
	}
}
