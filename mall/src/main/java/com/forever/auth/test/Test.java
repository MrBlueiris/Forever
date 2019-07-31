package com.forever.auth.test;

import com.forever.auth.entity.UserInfo;
import com.forever.auth.utils.JwtUtils;
import com.forever.auth.utils.RsaUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		/**
		 * 生成公钥和私钥
		 */
		RsaUtils.generateKey("E:\\rsa\\rsa.pub", "E:\\rsa\\rsa.pri", "forever");
	}
	/**
	 * 生成Token
	 */
	@org.junit.Test
	public void generateToken() throws Exception {
		String token = JwtUtils.generateToken(new UserInfo(20L, "admin"), RsaUtils.getPrivateKey("E:\\rsa\\rsa.pri"), 30);
		System.out.println(token);
	}
	/**
	 * 验证Token
	 * @throws Exception 
	 */
	@org.junit.Test
	public void checkToken() throws Exception {
		String token="eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiYWRtaW4iLCJleHAiOjE1NjIwMzQwMDZ9.dkLboWU0-R1TSrKNjw2G8UKapE3px-XT6hwUyRBjDE_UsotpirOh7Rl3FvTCKBoSO8Yc6oYeyUsBxxIQZhE9-BkhrQm6vad13ehdNJJzsuE3NyjFD_MziSSJqQQNMxMq1q-JZ8F0phoe_GCV0lWE9-JnuKIJvpCQWOETnVq6Zzw"; 
		UserInfo userInfo = JwtUtils.getUserInfo(RsaUtils.getPublicKey("E:\\rsa\\rsa.pub"), token);
		System.out.println(userInfo);
	}
}
