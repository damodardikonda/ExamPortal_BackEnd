package com.exam.demo.Services.ServiceCls;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.demo.Entity.User;
import com.exam.demo.Entity.UserRole;
import com.exam.demo.Repository.RoleRepository;
import com.exam.demo.Repository.UserRepository;
import com.exam.demo.Services.UserService;

@Service
public class UserServiceCls implements UserService{

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private RoleRepository rolerepository;
	
	@Override
	public User createuser(User user, Set<UserRole> userrole) throws Exception{
		// TODO Auto-generated method stub
		
		// check username is already present or not
		User local = this.userrepository.findByUsername(user.getUsername());
		
		if(local != null) {
			System.out.println(" User is already there");
			throw new Exception(" User is already Present ");
		}else{
			for(UserRole ur : userrole) {
				
				rolerepository.save(ur.getRole());
			}
			
			user.getUserrole().addAll(userrole);
			local = this.userrepository.save(user);
		}
		return local;
	}
	
	public User getUser(String username) {
		return this.userrepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		this.userrepository.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		
		//int userid = user.getId();
		return this.userrepository.save(user);
	}
	
	

}
