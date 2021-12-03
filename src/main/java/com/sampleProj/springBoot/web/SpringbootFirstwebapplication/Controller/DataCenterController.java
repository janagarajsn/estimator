package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Model.GenerateReportPOJO;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Model.userInputsService;

@Controller
@SessionAttributes({ "activityName", "customerId", "customerName" })
public class DataCenterController {
	@Autowired
	userInputsService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showFirstPage() {
		return "Welcome";
	}

	@RequestMapping(value = "/ShowCustomer", method = RequestMethod.GET)
	public String showDCPage(ModelMap model) {
		String activityName = (String) model.get("activityName");
		model.put("activityName", activityName);
		return "DC";
	}

	@RequestMapping(value = "/ShowCustomer", method = RequestMethod.POST)
	public String showDCPage(@RequestParam String activityName, ModelMap model) {
		model.addAttribute("activityName", activityName);
		return "DC";
	}

	@RequestMapping(value = "/addReport", method = RequestMethod.GET)
	public String showReportPage() {
		return "AddReport";
	}

	@RequestMapping(value = "/addReport", method = RequestMethod.POST)
	public String showReportPage(@RequestParam String activityName, @RequestParam int customerId, ModelMap model) {
		String customerName = userService.findCustomerName(customerId);
		model.addAttribute("activityName", activityName);
		model.addAttribute("customerName", customerName);
		model.put("customerName", customerName);
		model.addAttribute("customerId", customerId);
		return "AddReport";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String showForm(@RequestParam String activityName, ModelMap model) {
		model.addAttribute("activityName", activityName);
		return "AddCustomer";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ModelAndView addCustomer(@RequestParam Map<String, String> allRequestParams, ModelMap model)
			throws SQLIntegrityConstraintViolationException {
		allRequestParams.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
		model.addAttribute("activityName", allRequestParams.get("activityName"));
		String message = userService.addCustomer(allRequestParams);
		ModelAndView modelAndView = new ModelAndView("DC");
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/loadCustomer", method = RequestMethod.POST)
	public @ResponseBody List<Object> loadCustomer(@RequestParam String activity_name) {
		List<Object> customerName = userService.loadCustomer(activity_name);
		return customerName;
	}

	@RequestMapping(value = "/loadTechnology", method = RequestMethod.POST)
	public @ResponseBody List<Object> loadTechnology() {
		List<Object> techName = userService.loadTechnology();
		return techName;
	}

	@RequestMapping(value = "/loadTask", method = RequestMethod.POST)
	public @ResponseBody List<Object> loadTask(@RequestParam int techId) {
		List<Object> taskName = userService.loadTask(techId);
		return taskName;
	}

	@RequestMapping(value = "/saveReport", method = RequestMethod.POST)
	public @ResponseBody List<Object> saveReport(@RequestParam String activityType, @RequestParam int scopeId,
			@RequestParam int techId, @RequestParam String[] taskId, @RequestParam int custId,
			@RequestParam String[] effort, @RequestParam String reportName) {
		List<Object> reportDetails = userService.saveReport(activityType, scopeId, techId, taskId, custId, effort,
				reportName);
		return reportDetails;
	}

	@RequestMapping(value = "/editReport", method = RequestMethod.GET)
	public ModelAndView editReport(@RequestParam int custId, @RequestParam int reportId, ModelAndView mod) {
		mod.addObject("customerName", userService.findCustomerName(custId));
		List<GenerateReportPOJO> reportActName = userService.findReportName(reportId);
		mod.addObject("reportName", reportActName.get(0).getReport_name());
		mod.addObject("activityType", reportActName.get(0).getActivity_type());
		mod.setViewName("EditReport");
		mod.addObject("custId", custId);
		mod.addObject("results", userService.editReport(custId, reportId));
		return mod;
	}

	@RequestMapping(value = "/generateReport", method = RequestMethod.GET)
	public String retrieveReportData() {
		return "DC";
	}

	@RequestMapping(value = "/generateReport", method = RequestMethod.POST)
	public ModelAndView retrieveReportData(@RequestParam int customerId, ModelAndView model) {
		List<GenerateReportPOJO> showReportList = userService.retrieveReportData(customerId);
		model.addObject("results", showReportList);
		model.addObject("custId", customerId);
		model.addObject("customerName",showReportList.get(0).getCustomer_name());
		model.setViewName("ShowReport");
		return model;
	}

	@RequestMapping(value = "/showReport", method = RequestMethod.GET)
	public String showReport() {
		return "ShowReport";
	}

	@RequestMapping(value = "/showDetailedReport", method = RequestMethod.GET)
	public String retrieveAllData(@RequestParam int custId, @RequestParam int reportId, ModelMap model) {
		model.put("results", userService.retrieveAllData(custId, reportId));
		model.put("custId", custId);
		model.put("reportId", reportId);
		return "ShowDetailedReport";
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void exportData(HttpServletResponse response, @RequestParam int custId, @RequestParam int reportId)
			throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Report_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		ExportData excelExporter = new ExportData(userService.exportAllData(custId, reportId));
		excelExporter.export(response);
	}

	@RequestMapping(value = "/loadScope", method = RequestMethod.POST)
	public @ResponseBody List<Object> loadScope() {
		List<Object> scopeName = userService.loadScope();
		return scopeName;
	}

	@RequestMapping(value = "/loadScopeTechnology", method = RequestMethod.POST)
	public @ResponseBody List<Object> loadScopeTechnology(@RequestParam int scopeId) {
		List<Object> techName = userService.loadScopeTechnology(scopeId);
		return techName;
	}

	@RequestMapping(value = "/loadScopeByActType", method = RequestMethod.POST)
	public @ResponseBody List<Object> loadScopeByActType(@RequestParam String activityType) {
		List<Object> scopeName = userService.loadScopeByActType(activityType);
		return scopeName;
	}

}
