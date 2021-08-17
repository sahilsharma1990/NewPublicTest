package com.java.basic;

public class TestChildConstructorCaling {

	public static void main(String[] args) {
		/* 1. new Operator is responsible for the creation of the Object and once object is created instance variables
		 * for both child and parent class is assigned to object with default values
		 * 2. ChildCons(name, age, rollno, marks) is constructor call to initialize the user defined values to the object.
		 * */
		ChildCons c=new ChildCons("Sahil", 30, 101, 96);

	}

}
