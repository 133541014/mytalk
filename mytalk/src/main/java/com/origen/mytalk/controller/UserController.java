
package com.origen.mytalk.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.origen.mytalk.model.User;
import com.origen.mytalk.service.UserService;

@Controller
public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public String register(User user, String repassword) {

		String result = "";
		try
		{
			result = userService.addUser(user, repassword);

		}
		catch ( Exception e )
		{
			log.error(e.getMessage(), e);
		}

		return result;

	}

	@RequestMapping(value = "/toIndex")
	public ModelAndView toIndex(HttpSession session) {

		try
		{
			SecurityContextImpl securityContextImpl = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");

			User user = (User) securityContextImpl.getAuthentication().getPrincipal();

			session.setAttribute("user", user);
		}
		catch ( Exception e )
		{
			log.error(e.getMessage(), e);
		}

		return new ModelAndView("index");
	}

}
