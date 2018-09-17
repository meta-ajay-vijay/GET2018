package com.metacube.training.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.EmployeeAndJobDetails;
import com.metacube.training.model.EmployeeModel;
import com.metacube.training.service.interfaces.EmployeeService;
import com.metacube.training.service.interfaces.EmployeeSkillService;
import com.metacube.training.service.interfaces.SkillService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SkillService SkillService;

	@Autowired
	HttpSession session;
	
	@Autowired
	private EmployeeSkillService employeeSkillService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute(new EmployeeAndJobDetails());
		return "employee/login";
	}
	
	@RequestMapping(path = "/back", method = RequestMethod.GET)
	public String backToDashboard() {
		return "employee/dashboard";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String empCode,
			@RequestParam(name = "password") String password,HttpServletRequest request) {
		try {
			EmployeeAndJobDetails employeeAndJobDetails = new EmployeeAndJobDetails();
			employeeAndJobDetails.setEmpCode(empCode);
			employeeAndJobDetails.setPassword(password);

			EmployeeModel empData = employeeService.getEmployeeById(employeeAndJobDetails);
			request.getSession().setAttribute("empCode", empData.getEmpCode());
			request.getSession().setAttribute("password", empData.getPassword());

			return new ModelAndView("employee/dashboard", "username", empCode);

		} catch (Exception e) {
			return new ModelAndView("employee/error");
		}

	}

	@RequestMapping(path = "/showProfile", method = RequestMethod.GET)
	public String getAllprojects(Model model, HttpServletRequest request) {
		EmployeeAndJobDetails employeeAndJobDetails = new EmployeeAndJobDetails();
		employeeAndJobDetails.setEmpCode(request.getSession().getAttribute("empCode").toString());
		employeeAndJobDetails.setPassword(request.getSession().getAttribute("password").toString());
		model.addAttribute("employees",employeeService.getEmployeeById(employeeAndJobDetails));

		return "employee/profile";
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "employee/login";
	}

	@RequestMapping(path = "/searchEmployee", method = RequestMethod.GET)
	public String search(Model model) {
		return "employee/search";
	}

	@RequestMapping(path = "/searchEmployee", method = RequestMethod.POST)
	public String search(@RequestParam(name = "search") String searchString, Model model) {
		try {
			EmployeeModel employeeAndJobDetails = employeeService.getEmployeeByIdString(searchString);

			model.addAttribute("employees", employeeAndJobDetails);
			return "employee/profile";
		} catch (Exception e) {
			return "employee/error2";
		}
	}
	
	@RequestMapping(path = "/addSkill", method = RequestMethod.GET)
	public ModelAndView search(ModelAndView modelAndView) {
	
		modelAndView.addObject("skillList",SkillService.getAllSkills());
		modelAndView.addObject("skills",new String[10]);
		modelAndView.setViewName("employee/addSkill");
		return modelAndView;
	}
	
	@RequestMapping(path = "/addSkill", method = RequestMethod.POST)
	public ModelAndView search(ModelAndView modelAndView,  @RequestParam("skills") String skills[], HttpServletRequest request) {
		System.out.println("sdsadsad"+Arrays.toString(skills));
		System.out.println(skills[0]);
		modelAndView.setViewName("employee/dashboard");
		employeeSkillService.addSkillsToEmployee(request.getSession().getAttribute("empCode").toString(), skills);

		return modelAndView;
	}


	

}