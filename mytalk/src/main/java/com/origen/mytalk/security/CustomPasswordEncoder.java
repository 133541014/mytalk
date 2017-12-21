/**
 * Copyright (c) 2007 Beijing Shiji Kunlun Software Co., Ltd. All Rights Reserved.
 * $Id$
 */

package com.origen.mytalk.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * StandardPasswordEncoder 使用sha-256+8位随机盐值进行加密
 *
 * @author origen.wang
 * @date 2017年8月28日
 */
@Component
public class CustomPasswordEncoder implements PasswordEncoder {

	// 秘钥
	private static final String SECRET = "my-secret";

	@Override
	public String encode(CharSequence rawPassword) {

		StandardPasswordEncoder spe = new StandardPasswordEncoder(SECRET);
		return spe.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {

		StandardPasswordEncoder spe = new StandardPasswordEncoder(SECRET);

		return spe.matches(rawPassword, encodedPassword);

	}

}
