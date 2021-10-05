package com.java.basic;

public class StringTest1 {

	public static void main(String[] args) {
		String s1="abc"; 
		String s2="abc";
		String s3=new String ("abc"); 
		String s4=s3;
		String s5=new String (s3);
		System.out.println(s1==s2) ;
		System.out.println(s1==s3) ;
		System.out.println(s4==s3) ;
		System.out.println(s4==s5) ;
		s3=new String("durga");
		
	}

}
