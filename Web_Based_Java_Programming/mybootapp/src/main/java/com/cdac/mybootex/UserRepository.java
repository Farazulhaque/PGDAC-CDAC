package com.cdac.mybootex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u where u.email=?1")
	User findByEmail(String email);
}
