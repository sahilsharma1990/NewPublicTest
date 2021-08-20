package com.java.basic;


import java.util.Scanner;

public class StringSplit {

	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
	       // String s = scan.nextLine();
	        // Write your code here.
	       // scan.close();
		
		String s="He is a very very! good boy, isn't he?";
	        int count=0;
	        String s1[]=s.split("[^a-zA-Z0-9]");		//s.split("[, ?._@']+");	 
	        for(int i=0;i<s1.length;i++) {
	        	if(!s1[i].isEmpty())
	        		count++;
	        }
	        System.out.println(count);
	        for(int i=0;i<s1.length;i++) {
	        	if(!s1[i].isEmpty())
	        		System.out.println(s1[i]);
	        }

	}

}


