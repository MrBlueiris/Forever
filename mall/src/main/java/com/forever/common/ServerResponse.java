package com.forever.common;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable{
	private int status;
    private String msg;
    private T data;
    
    
    
	public ServerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ServerResponse(int status) {
		super();
		this.status = status;
	}


	public ServerResponse(int status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}


	public ServerResponse(int status, T data) {
		super();
		this.status = status;
		this.data = data;
	}


	public ServerResponse(int status, String msg, T data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    
    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    
    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }
    
    public static <T> ServerResponse<T> createByLoginErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERRORLogin.getCode(),errorMessage);
    }
    
    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}
    
    
    
}
