package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bo.ParentTaskVO;
import com.springboot.bo.ProjectVO;
import com.springboot.bo.TaskVO;
import com.springboot.bo.UserVO;
import com.springboot.service.ProjectManagerService;

/**
 * @author 555194
 *
 */
@RestController
public class ProjectManagerController {
	
	private ProjectManagerService projectManagerService;

	
	@Autowired
	public ProjectManagerController(ProjectManagerService projectManagerService) {
		this.projectManagerService = projectManagerService;
	}

	@GetMapping("/home")
	public String home() {
		return "forward:/index.html";
	}
	
	@GetMapping("/test")
	public String testhome() {
		return "Project Manager Full Stack Web App";
	}
	
	
	@GetMapping("/api/tasks")
	public List<TaskVO> getTasks() {
		List<TaskVO> tasks = projectManagerService.retriveTasks();
		return tasks;
	}
	
	@PostMapping(path = "/api/tasks", consumes = "application/json", produces = "application/json")
	public boolean updateTask(@RequestBody TaskVO task) {
		try {
			projectManagerService.updateTask(task); 
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	
	@GetMapping("/api/parenttasks")
	public List<ParentTaskVO> getAllParentTasks() {
		List<ParentTaskVO> tasks = projectManagerService.retriveParentTasks();
		return tasks;
	}
	
	@GetMapping("/api/parenttasks/projects/{projectId}")
	public List<ParentTaskVO> getParentTasksForProjectId(@PathVariable(name="projectId") String projectId) {
		List<ParentTaskVO> tasks = projectManagerService.retriveParentTasksForProjectId(projectId); 
		return tasks;
	}
	
	@PostMapping(path = "/api/parenttasks", consumes = "application/json", produces = "application/json")
	public boolean updateParentTask(@RequestBody ParentTaskVO parentTask) {
		try {
			projectManagerService.updateParentTask(parentTask);
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	
	@GetMapping("/api/projects")
	public List<ProjectVO> getProjects() {
		List<ProjectVO> projects = projectManagerService.retriveProjects();
		return projects;
	}
	
	@PostMapping(path = "/api/projects", consumes = "application/json", produces = "application/json")
	public boolean updateProject(@RequestBody ProjectVO project) {
		try {
			projectManagerService.updateProject(project);
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	
	@GetMapping("/api/users")
	public List<UserVO> getUsers() {
		List<UserVO> users = projectManagerService.retriveUsers();
		return users;
	}
	
	@PostMapping(path = "/api/users", consumes = "application/json", produces = "application/json")
	public boolean updateUsers(@RequestBody UserVO user) {
		try {
			projectManagerService.updateUser(user);
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	
}
