package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.service.interfaces.EmployeeService;

@Controller
@RequestMapping("/employee")

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute(new Employee());
		return "employee/login";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView returndashBoard(@ModelAttribute("username") String empCode, HttpServletRequest request) {
		if (request.getSession().getAttribute("empCode") == null) {
			return new ModelAndView("employee/login");
		} else {
			return new ModelAndView("employee/dashboard", "username", request.getSession().getAttribute("empCode"));
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(name = "username") String empCode,
			@RequestParam(name = "password") String password, HttpServletRequest request) {
		try {
			if (request.getSession().getAttribute("empCode") == null) {
				Employee employee = new Employee();
				employee.setEmpCode(empCode);
				employee.setPassword(password);

				Employee empData = employeeService.getEmployeeById(employee);
				request.getSession().setAttribute("empCode", empData.getEmpCode());
				request.getSession().setAttribute("password", empData.getPassword());

				return "redirect:/employee/dashboard";
			} else {
				return "redirect:/employee/login";
			}
		} catch (Exception e) {
			return "employee/error";
		}

	}

	/*
	 * @RequestMapping(value = "/dashboard", method = RequestMethod.GET) public
	 * ModelAndView returndashBoard(@ModelAttribute("username") String empCode,
	 * HttpServletRequest request){ return new
	 * ModelAndView("employee/dashboard", "username",
	 * request.getSession().getAttribute("empCode")); }
	 * 
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public
	 * String login(@RequestParam(name = "username") String empCode,
	 * 
	 * @RequestParam(name = "password") String password, HttpServletRequest
	 * request) { try { Employee employee = new Employee();
	 * employee.setEmpCode(empCode); employee.setPassword(password);
	 * 
	 * Employee empData = employeeService.getEmployeeById(employee);
	 * request.getSession().setAttribute("empCode", empData.getEmpCode());
	 * request.getSession().setAttribute("password", empData.getPassword());
	 * 
	 * return "redirect:employee/dashboard";
	 * 
	 * } catch (Exception e) { return "employee/error"; }
	 * 
	 * }
	 */

	@RequestMapping(path = "/showProfile", method = RequestMethod.GET)
	public String getAllprojects(Model model, HttpServletRequest request) {
		Employee employee = new Employee();
		String empCode = request.getSession().getAttribute("empCode").toString();
		if ("".equals(empCode) || empCode == null) {
			return "employee/login";
		} else {
			employee.setEmpCode(empCode);
			employee.setPassword(request.getSession().getAttribute("password").toString());
			model.addAttribute("employees", employeeService.getEmployeeById(employee));
			return "employee/profile";
		}
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("empCode");
		request.getSession().removeAttribute("password");
		request.getSession().invalidate();
		return "redirect:/employee/login";
	}

	@RequestMapping(path = "/searchEmployee", method = RequestMethod.GET)
	public String search(Model model) {
		return "employee/search";
	}

	@RequestMapping(path = "/searchEmployee", method = RequestMethod.POST)
	public String search(@RequestParam(name = "search") String searchString, Model model) {
		try {
			Employee employee = employeeService.getEmployeeByIdString(searchString);

			model.addAttribute("employees", employee);
			return "employee/profile";
		} catch (Exception e) {
			return "employee/error2";
		}
	}

	@GetMapping("/edit")
	public String editEmployee(Model model, @RequestParam("empCode") String empCode) {
		Employee employeeToEdit = employeeService.getEmployeeByIdString(empCode);
		model.addAttribute("employee", employeeToEdit);
		return "employee/editEmployee";
	}

	@PostMapping("/edit")
	public String updateEmployee(@ModelAttribute("employee") Employee employee) {
		boolean resultOfUpdation = employeeService.updateEmployee(employee);
		String resultToReturn;
		if (resultOfUpdation) {
			resultToReturn = "redirect:/employee/showProfile";
		} else {
			resultToReturn = "redirect:/employee/edit?empCode=' + employees.empCode";
		}
		return resultToReturn;
	}
}
