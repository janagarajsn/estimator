package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Customer;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Report;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Scope;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.ScopeTechRel;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.CustomerRepository;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.ReportRepository;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.ScopeRepository;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.ScopeTechRepository;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.TaskRepository;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.TechnologyRepository;

@Service
public class userInputsService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	TechnologyRepository techRepository;
	@Autowired
	TaskRepository taskRepo;
	@Autowired
	ReportRepository reportRepo;
	@Autowired
	ScopeRepository scopeRep;
	@Autowired
	ScopeTechRepository scopetechRepo;

	
	Scope scope = new Scope();
	Customer cust = new Customer();
	Report report = new Report();
	ScopeTechRel scopeRel = new ScopeTechRel();
	GenerateReportPOJO genReport = new GenerateReportPOJO();

	public void addCustomer(Map<String, String> allRequestParams) {
		if (customerRepository.max() == null) {
			cust.setId(1);
		} else {
			cust.setId(customerRepository.max());
		}

		cust.setCreated_by("Admin");
		cust.setCreated_date(new Date());
		cust.setCloud_Vendor(allRequestParams.get("cloudVendor"));
		cust.setActivity_name(allRequestParams.get("activityName"));
		cust.setActivity_type(allRequestParams.get("activityType"));
		cust.setCustomer_name(allRequestParams.get("customerName"));
		cust.setNumberOfServer(Integer.parseInt(allRequestParams.get("server")));
		cust.setDuration(Integer.parseInt(allRequestParams.get("duration")));
		customerRepository.save(cust);
	}

	public List<Object> loadCustomer(String activity_name) {
		List<Object> customerName = customerRepository.findByActivityName(activity_name);
		return customerName;
	}

	public String findCustomerName(int customerId) {
		String customerName = customerRepository.findCustomerName(customerId);
		return customerName;
	}

	public List<Object> loadTechnology() {
		List<Object> techName = techRepository.findByActivityName();
		return techName;
	}

	public List<Object> loadTask(int techId) {
		List<Object> taskName = taskRepo.findTaskName(techId);
		return taskName;
	}

	public List<Object> saveReport(int scopeId, int techId, String[] taskId, int custId, String[] effort,
			String reportName) {
		List<Integer> availableTaskIds = taskRepo.findTaskId(techId);
		List<String> selectedTaskIdList = Arrays.asList(taskId);
		List<String> selectedEffortList = Arrays.asList(effort);
		List<Integer> selectedTaskIdNum = selectedTaskIdList.stream().map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> selectedEffortNum = selectedEffortList.stream().map(Integer::parseInt).collect(Collectors.toList());

		List<Integer> commonArrayValues = new ArrayList<Integer>(availableTaskIds);
		commonArrayValues.retainAll(selectedTaskIdNum);
		System.out.println("INSCOPE ::::::::::: " +commonArrayValues);
		for(int i = 0 ; i < commonArrayValues.size(); i ++) {
		if (reportRepo.max() == null) {
			report.setReport_id(1);
		} else {
			report.setReport_id(reportRepo.max());
		}
		report.setCreated_by("Admin");
		report.setCreated_date(new Date());
		report.setScope_id(scopeId);
		report.setCust_id(custId); 
		report.setTask_id(commonArrayValues.get(i));
		report.setTechid(techId);
		report.setEffort(selectedEffortNum.get(i));
		report.setScope_Flag("InScope");
		report.setReport_name(reportName);
		reportRepo.save(report);
		}
		 commonArrayValues = new ArrayList<Integer>(availableTaskIds);
			commonArrayValues.removeAll(selectedTaskIdNum);
		System.out.println("OUTSCOPE ::::::::::: " +commonArrayValues);
		for(int i = 0 ; i < commonArrayValues.size(); i ++) {
			if (reportRepo.max() == null) {
				report.setReport_id(1);
			} else {
				report.setReport_id(reportRepo.max());
			}
			report.setCreated_by("Admin");
			report.setCreated_date(new Date());
			report.setScope_id(scopeId);
			report.setCust_id(custId); 
			report.setTask_id(commonArrayValues.get(i));
			report.setTechid(techId);
			report.setEffort(0);
			report.setScope_Flag("OutofScope");
			report.setReport_name(reportName);
			reportRepo.save(report);
			}
		
		List<Object> reportDetails = reportRepo.findTechDetails(custId, reportName);
		return reportDetails;
	}

	public List<GenerateReportPOJO> retrieveAllData(int custId) {
		List<Object[]> objList = reportRepo.generateReportDetails(custId);
		List<GenerateReportPOJO> latestNewsList = new ArrayList<GenerateReportPOJO>();
		if (objList.size() > 1) {
			latestNewsList = objList.stream().map(objects -> {
				GenerateReportPOJO genReport = new GenerateReportPOJO();
				genReport.setReport_name(objects[0].toString());
				genReport.setTechnology_name(objects[1].toString());
				genReport.setTask_name(objects[2].toString());
				genReport.setScope_Flag(objects[3].toString());
				genReport.setEffort(objects[4].toString());
				return genReport;
			}).collect(Collectors.toList());
		}
		return latestNewsList;
	}

	public List<Object> loadScope() {
		List<Object> scopeName = scopeRep.findByActivityName();
		return scopeName;
	}

	public List<Object> loadScopeTechnology(int scopeId) {
		List<Object> techDetails = scopetechRepo.findByScopeId(scopeId);
		return techDetails;
	}

	public List<Object> loadScopeByCustId(int custId) {
		List<Object> scopeName = scopeRep.findBycustId(custId);
		return scopeName;
	}

}
