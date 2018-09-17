package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Job;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.serviceinterface.EmployeeService;
import com.metacube.training.service.serviceinterface.JobService;
import com.metacube.training.service.serviceinterface.ProjectService;
import com.metacube.training.service.serviceinterface.SkillService;
import com.metacube.training.transferObjects.EmployeeTransferObjectWithJobDetails;


@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JobService jobService;
	

	@Autowired
	private SkillService skillService;
	
	
	
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		return new ModelAndView("admin/dashboard", "username", username);
	}



	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String createproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		System.out.println("I am here==" + project.toString());
		if(project!= null && project.getId() == null) {
			System.out.println("I am here111==" + projectService);
			projectService.createProject(project);	
		}else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}

	@RequestMapping(path = "/projects/edit", method = RequestMethod.GET)
	public String editproject(Model model, @RequestParam("id") Long id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
	public String deleteproject(@RequestParam("id") Long id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}

	
	/*
	 * Job Functionalities Start here.
	 * 
	 * 
	 */
	@RequestMapping(path = "/jobs", method = RequestMethod.GET)
	public String getAlljobs (Model model) {
		model.addAttribute("jobs", jobService.getAllJobs());
		return "admin/jobs/jobs";
	}
	
	@RequestMapping(path = "/jobs/add", method = RequestMethod.GET)
	public String createJob (Model model) {
		model.addAttribute("job", new Job());
		return "admin/jobs/editjobs";
	}
	
	@RequestMapping(path = "/jobs", method = RequestMethod.POST)
	public String saveJob (@ModelAttribute("job") Job job) {
		System.out.println("Hello");
		if(job.getName()!= null) {
			jobService.createJob(job);
		}
		return "redirect:/admin/jobs";
	}
	
	
	/*
	 * Skill Functionalities Start here.
	 * 
	 * 
	 */
	@RequestMapping(path = "/skills", method = RequestMethod.GET)
	public String getAllskills (Model model) {
		model.addAttribute("skills", skillService.getAllSkills());
		return "admin/skills/skills";
	}
	
	@RequestMapping(path = "/skills/add", method = RequestMethod.GET)
	public String createSkill (Model model) {
		model.addAttribute("skill", new Skill());
		return "admin/skills/editskills";
	}
	
	@RequestMapping(path = "/skills", method = RequestMethod.POST)
	public String saveSkill (@ModelAttribute("skill") Skill skill) {
		if(skill.getName()!= null) {
			skillService.createSkill(skill);
		}
		return "redirect:/admin/skills";
	}
	
	
	 /* Employee Functionalities Start here.*/
	 
	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public String getAllemployees (Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "admin/employee/employees";
	}
	
	@RequestMapping(path = "/employees/add", method = RequestMethod.GET)
	public String createEmployee (Model model) {
		model.addAttribute("employee", new EmployeeTransferObjectWithJobDetails());
		model.addAttribute("jobs",jobService.getAllJobs());
		model.addAttribute("projects",projectService.getAllProjects());
		model.addAttribute("teamleaders",employeeService.getTeamLeaders());
		model.addAttribute("managers",employeeService.getManagers());
		return "admin/employee/editEmployee";
	}
	
	@RequestMapping(path = "/employees", method = RequestMethod.POST)
	public String saveEmployee (@ModelAttribute("employee") EmployeeTransferObjectWithJobDetails employeeTransferObject) {
		if(employeeTransferObject!=null && employeeTransferObject.getEmpCode() == null) {
			employeeService.createEmployee(employeeTransferObject);
		}
		return "redirect:/admin/employees";
	}
	
	@RequestMapping(path = "/employees/enable", method = RequestMethod.GET)
	public String enableEmployee (@RequestParam("empCode") String empCode) {
		employeeService.enableEmployee(empCode);
		return "redirect:/admin/employees";
	}
	
	@RequestMapping(path = "/employees/disable", method = RequestMethod.GET)
	public String disableEmployee (@RequestParam("empCode") String empCode) {
		employeeService.disableEmployee(empCode);
		return "redirect:/admin/employees";
	}
	/*
	 * Skill Employee Search
	 */
	
	@RequestMapping(path = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee (Model model) {
		model.addAttribute("skillList",skillService.getAllSkills());
		model.addAttribute("employees",new ArrayList<Employee>());
		return "CommonFeatures/SearchEmployees";
	}
	
	@RequestMapping(path = "/searchEmployeeBySkill", method = RequestMethod.POST)
	public String searchEmployeeById (Model model,@RequestParam ("skillIdSelect") String skillId) {
		System.out.println(skillId);
		//Long skillIdInLong =Long.valueOf(skillId);
		Skill skillObject = skillService.getSkillById(Long.parseLong(skillId));
		model.addAttribute("employees",skillObject.getEmployees());
		System.out.println(skillObject.getEmployees().isEmpty());
		return "CommonFeatures/SearchEmployees";
	}
	
}
