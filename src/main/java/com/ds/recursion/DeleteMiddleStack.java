package com.ds.recursion;

import java.util.Stack;

public class DeleteMiddleStack {

	public static void main(String[] args) {
		Stack<Integer> s=new Stack<Integer>();
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		System.out.println("Before Removing middle element of stack"+s);
		int k=(s.size()/2)+1;
		middleDelete(s,k);
		System.out.println(s);

	}
	public static void middleDelete(Stack<Integer>s,int k) {
		
		// Step 1: Base Condition
			if(k==1) {
				s.pop();
				return;
			}
		
		// Step 2: Hypothesis
			int temp=s.pop();
			middleDelete(s, k-1);	
		// Step 3:Induction
			s.push(temp);
		
	}
}
