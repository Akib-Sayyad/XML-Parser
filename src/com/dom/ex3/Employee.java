package com.dom.ex3;

public class Employee {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String name;
    private String gender;
    private int age;
    private String role;
	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", age=" + age + ", role=" + role + "]";
	}
    
}
