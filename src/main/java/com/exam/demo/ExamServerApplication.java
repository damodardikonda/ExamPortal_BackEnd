package com.exam.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.demo.Entity.Role;
import com.exam.demo.Entity.User;
import com.exam.demo.Entity.UserRole;
import com.exam.demo.Services.UserService;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner{

	@Autowired
	private UserService userservice;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class ,args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" Running started");
	/*	
		User user = new User();
		user.setFirstname("Damodar");
		user.setLastname("Dikonda");
		user.setPassword("damsthe");
		user.setUsername("dams");
		user.setEmail("damodar@dikonda");
		user.setPhone("9989787");
		
		Role r1 =  new Role();
		r1.setRoleId(99L);
		r1.setRolename("ADMIN");
		
		Set<UserRole> userroleset = new HashSet();
		UserRole u1 = new UserRole();
		u1.setRole(r1);
		u1.setUser(user);
		
		userroleset.add(u1);
		
		User user1 = this.userservice.createuser(user , userroleset);
		System.out.println(user1.getUsername());
		
		*/
	}	
}
