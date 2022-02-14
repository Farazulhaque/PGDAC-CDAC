package com.cdac.restex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.restex.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
