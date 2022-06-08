package com.chainsys.bestPractices.clone;

public class TestCloning {

	public static void main(String[] args) {
		Student firstStudent = new Student();
		firstStudent.name = "Karthikeyan";
		firstStudent.age = 22;
		System.out.println(firstStudent.hashCode());
		try {
			Student secondStudent = (Student)firstStudent.clone();
			System.out.println(secondStudent.name + " " + secondStudent.age);
			System.out.println(secondStudent.hashCode());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}