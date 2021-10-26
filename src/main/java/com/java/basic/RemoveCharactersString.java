package com.java.basic;

public class RemoveCharactersString {

	public static void main(String[] args) {
		String s="india is great";
		StringBuffer sb=new StringBuffer(s);
		System.out.println("Sb before: "+sb);
		String s1="in";
		
		
		for(int i=0;i<sb.length();i++) {
			for(int j=0;j<s1.length();j++) {
				 if(sb.charAt(i)==s1.charAt(j)) {
					sb.deleteCharAt(i);
				}
			}
		}
		System.out.println("Sb After: "+sb);

	}

}
