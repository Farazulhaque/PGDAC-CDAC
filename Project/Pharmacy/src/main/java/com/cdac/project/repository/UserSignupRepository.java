package com.cdac.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.project.model.User;

public interface UserSignupRepository extends JpaRepository<User, Integer> {

}
