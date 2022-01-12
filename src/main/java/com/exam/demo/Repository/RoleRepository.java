package com.exam.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.demo.Entity.Role;

public interface RoleRepository extends JpaRepository<Role , Long> {

}
