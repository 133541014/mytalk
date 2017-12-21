
package com.origen.mytalk.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.origen.mytalk.model.User;

public interface UserService extends UserDetailsService {

	String addUser(User user, String repassword);

	List<User> searchUserListForParam(String param);

}
