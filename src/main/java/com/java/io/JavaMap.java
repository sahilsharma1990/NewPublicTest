package com.java.io;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class JavaMap {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		HashMap<String, Integer> m = new HashMap<String, Integer>(n);
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			int phone = in.nextInt();
			m.put(name, phone);
			in.nextLine();
		}
		/*Iterator itr;
		int count = 0;

		while (in.hasNext()) {
			String s = in.nextLine();
			Set s1 = m.entrySet();
			boolean found=false;
			itr = s1.iterator();
			while (itr.hasNext()) {
				Map.Entry m1 = (Map.Entry) itr.next();
				if(m1.getKey().equals(s)) {
					System.out.println(m1.getKey()+"="+m1.getValue());
					found=true;
				}

			}
			if(found ==false)
				System.out.println("Not found");
		}
		in.close(); */
		
		while(in.hasNextLine()) {
			String q=in.nextLine();
			if(m.containsKey(q)) {
				System.out.println(q+"="+m.get(q));
			}else 
				System.out.println("Not found");
		}
	}

}
