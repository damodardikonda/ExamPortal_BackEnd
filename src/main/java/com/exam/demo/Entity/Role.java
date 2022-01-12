package com.exam.demo.Entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role {

	@Id
	private Long roleId;
	private String rolename;
	
	public Role(){}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Set<UserRole> getUserrole() {
		return userrole;
	}

	public void setUserrole(Set<UserRole> userrole) {
		this.userrole = userrole;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Role(Long roleId, String rolename) {
		super();
		this.roleId = roleId;
		this.rolename = rolename;
	}
	
	@OneToMany(cascade = CascadeType.ALL , fetch =  FetchType.LAZY , mappedBy = "role")
	private Set<UserRole> userrole = new HashSet();
}
