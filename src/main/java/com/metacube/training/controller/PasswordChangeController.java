package com.metacube.training.controller;

import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.mail.SimpleMailMessage;

import com.metacube.training.model.Employee;
import com.metacube.training.response.EmployeeForgotPassword;
import com.metacube.training.response.PasswordAndToken;
import com.metacube.training.service.EmailService;
import com.metacube.training.service.interfaces.EmployeeService;

@Controller
@RequestMapping("/forgotPassword")
public class PasswordChangeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/passwordReset", method = RequestMethod.GET)
	public String login(Model model) {
		return "employee/passwordReset";
	}
	
	 @RequestMapping(value = "/passwordReset", method = RequestMethod.POST)
	 public @ResponseBody ModelAndView processForgotPasswordForm(ModelAndView modelAndView, @RequestParam("email") String employeeEmail, HttpServletRequest request) {

	    // Lookup user in database by e-mail
	    Employee employee = employeeService.findUserByEmail(employeeEmail);

	    if (employee==null) {
	      modelAndView.addObject("errorMessage", "We didn't find an account for that e-mail address.");
	    } else {	
	    	System.out.println("Employee null nhi aya");
	    	EmployeeForgotPassword employeeForgotPassword = new EmployeeForgotPassword();
	    	employeeForgotPassword.setEmail(employee.getEmailId());
	    	employeeForgotPassword.setEmpCode(employee.getEmpCode());
	    	employeeForgotPassword.setToken(UUID.randomUUID().toString());
	      
	       //Save token to database
	    	try{
	    		
	    		if(!employeeService.saveForgotEmployee(employeeForgotPassword))
	    		{
					throw  new SQLException();
	    		}
	    		String appUrl = "http://" + request.getServerName() +":8080/employeePortal/";
	    		System.out.println("Employee null nhi aya" + appUrl);	
	    		// Email message
	    		SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
	    		passwordResetEmail.setFrom("employee.portal.training@gmail.com");
	    		passwordResetEmail.setTo(employee.getEmailId() );
	    		passwordResetEmail.setSubject("Password Reset Request");
	    		passwordResetEmail.setText("To reset your password, click the link below:\n"+ appUrl
	    				+ "forgotPassword/reset?token=" +  employeeForgotPassword.getToken());
				
	    		emailService.sendEmail(passwordResetEmail);
	    		System.out.println("Employee null nhi aya" + appUrl + "mail send ho jaana chahiye");	

	    		// Add success message to view
	    		modelAndView.addObject("successMessage", "A password reset link has been sent to " + employeeEmail);
	    	}catch(SQLException e){
	    		modelAndView.addObject("errorMessage", "Some Error Occured in the Database. Please try again later.");
	    	}
	 //}
	    }
	     modelAndView.setViewName("employee/login");
	     return modelAndView;
	  }
	 
	 @RequestMapping(value = "/reset", method = RequestMethod.GET)
		public String resetThePassword(Model modelAndView,@RequestParam("token") String token) {
		 	EmployeeForgotPassword employeeForgotPassword = employeeService.findUserByResetToken(token);
		 	PasswordAndToken newObject = new PasswordAndToken();
		 	newObject.setResetToken(token);
		 	modelAndView.addAttribute("employeeObject", newObject);
		    if (employeeForgotPassword!=null) { // Token found in DB
		    		return "employee/changePassword";
		    } else { // Token not found in DB
		      modelAndView.addAttribute("errorMessage", "Oops!  This is an invalid password reset link.");
		    }
		    return "employee/login";
		}
	 
	 @RequestMapping(value = "/reset", method = RequestMethod.POST)
		public ModelAndView resetThePasswordPost(ModelAndView modelAndView,@ModelAttribute("employeeObject") PasswordAndToken object) {
		 System.out.println(object.getPassword());
		 System.out.println(object.getResetToken());
		 try{
		 	EmployeeForgotPassword employeeForgotPassword = employeeService.findUserByResetToken(object.getResetToken());
		 	if(employeeForgotPassword==null)
		 	{
		 		System.out.println("Token nhi mila");
		 		throw new NullPointerException();
		 	}
		 	Employee employee = employeeService.getEmployeeByIdString(employeeForgotPassword.getEmpCode());
		 	if(employee==null)
		 	{
		 		System.out.println("Employee nhi mila");
		 		throw new NullPointerException();
		 	}
		 	employee.setPassword(object.getPassword());
		 		if(employeeService.updateEmployeePassword(employee)){
		 			modelAndView.addObject("successMessage","Your Password has been successfully changed");
		 		}
		 		else{
		 			throw new SQLException();
		 		}
		 	employeeService.deleteToken(object.getResetToken());
		 	}catch(SQLException e)
		 	{
		 		modelAndView.addObject("errorMessage","Some Error Occured Please get the password Token again.");
		 		employeeService.deleteToken(object.getResetToken());
		 		
		 	}catch( NullPointerException e){
		 		modelAndView.addObject("errorMessage","There has been some mistake please check the email and try again.");
		 		employeeService.deleteToken(object.getResetToken());
		 	}
		 	modelAndView.setViewName("redirect:/employee/login");
		    return modelAndView;
		}
}
