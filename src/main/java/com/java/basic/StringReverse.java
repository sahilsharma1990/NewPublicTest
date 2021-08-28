package com.java.basic;

public class StringReverse {
	public static void main(String [] args) {
		
		String s="Sahil";
		char ch []=s.toCharArray();
		char[] rev =new char [5];
		int cur=0;
		for(int i=s.length()-1;i>=0;i--) {
				rev[cur]=ch[i];
				cur++;
		}
		
		String s1=String.copyValueOf(rev);
		System.out.println(s1);
		
}
}