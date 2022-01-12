package com.exam.demo.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.demo.Entity.Role;
import com.exam.demo.Entity.User;
import com.exam.demo.Entity.UserRole;
import com.exam.demo.Services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins ="*")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user ) throws Exception {
		
		Set<UserRole> userrole = new HashSet<>();
		
		Role role = new Role();
		role.setRoleId(34L);
		role.setRolename("NORMAL");
		
		UserRole ur = new UserRole();
		ur.setUser(user);
		ur.setRole(role);
		
		userrole.add(ur);
		
		return this.userservice.createuser(user , userrole);
	}
	
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		
		return this.userservice.getUser(username);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		
		userservice.deleteUser(id);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		
		return this.userservice.updateUser(user);
	}
}
