package com.exam.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name =  "UserRole")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userRoleId;

	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne
	private Role role;
	
	public UserRole(){}

	public UserRole(long userRoleId, User user) {
		super();
		this.userRoleId = userRoleId;
		this.user = user;
	}

}
