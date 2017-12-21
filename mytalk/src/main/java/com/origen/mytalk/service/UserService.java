
package com.origen.mytalk.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.origen.mytalk.model.User;

public interface UserService extends UserDetailsService {

	public String addUser(User user, String repassword);

}
