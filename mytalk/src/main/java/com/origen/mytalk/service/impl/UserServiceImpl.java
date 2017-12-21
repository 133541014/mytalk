
package com.origen.mytalk.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.origen.mytalk.constant.ExceptionName;
import com.origen.mytalk.constant.UserPromptMessage;
import com.origen.mytalk.mapper.UserMapper;
import com.origen.mytalk.model.User;
import com.origen.mytalk.security.CustomPasswordEncoder;
import com.origen.mytalk.service.UserService;
import com.origen.mytalk.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CustomPasswordEncoder customPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userMapper.findByUsername(username);

		if ( user == null )
		{

			throw new UsernameNotFoundException(ExceptionName.USERNAME_NOTFOUND_EXCEPTION);
		}

		return user;
	}

	@Override
	public String addUser(User user, String repassword) {

		if ( StringUtils.isBlank(user.getUsername()) || user.getUsername().length() > 15 || user.getUsername().length() < 6 )
		{
			return UserPromptMessage.USERNAME_ERROR;
		}

		if ( StringUtils.isBlank(user.getPassword()) || user.getPassword().length() > 15 || user.getPassword().length() < 6 )
		{
			return UserPromptMessage.PASSWORD_ERROR;
		}

		if ( !user.getPassword().equals(repassword) )
		{
			return UserPromptMessage.REPASSWORD_ERROR;
		}

		if ( StringUtils.isBlank(user.getNickname()) || user.getNickname().length() > 6 )
		{
			return UserPromptMessage.NICKNAME_ERROR;
		}

		if ( StringUtils.isBlank(user.getEmail()) )
		{
			return UserPromptMessage.EMAIL_ERROR;
		}

		String emailRegex = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";

		if ( !Pattern.matches(emailRegex, user.getEmail()) )
		{
			return UserPromptMessage.EMAIL_ERROR;
		}

		User registerUsername = userMapper.findByUsername(user.getUsername());

		if ( registerUsername != null )
		{
			return UserPromptMessage.USERNAME_EXIST;
		}

		User registerEmail = userMapper.findByEmail(user.getEmail());

		if ( registerEmail != null )
		{
			return UserPromptMessage.EMAIL_EXIST;
		}

		String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

		user.setCreateDate(createDate);

		String passwordHash = customPasswordEncoder.encode(user.getPassword());

		user.setPassword(passwordHash);

		userMapper.addUser(user);

		return "success";
	}

	@Override
	public List<User> searchUserListForParam(String param) {

		param = "%" + param + "%";

		return userMapper.findByParam(param);
	}

}
