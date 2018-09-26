package com.metacube.training.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
public class Employee {

	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", gender=" + gender + ", primaryContactNumber=" + primaryContactNumber + ", secondaryContactNumber="
				+ secondaryContactNumber + ", emailId=" + emailId + ", skypeId=" + skypeId + ", profilePicture="
				+ profilePicture + ", password=" + password + ", isEnabled=" + isEnabled + ", jobs=" + jobs;
	}

	@Id
	@Column(name = "emp_code")
	private String empCode;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "dob")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	Date dob;

	@Column(name = "gender")
	private String gender;

	@Column(name = "primary_contact_number")
	private String primaryContactNumber;

	@Column(name = "secondary_contact_number")
	private String secondaryContactNumber;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "skype_id")
	private String skypeId;

	@Column(name = "profile_picture")
	private String profilePicture;

	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private boolean isEnabled;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "job_details", joinColumns = { @JoinColumn(name = "emp_code") }, inverseJoinColumns = {
			@JoinColumn(name = "job_id") })
	@Where(clause = "job_title = 'Team Leader'")
	private List<JobTitle> jobs;

	@ManyToMany(mappedBy = "teamLeaders")
	private List<JobTitle> jobTitle;

	@ManyToMany(mappedBy = "employeesSkills")
	private List<Skill> skills;

	public List<JobTitle> getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(List<JobTitle> jobTitle) {
		this.jobTitle = jobTitle;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPrimaryContactNumber() {
		return primaryContactNumber;
	}

	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}

	public String getSecondaryContactNumber() {
		return secondaryContactNumber;
	}

	public void setSecondaryContactNumber(String secondaryContactNumber) {
		this.secondaryContactNumber = secondaryContactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/*
	 * public int getId() { return id; } public void setId(int id) { this.id =
	 * id; }
	 */
	public List<JobTitle> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobTitle> jobs) {
		this.jobs = jobs;
	}

}
