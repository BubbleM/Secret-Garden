package com.bubble.classes;

public class User {
	private String id;
	private String name;
	private String pwd;
	private String pbk;
	private String security;
	private String digest;
	private String enctypt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPbk() {
		return pbk;
	}
	public void setPbk(String pbk) {
		this.pbk = pbk;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getEnctypt() {
		return enctypt;
	}
	public void setEnctypt(String enctypt) {
		this.enctypt = enctypt;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", pbk="
				+ pbk + ", security=" + security + ", digest=" + digest
				+ ", enctypt=" + enctypt + "]";
	}
	
}
