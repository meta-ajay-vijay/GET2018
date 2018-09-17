package com.metacube.training.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

import org.springframework.format.annotation.DateTimeFormat;

import com.metacube.training.transferObjects.EmployeeTransferObjectWithJobDetails;

@Entity
@Table(name = "employees")
public class Employee {
	
	public Employee(){}
	
	@Id
	@Column(name = "emp_code")
	private String empCode;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "dob")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "doj")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	
	@Column(name = "primary_contact_number")
	private String contactNumber;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@ManyToMany(cascade =  CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(
        name = "employee_skills", 
        joinColumns = { @JoinColumn(name = "emp_code") },
        inverseJoinColumns = { @JoinColumn(name = "skill_code") }
    )
    Set<Skill> skills = new HashSet<>();
	
	 public Employee(EmployeeTransferObjectWithJobDetails employeeTransferObject) {
		 this.setEmpCode(employeeTransferObject.getEmpCode());
			this.setFirstName(employeeTransferObject.getFirstName());
			this.setLastName(employeeTransferObject.getLastName());
			this.setContactNumber(employeeTransferObject.getContactNumber());
			this.setDob(employeeTransferObject.getDob());
			this.setDateOfJoining(employeeTransferObject.getDateOfJoining());
			this.setEmailId(employeeTransferObject.getEmailId());
			this.setGender(employeeTransferObject.getGender());
			this.setPassword(employeeTransferObject.getPassword());
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> set) {
		this.skills = set;
	}

	
}
