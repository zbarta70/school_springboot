package com.zbarta70.school.models;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {
	
	private User user;
	
	private String firstname;
	private String lastname;
	private Date dateOfBirth;
	private String address;
	private String mobile;
	private String email;
	
	public UserPrincipal(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}	

}
