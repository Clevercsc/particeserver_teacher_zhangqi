package com.cloudage.membercenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.cloudage.membercenter.util.BaseEntity;

@Entity
public class User extends BaseEntity {
	String account;
	String passwordHash;
	String name;
	String avatar;
	String email;

	@Column(unique = true)
	public String getAccount() {
		return account;
	}

	@Column(nullable = true)
	public String getPasswordHash() {
		return passwordHash;
	}

	@Column(unique = true)
	public String getName() {
		return name;
	}

	@Column(nullable = true)
	public String getEmail() {
		return email;
	}

	@Column(nullable = false)
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = true)
	public String getAvatar() {
		return avatar;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
