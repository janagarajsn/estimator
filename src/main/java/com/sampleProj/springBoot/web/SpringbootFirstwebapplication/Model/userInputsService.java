package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Customer;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Report;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.CustomerRepository;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.ReportRepository;
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

	Customer cust = new Customer();
	Report report = new Report();
	GenerateReportPOJO genReport = new GenerateReportPOJO();


	public void addCustomer(String customer_name, String activity_name) {
		if (customerRepository.max() == null) {
			cust.setId(1);
		} else {
			cust.setId(customerRepository.max());
		}
		cust.setCreated_by("Admin");
		cust.setCreated_date(new Date());
		cust.setActivity_name(activity_name);
		cust.setCustomer_name(customer_name);
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

	public List<Object> loadTechnology(String activity_name) {
		List<Object> techName = techRepository.findByActivityName(activity_name);
		return techName;
	}

	public List<Object> loadTask(int techId) {
		List<Object> taskName = taskRepo.findTaskName(techId);
		return taskName;
	}

	public List<Object> saveReport(int techId, int taskId, int custId, int effort, String reportName) {

		if (reportRepo.max() == null) {
			report.setReport_id(1);
		} else {
			report.setReport_id(reportRepo.max());
		}
		report.setCreated_by("Admin");
		report.setCreated_date(new Date());
		report.setCust_id(custId);
		report.setEffort(effort);
		report.setTask_id(taskId);
		report.setTechid(techId);
		report.setReport_name(reportName);
		reportRepo.save(report);

		List<Object> reportDetails = reportRepo.findTechDetails(custId,reportName);
		return reportDetails;
	}


	public List<GenerateReportPOJO> retrieveAllData(int custId) {
		List<Object[]> objList = reportRepo.generateReportDetails(custId);
		List<GenerateReportPOJO> latestNewsList = new ArrayList<GenerateReportPOJO>();
		if(objList.size()>1) {
		 latestNewsList =
				objList.stream()
			                .map(objects -> {
			                    GenerateReportPOJO genReport = new GenerateReportPOJO();
			                    genReport.setReport_name(objects[0].toString());
			                    genReport.setTechnology_name(objects[1].toString());
			                    genReport.setTask_name(objects[2].toString());
			                    genReport.setEffort(objects[3].toString());
			                    return genReport;
			                })
			                .collect(Collectors.toList());
		}		
		return latestNewsList;
	}

}
