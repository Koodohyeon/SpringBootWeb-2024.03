package com.example.sb.users;

import java.time.LocalDate;

public class User {
	private String uid;
	private String pwd;
	private String uname;
	private String enail;
	private LocalDate regDate;
	private int idDeleted;
	
	public User() { }
	public User(String uid, String pwd, String uname, String enail, LocalDate regDate, int idDeleted) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.enail = enail;
		this.regDate = regDate;
		this.idDeleted = idDeleted;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", pwd=" + pwd + ", uname=" + uname + ", enail=" + enail + ", regDate=" + regDate
				+ ", idDeleted=" + idDeleted + "]";
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEnail() {
		return enail;
	}
	public void setEnail(String enail) {
		this.enail = enail;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public int getIdDeleted() {
		return idDeleted;
	}
	public void setIdDeleted(int idDeleted) {
		this.idDeleted = idDeleted;
	}
	
	
	
	
}
