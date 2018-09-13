package com.metacube.training.response;

public class EmployeeForgotPassword {
		
	private String empCode;
	private String email;
	private String token;
	
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCOde) {
		this.empCode = empCOde;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
