package com.ds.recursion;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		System.out.println("Factorial of Number "+n);
		System.out.println(factorial(n));
		
	}
	public static int factorial(int n) {
		if(n<=1)
		return n;
		
		return n*factorial(n-1);
		//return 0;
	}

}
