package com.lzh.common.model.entity.auth;

import java.util.Date;
import java.util.List;

public class UserDto {
	
    private int id;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private String pwdSalt;
    private Date lastPasswordResetDate;
    private List<String> roles;
    private String token;
    
    private String secret;
    private Long expiration = 7200l;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}
	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getExpiration() {
		return expiration;
	}
	public void setExpiration(Long expiration) {
		this.expiration = expiration;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPwdSalt() {
		return pwdSalt;
	}
	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt;
	}
    
}
