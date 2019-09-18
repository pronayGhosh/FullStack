package com.springboot.service;

import java.util.List;

import com.springboot.bo.ParentTaskVO;
import com.springboot.bo.ProjectVO;
import com.springboot.bo.TaskVO;
import com.springboot.bo.UserVO;

/**
 * @author 555194
 *
 */
public interface ProjectManagerService {
	
	public List<TaskVO> retriveTasks();
	public void updateTask(TaskVO task);
	
	public List<ParentTaskVO> retriveParentTasks();
	public List<ParentTaskVO> retriveParentTasksForProjectId(String projectId);
	public void updateParentTask(ParentTaskVO parentTask);
	
	public List<ProjectVO> retriveProjects();
	public void updateProject(ProjectVO project);
	
	public List<UserVO> retriveUsers();
	public void updateUser(UserVO user);

}
