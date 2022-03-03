package com.tss.pojo;

import java.util.List;

public class Student implements Comparable<Student> {
	String name;
	public int age;
	List<String> hobbies;

	public Student(List<String> hobbies) {
		super();
		this.hobbies = hobbies;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public Student() {
		super();
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", hobbies=" + hobbies + "]";
	}

	public Student(String name, int age, List<String> hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
	}

	@Override
	public int compareTo(Student student) {
		return this.age - student.getAge();
	}
}