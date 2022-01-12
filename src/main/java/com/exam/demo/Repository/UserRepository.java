package com.exam.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.demo.Entity.User;

public interface UserRepository extends JpaRepository<User , Long> {

	User findByUsername(String username);

}
