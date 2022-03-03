package com.tss.pojo;

import java.util.List;

public class Branch {
	String name;
	List<Student> students;

	public String getBranchName() {
		return name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setBranchName(String branchName) {
		this.name = branchName;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Branch [branchName=" + name + ", students=" + students + "]";
	}

	public Branch(String branchName, List<Student> students) {
		super();
		this.name = branchName;
		this.students = students;
	}
}