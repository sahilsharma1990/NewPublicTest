package com.ds.recursion;

import java.util.Scanner;

public class PrintingNumbers {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("Using Recursion Pritning 1 to "+n);
		print1toN(n);
		System.out.println(" ");
		System.out.println("Using Recursion Printing "+n+" to 1");
		printNto1(n);
	}
	public static void print1toN(int n) {
		if(n==1) {
			System.out.print(n+" ");
			return;
		}
		print1toN(n-1);
		System.out.print(n +" ");
	}
	public static void printNto1(int n) {
		if(n==1) {
			System.out.print(n+" ");
			return;
		}

		System.out.print(n +" ");
		printNto1(n-1);
	}

}
