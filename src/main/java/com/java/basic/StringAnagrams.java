package com.java.basic;

import java.util.Arrays;
import java.util.Scanner;

public class StringAnagrams {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	}

	static boolean isAnagram(String a, String b) {
		String s1=a.toLowerCase();
		String s2=b.toLowerCase();
		int []freq1= new int[26];
		int []freq2= new int[26];		
		for(int i=0;i<s1.length();i++) {
			freq1[s1.charAt(i)-'a']++;
			
		}		
		for(int i=0;i<s2.length();i++) {
			freq2[s2.charAt(i)-'a']++;
		}
		boolean bol=true;
		
		for(int i=0;i<26;i++) {
			if(freq1[i]==freq2[i])
				continue;			
			else
				bol= false;
			
		}
		/*if(Arrays.equals(freq1, freq2))
			return true;
		else 
			return false; */
		return bol;
    }
}
