package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {
	@Query(value = "SELECT max(report_id) + 1 FROM Report")
	public Integer max();


	@Query(value = "SELECT TECH.technology_name,t.task_name,REP.effort,REP.scope_Flag FROM Report REP, Technology TECH,  Task t "
			+ " WHERE t.task_id = REP.task_id and t.techid = TECH.techid and TECH.techid = REP.techid AND REP.cust_id = :custId and REP.report_name = :reportName")
	public List<Object> findTechDetails(int custId, String reportName);

	@Query(value = "SELECT REP.report_name,TECH.technology_name,t.task_name,REP.scope_Flag,REP.effort FROM Report REP, Technology TECH,  Task t "
			+ " WHERE t.task_id = REP.task_id and t.techid = TECH.techid and TECH.techid = REP.techid AND REP.cust_id = :custId UNION SELECT '' as report_name,'' as technology_name, '' as task_name, 'Total' as scope_Flag, SUM(effort) as effort from "
			+ "Report REP, Technology TECH,  Task t WHERE t.task_id = REP.task_id and t.techid = TECH.techid and TECH.techid = REP.techid AND REP.cust_id = :custId order by 1 desc",nativeQuery=true)
	public List<Object[]> generateReportDetails(int custId);

}
