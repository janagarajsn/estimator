package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity.ReportDetails;

public interface ReportDetailRepository extends JpaRepository<ReportDetails, Integer> {
	@Query(value = "SELECT max(report_id) + 1 FROM Report")
	public Integer max();


	@Query(value = "SELECT s.scope_name,TECH.technology_name,t.task_name,RD.effort,RD.scope_Flag FROM Report REP,ReportDetails RD, Technology TECH,  Task t,Scope s "
			+ " WHERE REP.report_id = RD.report_id and t.task_id = RD.task_id and t.techid = TECH.techid and TECH.techid = RD.techid AND s.scope_id = RD.scope_id and REP.cust_id = :custId and REP.report_name = :reportName and REP.activity_type = :activityType")
	public List<Object> findTechDetails(int custId, String reportName,String activityType);

	@Query(value = "SELECT REP.report_name,s.scope_name,TECH.technology_name,t.task_name,RD.scope_Flag,RD.effort FROM Report REP, Report_Details RD,Technology TECH,  Task t,Scope s "
			+ " WHERE s.scope_id = RD.scope_id and REP.report_id = RD.report_id and t.task_id = RD.task_id and t.techid = TECH.techid and TECH.techid = RD.techid AND REP.cust_id = :custId  AND REP.report_id = :reportId UNION SELECT '' as report_name,'' as scope_name,'' as technology_name, '' as task_name, 'Total' as scope_Flag, SUM(effort) as effort from "
			+ "Report REP, Report_Details RD,Technology TECH,  Task t,Scope s WHERE s.scope_id = RD.scope_id and REP.report_id = RD.report_id and t.task_id = RD.task_id and t.techid = TECH.techid and TECH.techid = RD.techid AND REP.cust_id = :custId  AND REP.report_id = :reportId order by 1 desc",nativeQuery=true)
	public List<Object[]> generateReportDetails(int custId, int reportId);


}
