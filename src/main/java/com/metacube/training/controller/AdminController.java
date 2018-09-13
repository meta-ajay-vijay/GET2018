package com.metacube.training.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeCodeAndPassword;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.interfaces.EmployeeService;
import com.metacube.training.service.interfaces.JobTitleService;
import com.metacube.training.service.interfaces.ProjectService;
import com.metacube.training.service.interfaces.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private JobTitleService jobTitleService;

	@Autowired
	private SkillService skillService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private JavaMailSender emailSender;

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, HttpServletRequest request) {
		try {
			Employee employee = new Employee();
			employee.setEmpCode(username);
			employee.setPassword(password);

			EmployeeCodeAndPassword empData = employeeService.getAdminById(employee);
			request.getSession().setAttribute("empCode", empData.getEmpCode());
			request.getSession().setAttribute("password", empData.getPassword());

			return new ModelAndView("admin/dashboard", "username", empData.getEmpCode());
		} catch (Exception e) {
			return new ModelAndView("employee/error");
		}
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("empCode");
		request.getSession().removeAttribute("password");
		request.getSession().invalidate();
		return "redirect:/admin/login";
	}

	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String back() {
		return "admin/dashboard";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		System.out.println("called: /projects (GET): response: admin/projects");

		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}

	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String createproject(Model model) {
		System.out.println("called: /project/add (GET): response: admin/editProject");

		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		System.out.println("called: /projects (POST) : response: admin/editProject(redirect)");

		if (project != null && project.getId() == null) {
			projectService.createProject(project);
		} else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/projects/edit", method = RequestMethod.GET)
	public String editproject(Model model, @RequestParam("id") Long id) {
		System.out.println("called:/projects/edit(GET) response: admin/editProject");

		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
	public String deleteproject(@RequestParam("id") Long id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}

	/*
	 * Job Functionalities
	 */

	@RequestMapping(path = "/jobs/add", method = RequestMethod.GET)
	public String createjob(Model model) {
		System.out.println(" job called: /project/add (GET): response: admin/editProject");

		model.addAttribute("job", new JobTitle());
		return "admin/editJob";
	}

	@RequestMapping(path = "/jobs", method = RequestMethod.POST)
	public String saveJob(@ModelAttribute("job") JobTitle jobTitle) {
		System.out.println("jobs called: /projects (POST) : response: admin/editProject(redirect)");

		if (jobTitle != null && jobTitle.getId() == 0) {
			jobTitleService.createJobTitle(jobTitle);
		} else {
			jobTitleService.updateJobTitle(jobTitle);
		}
		return "redirect:/admin/jobs";
	}

	@RequestMapping(path = "/jobs", method = RequestMethod.GET)
	public String getAlljobs(Model model) {
		System.out.println("called jobs: /projects (GET): response: admin/projects");

		model.addAttribute("jobs", jobTitleService.getAllJobTitle());
		return "admin/jobs";
	}

	@RequestMapping(path = "/jobs/edit", method = RequestMethod.GET)
	public String editJob(Model model, @RequestParam("id") int id) {
		System.out.println("called:/projects/edit(GET) response: admin/editProject");

		model.addAttribute("job", jobTitleService.getJobTitleById(id));
		return "admin/editjob";
	}

	@RequestMapping(path = "/jobs/delete", method = RequestMethod.GET)
	public String deleteJobTitle(@RequestParam("id") int id) {
		jobTitleService.deleteJobTitle(id);
		return "redirect:/admin/jobs";
	}

	/**
	 * code for skills start from here
	 */

	@RequestMapping(path = "/skills", method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skills", skillService.getAllSkills());
		return "admin/skills";
	}

	@RequestMapping(path = "/skills/add", method = RequestMethod.GET)
	public String createSkills(Model model) {
		model.addAttribute("skill", new Skill());
		return "admin/addSkill";
	}

	@RequestMapping(path = "/skills", method = RequestMethod.POST)
	public String saveSkill(@ModelAttribute("skill") Skill skill) {
		if (skill != null && skill.getId() == 0) {
			skillService.createSkill(skill);
		}
		return "redirect:/admin/skills";
	}

	/**
	 * code for employee
	 */

	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		System.out.println("called: /employees (GET): response: admin/employees");

		model.addAttribute("employees", employeeService.getAllEmployee());
		return "admin/employees";
	}

	@RequestMapping(path = "/employees/delete", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam("empCode") String id) {
		System.out.println("Employee to delete: " + id);
		employeeService.deleteEmployee(id);
		return "redirect:/admin/employees";
	}

	@RequestMapping(path = "/employee", method = RequestMethod.GET)
	public String goToEmployeePage(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("jobs", jobTitleService.getAllJobTitle());
		model.addAttribute("projects", projectService.getAllProjects());
		model.addAttribute("teamLeaders", employeeService.getTeamLeaders());
		model.addAttribute("managers", employeeService.getManagers());
		return "admin/addEmployee";
	}

	@RequestMapping(path = "/employee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee, HttpServletRequest request) {
		System.out.println("Emp add ho raha hai");
		String token = UUID.randomUUID().toString();
		employee.setToken(token);
		boolean isCreated = employeeService.createEmployee(employee);
		if (isCreated) {
			boolean isJobDetailsAdded = employeeService.addJobDetails(employee);
			if (isJobDetailsAdded) {
				String activateUrl = "http://" + request.getServerName() + ":8080/employeePortal/admin/activate?token=" + token;
				String to = employee.getEmailId();
				String subject = "Account activation link";
				String text = "To activate your account, click the link below:\n" + activateUrl;
				System.out.println("mail send wala method call ho raha hai");
				sendSimpleMessage(to, subject, text);
			}
		}
		return "redirect:/admin/employees";
	}

	private void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		System.out.println("first mail send hone se phle");
		emailSender.send(message);
	}

	@GetMapping("/activate")
	public String activateAccount(@RequestParam("token") String token, Model model) {
		String redirectTo;
		Employee employeeToActivate = employeeService.getEmployeeByToken(token);
		if (employeeToActivate != null) {
			employeeService.activateEmployeeByEmployeeCodeAndRemoveToken(employeeToActivate.getEmpCode());
			String to = employeeToActivate.getEmailId();
			String subject = "Account Created";
			String text = "Hello " + employeeToActivate.getFirstName() + " " + employeeToActivate.getLastName() + ",\n"
					+ "UserName: " + employeeToActivate.getEmpCode() + "\n" + "password: "
					+ employeeToActivate.getPassword();
			sendSimpleMessage(to, subject, text);
			redirectTo = "redirect:/employee/login";
		} else {
			redirectTo = "employee/error";
		}
		return redirectTo;
	}

}
