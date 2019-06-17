package com.learning.basic;

public class DataBaseClass {
	private int portNo;
	private String url;
	private String userName;
	public int getPortNo() {
		return portNo;
	}
	public void setPortNo(int portNo) {
		this.portNo = portNo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "DataBaseClass [portNo=" + portNo + ", url=" + url + ", userName=" + userName + "]";
	}
	
	
}
