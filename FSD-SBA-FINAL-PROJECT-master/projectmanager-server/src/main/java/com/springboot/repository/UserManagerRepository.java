package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.User;

/**
 * @author 555194
 *
 */
@Repository
public interface UserManagerRepository extends JpaRepository<User,Long>{

}

