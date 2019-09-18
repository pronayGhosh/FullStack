package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Task;

/**
 * @author 555194
 *
 */
@Repository
public interface TaskManagerRepository extends JpaRepository<Task,Long>{

	/**
	 * @param projectId
	 * @return
	 */
	@Query("SELECT count(t) FROM Task t where t.projectDetails.projectId = ?1")
	public Long getTotalTasksForProjectId(Long projectId);
}

