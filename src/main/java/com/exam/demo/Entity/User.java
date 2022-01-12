package com.exam.demo.Entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "User")
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username ;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private boolean enabled = true;
	private String profile;
	
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public User() {}

	
	public User(int id, String username, String password, String firstname, String lastname, String email, String phone,
			boolean enabled, String profile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.enabled = enabled;
		this.profile = profile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	// user role 
	@OneToMany(cascade = CascadeType.ALL , fetch =  FetchType.EAGER , mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userrole = new HashSet<>();

	public Set<UserRole> getUserrole() {
		return userrole;
	}

	public void setUserrole(Set<UserRole> userrole) {
		this.userrole = userrole;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		Set<Authority> set = new HashSet<>();
		this.userrole.forEach(userRole ->{
			  set.add(new Authority(userRole.getRole().getRolename()));
			  // getRole() will return object of Role class and getRoleName() is the whether user is admin or normal user
		});
		return set;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
}
