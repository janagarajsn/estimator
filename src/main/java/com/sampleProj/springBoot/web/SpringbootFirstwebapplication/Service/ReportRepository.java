package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {
	@Query(value = "SELECT max(report_id) + 1 FROM Report")
	public Integer max();

	@Query(value = "SELECT REP.report_id,REP.report_name,CUST.customer_name from Report REP,Customer CUST where REP.cust_id = CUST.id and REP.cust_id = :custId")
	public List<Object[]> generateReport(int custId);
	
	@Query(value = "select max(x.rep_id) from (SELECT ifnull(report_id,0) as rep_id FROM Report where report_name = :reportName union select 0 as rep_id from Report) x ",nativeQuery=true)
	public int findReportId(String reportName);
}
