package com.cdac.mybootex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


public interface UserRepository extends JpaRepository<User, Long> {
	
}
