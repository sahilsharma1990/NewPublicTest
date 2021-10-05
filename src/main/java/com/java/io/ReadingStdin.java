package com.java.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingStdin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		List<String> list=new ArrayList<String>();		
		while(sc.hasNext()) {	
			String l=sc.nextLine();
			list.add(l);
			System.out.println(l);
			
		}
		int count=1;
		for(String s:list) {
			System.out.println(count+" "+s);
			count++;
		}
	}

}
