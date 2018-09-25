package com.metacube.training.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeAndJobDetails;
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

	@RequestMapping(path = "/security", method = RequestMethod.GET)
	public String adminDashboard(
			HttpServletRequest request) {
		try {
			request.getSession().setAttribute("empCode", "E18/0000");
			request.getSession().setAttribute("password", "abcd");
			return "employee/dashboard";
		} catch (Exception e) {
			return "employee/error";
		}
	}

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
			@RequestParam(name = "password") String password,
			HttpServletRequest request) {
		try {
			EmployeeAndJobDetails employee = new EmployeeAndJobDetails();
			employee.setEmpCode(empCode);
			employee.setPassword(password);
			Employee empData = employeeService.getEmployeeById(employee);
			request.getSession().setAttribute("empCode", empData.getEmpCode());
			request.getSession().setAttribute("password", empData.getPassword());
			return new ModelAndView("employee/dashboard", "username", empCode);
		} catch (Exception e) {
			return new ModelAndView("employee/error");
		}
	}

	@RequestMapping(path = "/showProfile", method = RequestMethod.GET)
	public String getAllprojects(Model model, HttpServletRequest request) {
		EmployeeAndJobDetails employee = new EmployeeAndJobDetails();
		employee.setEmpCode(request.getSession().getAttribute("empCode").toString());
		employee.setPassword(request.getSession().getAttribute("password").toString());
		model.addAttribute("employees",employeeService.getEmployeeById(employee));

		return "employee/showProfile";
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
	public String search(@RequestParam(name = "search") String searchString,
			Model model) {
		try {
			Employee employee = employeeService.getEmployeeByIdString(searchString);

			model.addAttribute("employees", employee);
			return "employee/profile";
		} catch (Exception e) {
			return "employee/error2";
		}
	}

	@RequestMapping(path = "/edit", method = RequestMethod.GET)
	public String editEmployee(Model model,@RequestParam("empCode") String empCode) {
		Employee employeeToEdit = employeeService.getEmployeeByIdString(empCode);
		System.out.println(employeeToEdit.getDob());
		model.addAttribute("employees", employeeToEdit);
		return "employee/editEmployee";
	}

	@RequestMapping(path = "/edit", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employees") Employee employee) {
		boolean resultOfUpdation = employeeService.updateEmployee(employee);
		String resultToReturn;
		if (resultOfUpdation) {
			resultToReturn = "redirect:/employee/showProfile";
		} else {
			resultToReturn = "redirect:/employee/edit?empCode=' + employees.empCode";
		}
		return resultToReturn;
	}

	@RequestMapping(path = "/addSkill", method = RequestMethod.GET)
	public ModelAndView search(ModelAndView modelAndView) {

		modelAndView.addObject("skillList", SkillService.getAllSkills());
		modelAndView.addObject("skills", new String[10]);
		modelAndView.setViewName("employee/addSkill");
		return modelAndView;
	}

	@RequestMapping(path = "/addSkill", method = RequestMethod.POST)
	public ModelAndView search(ModelAndView modelAndView,
			@RequestParam("skills") String skills[], HttpServletRequest request) {
		System.out.println("sdsadsad" + Arrays.toString(skills));
		System.out.println(skills[0]);
		modelAndView.setViewName("employee/dashboard");
		employeeSkillService.addSkillsToEmployee(request.getSession().getAttribute("empCode").toString(), skills);

		return modelAndView;
	}
	
	@RequestMapping(path = "/searchBySkill", method = RequestMethod.GET)
	public String searchBySkill(Model model) {
		return "employee/searchBySkill";
	}

	@RequestMapping(path = "/list", method = RequestMethod.POST)
	public String searchBySkill(@RequestParam(name = "search") String searchString,Model model) {
		System.out.println("AAA");
		System.out.println(SkillService.getAllSkills().get(0).getEmployeesSkills().size());
		try {
			List<Employee> employeeList = SkillService.getEmployeesBySkills(searchString);
			System.out.println("size"+employeeList.size());
			model.addAttribute("list",employeeList);
			return "employee/list";
		} catch (Exception e) {
			System.out.println("problemn:"+e.getMessage());
			return "employee/error2";
		}
	}
}
