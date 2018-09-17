package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.metacube.training.transferObjects.EmployeeTransferObjectWithJobDetails;

@Entity
@Table(name = "job_details")
public class JobDetails {
	
	public JobDetails(){}
	
	@Id
	@Column(name = "job_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="emp_code")
	private String empCode;
	
	@Column(name="job_code")
	private int jobCode;
	
	@Column(name="reporting_mgr")
	private String reportingManager;
	
	@Column(name = "team_lead")
	private String teamLead;
	
	@Column(name = "curr_proj_id")
	private Long projectId;
	
	public JobDetails(EmployeeTransferObjectWithJobDetails employee) {
		this.setEmpCode(employee.getEmpCode());
		this.setJobCode(employee.getJobCode());
		this.setProjectId(employee.getProjectId());
		this.setReportingManager(employee.getReportingManager());
		this.setTeamLead(employee.getTeamLead());
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public int getJobCode() {
		return jobCode;
	}
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}
	public String getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}
	public String getTeamLead() {
		return teamLead;
	}
	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
}
