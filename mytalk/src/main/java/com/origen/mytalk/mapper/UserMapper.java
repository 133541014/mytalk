
package com.origen.mytalk.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.origen.mytalk.model.User;

@Mapper
public interface UserMapper {

	public void addUser(User user);

	public User findByUsername(String username);

	public User findByEmail(String email);

}
