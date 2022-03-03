package com.tss.test;

import java.util.ArrayList;
import java.util.List;

import com.tss.pojo.Branch;
import com.tss.pojo.Student;
import com.tss.utility.Utility;

public class Main {

	public static void main(String[] args) {
		List<String> hobbiesOne = new ArrayList<String>();
		hobbiesOne.add(new String("kabbadi"));
		hobbiesOne.add(new String("cricket"));

		List<String> hobbiesTwo = new ArrayList<String>();
		hobbiesTwo.add(new String("reading"));
		hobbiesTwo.add(new String("singing"));

		List<String> hobbiesThree = new ArrayList<String>();
		hobbiesThree.add(new String("online games"));

		List<Branch> branches = new ArrayList<Branch>();

		List<Student> cseStudents = new ArrayList<Student>();
		cseStudents.add(new Student("Chaitanya", 26,hobbiesOne));
		cseStudents.add(new Student("Rahul", 24,hobbiesTwo));
		cseStudents.add(new Student("Ajeet", 32,hobbiesThree));

		List<Student> eceStudents = new ArrayList<Student>();
		eceStudents.add(new Student("ravi", 22,hobbiesOne));
		eceStudents.add(new Student("raj", 21,hobbiesOne));
		eceStudents.add(new Student("arvind", 25,hobbiesOne));

		branches.add(new Branch("cse", cseStudents));
		branches.add(new Branch("ece", eceStudents));

		 System.out.println(Utility.getStudentsByHobby(branches ,"online games"));
//		 branches.addAll("cse",students);
	}
}