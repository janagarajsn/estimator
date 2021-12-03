package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Model;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Customer;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Report;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.ReportDetails;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Scope;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.ScopeTechRel;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.CustomerRepository;
import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service.ReportDetailRepository;
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
	@Autowired
	ReportDetailRepository repoDetailRepo;

	Scope scope = new Scope();
	Customer cust = new Customer();
	Report report = new Report();
	ScopeTechRel scopeRel = new ScopeTechRel();
	ReportDetails repoDetail = new ReportDetails();
	GenerateReportPOJO genReport = new GenerateReportPOJO();

	public String addCustomer(Map<String, String> allRequestParams) throws SQLIntegrityConstraintViolationException {
		try {
			if (customerRepository.max() == null) {
				cust.setId(1);
			} else {
				cust.setId(customerRepository.max());
			}

			cust.setCreated_by("Admin");
			cust.setCreated_date(new Date());
			cust.setCloud_Vendor(allRequestParams.get("cloudVendor"));
			cust.setActivity_name(allRequestParams.get("activityName"));
			cust.setAddress(allRequestParams.get("address"));
			cust.setVertical(allRequestParams.get("vertical"));
			cust.setLocation(valueToStringOrEmpty(allRequestParams.get("location1"), 1)
					+ valueToStringOrEmpty(allRequestParams.get("location2"), 2)
					+ valueToStringOrEmpty(allRequestParams.get("location3"), 3)
					+ valueToStringOrEmpty(allRequestParams.get("location4"), 4));
			// System.out.println();
			cust.setCustomer_name(allRequestParams.get("customerName"));
			cust.setNumberOfServer(Integer.parseInt(allRequestParams.get("server")));
			cust.setDuration(Integer.parseInt(allRequestParams.get("duration")));
			customerRepository.save(cust);
			return "Customer Created";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	private String valueToStringOrEmpty(String value, int seq) {
		if (value == null) {
			return "";
		} else {
			if (seq == 1) {
				return value.toString();
			} else {
				return "/" + value.toString();
			}
		}
		// return value == null ? "" : "/" + value.toString();
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

	public List<Object> saveReport(String activityType, int scopeId, int techId, String[] taskId, int custId,
			String[] effort, String reportName) {
		List<Integer> availableTaskIds = taskRepo.findTaskId(techId);
		List<String> selectedTaskIdList = Arrays.asList(taskId);
		List<String> selectedEffortList = Arrays.asList(effort);
		List<Integer> selectedTaskIdNum = selectedTaskIdList.stream().map(Integer::parseInt)
				.collect(Collectors.toList());
		List<Integer> selectedEffortNum = selectedEffortList.stream().map(Integer::parseInt)
				.collect(Collectors.toList());
		int reportId = 0;
		List<Integer> commonArrayValues = new ArrayList<Integer>(availableTaskIds);
		commonArrayValues.retainAll(selectedTaskIdNum);
		if (reportRepo.max() == null) {
			reportId = 1;
			report.setReport_id(reportId);
		} else {
			reportId = reportRepo.findReportId(reportName, activityType);
			if (reportId == 0) {
				reportId = reportRepo.max();
			}
			report.setReport_id(reportId);
		}
		report.setCreated_by("Admin");
		report.setCreated_date(new Date());
		report.setCust_id(custId);
		report.setReport_name(reportName);
		report.setActivity_type(activityType);
		reportRepo.save(report);
		for (int i = 0; i < commonArrayValues.size(); i++) {
			repoDetail.setReport_id(reportId);
			repoDetail.setScope_id(scopeId);
			repoDetail.setTechid(techId);
			repoDetail.setTask_id(commonArrayValues.get(i));
			repoDetail.setEffort(selectedEffortNum.get(i));
			repoDetail.setScope_Flag("In Scope");
			repoDetail.setCreated_by("Admin");
			repoDetail.setCreated_date(new Date());
			repoDetailRepo.save(repoDetail);
		}
		commonArrayValues = new ArrayList<Integer>(availableTaskIds);
		commonArrayValues.removeAll(selectedTaskIdNum);
		for (int i = 0; i < commonArrayValues.size(); i++) {
			repoDetail.setReport_id(reportId);
			repoDetail.setScope_id(scopeId);
			repoDetail.setTechid(techId);
			repoDetail.setTask_id(commonArrayValues.get(i));
			repoDetail.setEffort(0);
			repoDetail.setScope_Flag("Out of Scope");
			repoDetail.setCreated_by("Admin");
			repoDetail.setCreated_date(new Date());
			repoDetailRepo.save(repoDetail);
		}

		List<Object> reportDetails = repoDetailRepo.findTechDetails(custId, reportName, activityType);
		return reportDetails;
	}

	public List<GenerateReportPOJO> retrieveReportData(int custId) {
		List<Object[]> objList = reportRepo.generateReport(custId);
		List<GenerateReportPOJO> latestNewsList = new ArrayList<GenerateReportPOJO>();
		if (objList.size() > 0) {
			latestNewsList = objList.stream().map(objects -> {
				GenerateReportPOJO genReport = new GenerateReportPOJO();
				genReport.setReport_id((int) objects[0]);
				genReport.setReport_name(objects[1].toString());
				genReport.setCustomer_name(objects[2].toString());
				genReport.setActivity_type(objects[3].toString());
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

	public List<Object> loadScopeByActType(String activityType) {
		List<Object> scopeName = scopeRep.findByActivityType(activityType);
		return scopeName;
	}

	public List<GenerateReportPOJO> retrieveAllData(int customerId, int reportId) {
		List<Object[]> objList = repoDetailRepo.generateReportDetails(customerId, reportId);
		List<GenerateReportPOJO> latestNewsList = new ArrayList<GenerateReportPOJO>();
		if (objList.size() > 0) {
			latestNewsList = objList.stream().map(objects -> {
				GenerateReportPOJO genReport = new GenerateReportPOJO();
				genReport.setReport_name(objects[0].toString());
				genReport.setScope_name(objects[1].toString());
				genReport.setTechnology_name(objects[2].toString());
				genReport.setTask_name(objects[3].toString());
				genReport.setScope_Flag(objects[4].toString());
				genReport.setEffort(objects[5].toString());
				return genReport;
			}).collect(Collectors.toList());
		}
		return latestNewsList;
	}

	public Object editReport(int custId, int reportId) {
		List<Object[]> objList = repoDetailRepo.generateReportDetails(custId, reportId);
		List<GenerateReportPOJO> latestNewsList = new ArrayList<GenerateReportPOJO>();
		if (objList.size() > 0) {
			latestNewsList = objList.stream().map(objects -> {
				GenerateReportPOJO genReport = new GenerateReportPOJO();
				genReport.setReport_name(objects[0].toString());
				genReport.setScope_name(objects[1].toString());
				genReport.setTechnology_name(objects[2].toString());
				genReport.setTask_name(objects[3].toString());
				genReport.setScope_Flag(objects[4].toString());
				genReport.setEffort(objects[5].toString());
				return genReport;
			}).collect(Collectors.toList());
		}
		return latestNewsList;
	}

	public List<GenerateReportPOJO> findReportName(int reportId) {
		List<Object[]> objList = reportRepo.findReportName(reportId);
		List<GenerateReportPOJO> latestNewsList = new ArrayList<GenerateReportPOJO>();
		if (objList.size() > 0) {
			latestNewsList = objList.stream().map(objects -> {
				GenerateReportPOJO genReport = new GenerateReportPOJO();
				genReport.setReport_name(objects[0].toString());
				genReport.setActivity_type(objects[1].toString());
				return genReport;
			}).collect(Collectors.toList());

		}
		return latestNewsList;
	}
	public List<GenerateReportPOJO> exportAllData(int customerId, int reportId) {
		List<Object[]> objList = repoDetailRepo.generateReportDetails(customerId, reportId);
		List<GenerateReportPOJO> latestNewsList = new ArrayList<GenerateReportPOJO>();
		if (objList.size() > 0) {
			latestNewsList = objList.stream().map(objects -> {
				GenerateReportPOJO genReport = new GenerateReportPOJO();
				genReport.setReport_name(objects[0].toString());
				genReport.setScope_name(objects[1].toString());
				genReport.setTechnology_name(objects[2].toString());
				genReport.setTask_name(objects[3].toString());
				genReport.setScope_Flag(objects[4].toString());
				genReport.setEffort(objects[5].toString());
				return genReport;
			}).collect(Collectors.toList());
		}
		return latestNewsList;
	}

}
