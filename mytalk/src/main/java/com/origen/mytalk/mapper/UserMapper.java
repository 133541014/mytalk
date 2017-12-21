
package com.origen.mytalk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.origen.mytalk.model.User;

@Mapper
public interface UserMapper {

	void addUser(User user);

	User findByUsername(@Param(value = "username") String username);

	User findByEmail(@Param(value = "email") String email);

	List<User> findByParam(@Param(value = "param") String param);

}
