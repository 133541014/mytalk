
package com.origen.mytalk.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户信息
 * 
 * @author: origen.wang
 * @date: 2017年8月7日
 */
public class User implements UserDetails {

	private static final long serialVersionUID = 431647958541687042L;

	// uuid生成策略
	private String id;

	private String username;

	private String password;

	private String email;

	private String nickname;

	// 个人说明
	private String description;

	// 头像路径
	private String headImage;

	private String createDate;

	public User() {
		super();
	}

	public String getId() {

		return id;
	}

	public void setId(String id) {

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

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getNickname() {

		return nickname;
	}

	public void setNickname(String nickname) {

		this.nickname = nickname;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public String getHeadImage() {

		return headImage;
	}

	public void setHeadImage(String headImage) {

		this.headImage = headImage;
	}

	public String getCreateDate() {

		return createDate;
	}

	public void setCreateDate(String createDate) {

		this.createDate = createDate;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {

		return null;
	}

	public boolean isAccountNonExpired() {

		return true;
	}

	public boolean isAccountNonLocked() {

		return true;
	}

	public boolean isCredentialsNonExpired() {

		return true;
	}

	public boolean isEnabled() {

		return true;
	}

}
