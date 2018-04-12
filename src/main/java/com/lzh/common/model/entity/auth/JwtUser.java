package com.lzh.common.model.entity.auth;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser  {
    private final int id;
    private final String username;
    private final String password;
    private final String email;
//    private final Collection authorities;
    private final Date lastPasswordResetDate;

    public JwtUser(
    		int id,
            String username,
            String password,
            String email,
//            Collection<? extends GrantedAuthority> authorities,
            Date lastPasswordResetDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
//        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }


    @JsonIgnore
    public int getId() {
        return id;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

	// 账户是否未过期
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

	// 账户是否未锁定
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

	// 密码是否未过期
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 账户是否激活
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

	// 这个是自定义的，返回上次密码重置日期
    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
