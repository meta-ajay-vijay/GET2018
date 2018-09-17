package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.service.serviceinterface.EmployeeService;
import com.metacube.training.service.serviceinterface.SkillService;
import com.metacube.training.transferObjects.EmployeeSkills;
import com.metacube.training.transferObjects.EmployeeTransferObjectWithJobDetails;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	SkillService skillService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "employee/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String empCode,
			@RequestParam(name = "password") String password,
			HttpServletRequest request) {
		try {
			Employee empData = employeeService.getEmployeeById(empCode);
			request.getSession().setAttribute("empCode", empData.getEmpCode());
			request.getSession().setAttribute("password", empData.getPassword());

			return new ModelAndView("employee/dashboard", "username", empCode);

		} catch (Exception e) {
			return new ModelAndView("employee/error");
		}

	}
	
	@RequestMapping(path = "/showProfile", method = RequestMethod.GET)
	public String getAllprojects(Model model, HttpServletRequest request) {
		String empCode= (String) request.getSession().getAttribute("empCode");
		model.addAttribute("employees",
				employeeService.getEmployeeById(empCode));

		return "employee/profile";

	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
	request.getSession().invalidate();
	return "employee/login";
	}

	@RequestMapping(value = "/addSkill", method = RequestMethod.GET)
	public ModelAndView addSkill(ModelAndView model) {
		model.addObject("employeeSkill",new EmployeeSkills());
		System.out.println(skillService.getAllSkills().size());
		model.addObject("skillList",skillService.getAllSkills());
		model.setViewName("employee/addSkill");
		return model;
	}
	
	@RequestMapping(value = "/addSkill", method = RequestMethod.POST)
	public ModelAndView addSkill(@ModelAttribute("employeeSkill") EmployeeSkills employee,HttpServletRequest request  ) {
		HttpSession session = request.getSession();
		String empCode = (String) session.getAttribute("empCode");
		employee.setEmpCode(empCode);
		employeeService.addSkills(employee);
		System.out.println(employee.getEmpCode());
		return new ModelAndView("employee/dashboard");
	}
}
