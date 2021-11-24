package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Customer;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Model.userInputsService;

@Controller
public class DataCenterController {
	@Autowired
	userInputsService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showFirstPage() {
		return "DC";
	}

	@RequestMapping(value = "/addReport", method = RequestMethod.POST)
	public String showReportPage(@RequestParam String activityName, @RequestParam int customerId, ModelMap model) {
		String customerName = userService.findCustomerName(customerId);
		model.addAttribute("activityName", activityName);
		model.addAttribute("customerName", customerName);
		model.addAttribute("customerId", customerId);
		return "AddReport";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("AddCustomer", "customer", new Customer());
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@RequestParam String customer_name, @RequestParam String activity_name) {
		userService.addCustomer(customer_name, activity_name);
		return "DC";
	}

	@RequestMapping(value = "/loadCustomer", method = RequestMethod.POST)
	public @ResponseBody List<Object> loadCustomer(@RequestParam String activity_name) {
		List<Object> customerName = userService.loadCustomer(activity_name);
		return customerName;
	}

	@RequestMapping(value = "/loadTechnology", method = RequestMethod.POST)
	public @ResponseBody List<Object> loadTechnology(@RequestParam String activity_name) {
		List<Object> techName = userService.loadTechnology(activity_name);
		return techName;
	}

	@RequestMapping(value = "/loadTask", method = RequestMethod.POST)
	public @ResponseBody List<Object> loadTask(@RequestParam int techId) {
		List<Object> taskName = userService.loadTask(techId);
		return taskName;
	}

	@RequestMapping(value = "/saveReport", method = RequestMethod.POST)
	public @ResponseBody List<Object> saveReport(@RequestParam int techId, @RequestParam int taskId, @RequestParam int custId,
			@RequestParam int effort, @RequestParam String reportName) {
		List<Object> reportDetails = userService.saveReport(techId, taskId, custId, effort, reportName);
		return reportDetails;
	}
	
	@RequestMapping(value = "/generateReport", method = RequestMethod.POST)
	public String retrieveAllData(@RequestParam int customerId,ModelMap model) {
		model.put("results", userService.retrieveAllData(customerId));
		model.put("custId", customerId);
		return "ShowReport";
	}
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void exportData(HttpServletResponse response,@RequestParam int custId) throws IOException {
		response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Report_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        ExportData excelExporter = new ExportData(userService.retrieveAllData(custId));
        excelExporter.export(response);
	}

}
