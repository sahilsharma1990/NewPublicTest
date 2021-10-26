package com.java.basic;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		//Question We have list of String and need to find out palindrome
		
		ArrayList<String> l=new ArrayList<String>();
		l.add("Nitin");
		l.add("aba");
		l.add("abc");
		//isPalindrome(l);
		boolean b=false;
		for(String s:l) {
			b=isPalindrome(s);
			if(b)
				System.out.println(" Palindrome " + s);
			else 
				System.out.println(" Not Palindrome " +s);
		}
		
		String te="ashishdash";
		char ch[];
				ch[te.charAt(i)-'a']++;

	}
	public static boolean isPalindrome(String s) {
		String s1=s.toLowerCase();
		//nitin
		int i=0;
		int cur=s.length()-1;
		while(i<cur) {
			if(s1.charAt(i)!=s1.charAt(cur))
				return false;
			i++;
			cur--;
		}
		
		
		return true;	
		
		
	}

}
