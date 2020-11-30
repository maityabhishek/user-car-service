package com.usercar.model;

public class UserCarRes {
	
	private int rescode;
	private boolean status;
	private String msg;
	public UserCarRes(int rescode, boolean status, String msg) {
		super();
		this.rescode = rescode;
		this.status = status;
		this.msg = msg;
	}
	public UserCarRes() {
		super();
		
	}
	public int getRescode() {
		return rescode;
	}
	public void setRescode(int rescode) {
		this.rescode = rescode;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
