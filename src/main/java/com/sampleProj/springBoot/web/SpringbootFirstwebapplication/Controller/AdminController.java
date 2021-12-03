package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Scope;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.ScopeTechRel;
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
	public ModelAndView addTechnology(@RequestParam String technology_name) {
		String message = adminService.addTechnology(technology_name);
		 ModelAndView modelAndView = new ModelAndView("AddTechnology");
		    modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/task", method = RequestMethod.GET)
	public ModelAndView showTaskForm() {
		return new ModelAndView("AddTask", "technology", new Task());
	}

	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public ModelAndView addTask(@RequestParam String tech_name, @RequestParam int techId, 
			@RequestParam String task_name, @RequestParam String task_desc) {
		String message = adminService.addTask(tech_name, techId,  task_name, task_desc);
		 ModelAndView modelAndView = new ModelAndView("AddTask");
		    modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/scope", method = RequestMethod.GET)
	public ModelAndView showScopeForm() {
		return new ModelAndView("Scope", "scope", new Scope());
	}

	@RequestMapping(value = "/addScope", method = RequestMethod.POST)
	public ModelAndView addScope(@RequestParam String activityType, @RequestParam String scopeName) {
		String message = adminService.addScope(activityType, scopeName);
		 ModelAndView modelAndView = new ModelAndView("Scope");
		    modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/scopeTech", method = RequestMethod.GET)
	public ModelAndView showScopeTechForm() {
		return new ModelAndView("ScopeTechMap", "scopeTech", new ScopeTechRel());
	}

	@RequestMapping(value = "/addScopeTech", method = RequestMethod.POST)
	public ModelAndView addScopeTech(@RequestParam int scope_id , @RequestParam int techid) {
		adminService.addScopeTech(scope_id, techid);
		 ModelAndView modelAndView = new ModelAndView("ScopeTechMap");
		    modelAndView.addObject("message", "Scope Technology Added");
		return modelAndView;
	}
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage() {
		return "Admin";
	}
	
}
