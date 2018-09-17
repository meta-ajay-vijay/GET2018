package com.metacube.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.model.EmployeeModel;
import com.metacube.training.service.interfaces.SkillService;

@Controller
public class WelcomeController {
	@Autowired
	SkillService skillService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}

	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String search(Model model) {
		return "search";
	}

	@RequestMapping(path = "/list", method = RequestMethod.POST)
	public String search(@RequestParam(name = "search") String searchString,
			Model model) {
		System.out.println("hey guys");
		System.out.println(skillService.getAllSkills().get(0).getEmployeesSkills().size());
		try {
			List<EmployeeModel> employeeList = skillService.getEmployeesBySkills(searchString);
			System.out.println("size"+employeeList.size());

			model.addAttribute("list",employeeList);
			return "./list";
		} catch (Exception e) {
			System.out.println("problemn:"+e.getMessage());
			return "employee/error2";
		}


	}
}