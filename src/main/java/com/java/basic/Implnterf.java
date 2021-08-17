package com.java.basic;

public class Implnterf implements Interf{
	public void m1() {
	
		System.out.println(" m1 method " +x);
	}

	public static void main(String[] args) {
		//System.out.println(x);
		Implnterf i = new Implnterf();
		i.m1();
	}
	
}
