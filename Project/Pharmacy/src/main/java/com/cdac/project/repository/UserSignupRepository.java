package com.cdac.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.project.model.UserSignup;

public interface UserSignupRepository extends JpaRepository<UserSignup, Integer> {

}
