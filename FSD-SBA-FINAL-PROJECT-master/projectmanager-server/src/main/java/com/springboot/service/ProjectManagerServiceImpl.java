package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bo.ParentTaskVO;
import com.springboot.bo.ProjectVO;
import com.springboot.bo.TaskVO;
import com.springboot.bo.UserVO;
import com.springboot.entity.ParentTask;
import com.springboot.entity.Project;
import com.springboot.entity.Task;
import com.springboot.entity.User;
import com.springboot.repository.ParentTaskManagerRepository;
import com.springboot.repository.ProjectManagerRepository;
import com.springboot.repository.TaskManagerRepository;
import com.springboot.repository.UserManagerRepository;
import com.springboot.service.ProjectManagerService;

/**
 * @author 555194
 *
 */
@Service
public class ProjectManagerServiceImpl implements ProjectManagerService{

	private ProjectManagerRepository projectManagerRepository;
	
	private TaskManagerRepository taskManagerRepository;
	
	private ParentTaskManagerRepository parentTaskManagerRepository;
	
	private UserManagerRepository userManagerRepository;
	
	private Mapper dozerMapper;
	
	@Autowired
	public ProjectManagerServiceImpl(ProjectManagerRepository projectManagerRepository,
			TaskManagerRepository taskManagerRepository, 
			ParentTaskManagerRepository parentTaskManagerRepository,
			UserManagerRepository userManagerRepository, Mapper dozerMapper) {
		this.projectManagerRepository = projectManagerRepository;
		this.taskManagerRepository = taskManagerRepository;
		this.parentTaskManagerRepository = parentTaskManagerRepository;
		this.userManagerRepository = userManagerRepository;
		this.dozerMapper = dozerMapper;
	}

	
	public List<TaskVO> retriveTasks(){
		List<TaskVO> taskToBeReturned = new ArrayList<TaskVO>();
		List<Task> tasksRetrived = taskManagerRepository.findAll();
		for(Task task: tasksRetrived) {
			taskToBeReturned.add(dozerMapper.map(task, TaskVO.class));
		}
		return taskToBeReturned;
	}
	
	public void updateTask(TaskVO task) {
		taskManagerRepository.save(dozerMapper.map(task, Task.class));
	}
	
	
	public List<ParentTaskVO> retriveParentTasks(){
		List<ParentTaskVO> taskToBeReturned = new ArrayList<ParentTaskVO>();
		List<ParentTask> tasksRetrived = parentTaskManagerRepository.findAll();
		for(ParentTask task: tasksRetrived) {
			taskToBeReturned.add(dozerMapper.map(task, ParentTaskVO.class));
		}
		return taskToBeReturned;
	}
	
	public List<ParentTaskVO> retriveParentTasksForProjectId(String projectId){
		List<ParentTaskVO> taskToBeReturned = new ArrayList<ParentTaskVO>();
		List<ParentTask> tasksRetrived = parentTaskManagerRepository.findAllParentTaskByProjectId(projectId); 
		for(ParentTask task: tasksRetrived) {
			taskToBeReturned.add(dozerMapper.map(task, ParentTaskVO.class));
		}
		return taskToBeReturned;
	}
	
	public void updateParentTask(ParentTaskVO parentTask) {
		parentTaskManagerRepository.save(dozerMapper.map(parentTask, ParentTask.class));
	}
	
	
	public List<ProjectVO> retriveProjects(){
		List<ProjectVO> projectToBeReturned = new ArrayList<ProjectVO>();
		List<Project> projectsRetrived = projectManagerRepository.findAll();
		for(Project project: projectsRetrived) {
			ProjectVO projectVO = dozerMapper.map(project, ProjectVO.class);
			projectVO.setNoOfTasks(taskManagerRepository.getTotalTasksForProjectId(projectVO.getProjectId()));
			projectToBeReturned.add(projectVO);
		}
		return projectToBeReturned;
	}
	
	public void updateProject(ProjectVO project) {
		projectManagerRepository.save(dozerMapper.map(project, Project.class));
	}
	
	
	public List<UserVO> retriveUsers(){
		List<UserVO> userToBeReturned = new ArrayList<UserVO>();
		List<User> usersRetrived = userManagerRepository.findAll();
		for(User user: usersRetrived) {
			userToBeReturned.add(dozerMapper.map(user, UserVO.class));
		}
		return userToBeReturned;
	}
	
	public void updateUser(UserVO user) {
		User userStore = dozerMapper.map(user, User.class);
		userManagerRepository.save(userStore);
	}
	
}
