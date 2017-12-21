
package com.origen.mytalk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.origen.mytalk.security.CustomPasswordEncoder;
import com.origen.mytalk.service.impl.UserServiceImpl;

/**
 * Spring Security配置
 * 
 * @author: origen.wang
 * @date: 2017年12月5日
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserServiceImpl UserServiceImpl;

	@Autowired
	private CustomPasswordEncoder customPasswordEncoder;

	@Override
	public void configure(WebSecurity web) throws Exception {

		// 设置不拦截规则
		web.ignoring()
						.antMatchers("/js/**")
						.antMatchers("/css/**")
						.antMatchers("/fonts/**")
						.antMatchers("/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// // 不拦截post请求
		http.csrf().disable();

		http.authorizeRequests()
						// 设置拦截规则
						.antMatchers("/register", "/")
						.permitAll()
						.anyRequest()
						.authenticated()
						.and()
						// 开启默认登录页面
						.formLogin()
						// 默认登录action 触发loadUserByUsername方法
						.loginPage("/login")
						.defaultSuccessUrl("/toIndex")
						.permitAll()
						.and()
						// 设置注销
						.logout()
						.logoutUrl("/loguot")
						.logoutSuccessUrl("/login")
						.invalidateHttpSession(true)
						.deleteCookies("remember-me")
						.and()
						.rememberMe()
						.tokenValiditySeconds(2592000)// 30 days
						.and()
						.exceptionHandling()
						.accessDeniedPage("/error");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(UserServiceImpl).passwordEncoder(customPasswordEncoder);
	}

}
