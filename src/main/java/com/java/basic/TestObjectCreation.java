package com.java.basic;

/* Question: When we create the Object of child class does Parent class object gets created ??
 * 
 * When ever we create the child class object Parent Constructor get invoked automatically to initialize the Parent Class member variable
 * Parent Object won't be created 
 * 
 */
 class Parent{
	
	Parent(){
		System.out.println(this.hashCode());
		System.out.println(this.getClass().toString());
	}
	
}

 class Child extends Parent{
	
	Child(){
		System.out.println(this.hashCode());
	}
}


public class TestObjectCreation {

	public static void main(String []args) {
		
		Child c= new Child();
		System.out.println(c.hashCode());
	}

}
