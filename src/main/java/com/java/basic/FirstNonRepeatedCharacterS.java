package com.java.basic;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatedCharacterS {

	public static void main(String[] args) {
		String s="swiss";	
		Map<Character,Integer> hm=new LinkedHashMap<Character, Integer>();
		
		for(int i=0;i<s.length();i++) {
			hm.put(s.charAt(i), hm.containsKey(s.charAt(i)) ? hm.get(s.charAt(i))+1:1 );
		}
		//System.out.println(hm);
		
		for (Entry<Character,Integer> e:hm.entrySet()) {
			if(e.getValue()==1) {
				System.out.println(e.getKey());
				break;
			}
		}
		
		
		//for(int i=0;i<s.length();i++) {
		/*for(char c:s.toCharArray()) {
			
			//hm.put(s.charAt(i), hm.containsKey(s.charAt(i)) ? hm.get(i) + 1: 1);
			hm.put(c, hm.containsKey(c) ? hm.get(c) + 1: 1);		
		}
		
		
			System.out.println(hm);
		*/
	}

}
