
package com.java.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Adding {

	public static void main(String[] args)
	{	ArrayList l=new ArrayList();
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the no of Queries");
		int n=sc.nextInt();
		System.out.println("enter the digits");
		for(int i=0;i<n;i++){
			l.add(Integer.parseInt(sc.nextLine()));	
		}
	int y=addDigits(l);
	//=recursion(178);
	System.out.println(y);
		
	}
	public static int addDigits(List<Integer> l){
		
		int sum=0;
		for(int i=0;i<l.size();i++){
				sum+=l.get(i);
			}
			if(sum<9) 
				return sum;
			else {			
				while(sum>9){
					recursion(178);
				}
				return sum;
			}
		
}
	public static int recursion(int x) {
		int digitsum=0;
		digitsum+=x%10;
		x=x/10;
		return digitsum;
	}
}
