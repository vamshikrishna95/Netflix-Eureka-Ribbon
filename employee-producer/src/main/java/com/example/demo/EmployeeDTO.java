package com.example.demo;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String age;
	private String mobile;

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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", age=" + age + ", mobile=" + mobile + "]";
	}

	public EmployeeDTO(String id, String name, String age, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}
	
	
}
