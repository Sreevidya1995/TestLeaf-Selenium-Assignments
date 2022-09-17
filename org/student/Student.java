package org.student;

import org.department.Department;

public class Student extends Department{
	
	public void studentName() {
		System.out.println("Student Name : Sreevidya ");
		System.out.println();
	}
	
	public void studentDept() {
		System.out.println("Student Department : Electronics and Communication Engineering (ECE) ");
		System.out.println();
	}
	
	public void studentId() {
		System.out.println("Student Id : 412513106755 ");
		System.out.println();
	}
	
	//Assignment 4 ----------METHOD OVERLOADING---------------------------------------------------------------------
	
	public void  getStudentInfo(int id) {
		System.out.println("Based on the Student Id the Student details are retrieved");
		System.out.println();
	}
	
	public void  getStudentInfo(int id ,String name) {
		System.out.println("Based on the Student Id and Name the Student details are retrieved");
		System.out.println();
	}
		
	public void  getStudentInfo(String emailId , long phoneNumber) {
		System.out.println("Based on the Student email id and phone number the Student details are retrieved");
		System.out.println();
	}
	
	//---------------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {

		Student candidate = new Student();
		
		//Inherited from College
		candidate.collegeName();
		candidate.collegeCode();
		candidate.collegeRank();
		
		//Inherited from Department
		candidate.deptName();
		
		//From Student Class
		
		candidate.studentName();
		candidate.studentDept();
		candidate.studentId();
		
		//FOR METHOD OVERLOADING
		
		candidate.getStudentInfo(4125);
		candidate.getStudentInfo(4125, "Kaviya");
		candidate.getStudentInfo("sree.xyz@gmail.com", 9791387672L);
		
	}

}
