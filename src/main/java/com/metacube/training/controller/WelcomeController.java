package com.metacube.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.model.Employee;
import com.metacube.training.service.interfaces.SkillService;

@Controller
public class WelcomeController {
	@Autowired
	SkillService skillService;

	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String afterLogin(HttpServletRequest request) {

	
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin/security";
		}else if(request.isUserInRole("ROLE_EMPLOYEE")){
			
			return "redirect:/employee/security";
		}
		return "redirect:/error";
	}
	
	@RequestMapping(value = "/error" , method = RequestMethod.GET)
	public String errorPage(){
		return "error";
	}
	
	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	

	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String search(Model model) {
		return "search";
	}

	@RequestMapping(path = "/list", method = RequestMethod.POST)
	public String search(@RequestParam(name = "search") String searchString,
			Model model) {
		System.out.println("AAA");
		System.out.println(skillService.getAllSkills().get(0).getEmployeesSkills().size());
		try {
			List<Employee> employeeList = skillService.getEmployeesBySkills(searchString);
			System.out.println("size"+employeeList.size());

			model.addAttribute("list",employeeList);
			return "./list";
		} catch (Exception e) {
			System.out.println("problemn:"+e.getMessage());
			return "employee/error2";
		}
	}
}