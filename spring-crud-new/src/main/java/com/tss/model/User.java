package com.tss.model;

public class User {
	private String name;
	private String phone;

	public User(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phone=" + phone + "]";
	}
}
