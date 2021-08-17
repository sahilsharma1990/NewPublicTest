package com.java.basic;

public class ChildCons extends ParentCons{
	
	int rollno;
	int marks;
	
	
	ChildCons(String name, int age, int rollno, int marks){
		/*In the Child call first line is to Initialize the parent class instance variables
		
		 This will initialize the parent class variable not creating the object */
		super(name,age); 
		this.rollno=rollno;
		this.marks=marks;
		System.out.println(" Child Constructor is Invoked ");
	}

}
