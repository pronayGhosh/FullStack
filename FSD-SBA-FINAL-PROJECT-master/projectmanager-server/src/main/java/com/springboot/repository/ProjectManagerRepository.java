package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Project;

/**
 * @author 555194
 *
 */
@Repository
public interface ProjectManagerRepository extends JpaRepository<Project,Long>{

}

