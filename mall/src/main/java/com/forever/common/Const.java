package com.forever.common;

public class Const {
	public static final String PublicKey  ="E:\\rsa\\rsa.pub";//a
	public static final String PrivateKey ="E:\\rsa\\rsa.pri";
	public static final String IMG_SRC ="C:\\apache-tomcat-9.0.13\\webapps\\MallProj\\fileUp";
	public static final String PRODUCT_IMGK_HOST = "http://127.0.0.1:8080"+"/"+"MallProj/fileUp/";
	public static final String QR_PAY = "http://127.0.0.1:8080";
	
	public static final String CURRENT_USER = "currentUser";
	public static final String CURRENT_USER_ADMIN = "currentUser_admin";
	
	public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    
    public interface AlipayCallback{
    	String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";
    	
    	Integer ORDER_SUCCESS_STATUS = 20;
    	
    	Integer PAY_PLATFORM_ALI = 1;
    }
}
