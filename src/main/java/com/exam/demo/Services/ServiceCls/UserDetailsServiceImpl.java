package com.exam.demo.Services.ServiceCls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.demo.Entity.User;
import com.exam.demo.Repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userrepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = this.userrepository.findByUsername(username);
		
		if(user == null) {
			System.out.println(" User Not Found ");
			throw new UsernameNotFoundException(" No User Found !!!!");
		}
		return null;
	}

}
