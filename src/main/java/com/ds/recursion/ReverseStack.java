package com.ds.recursion;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> s=new Stack<Integer>();
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		System.out.println("Stack Before Reversal "+s);
		
		System.out.println("Stack After Reversal "+reverseStack(s));
		

	}
	public static Stack<Integer> reverseStack(Stack<Integer> s) {
		//Step 1: Base Condition
		if(s.size()<= 1) {
			return s;
		}
		//Step 2: Hypothesis
		int temp=s.pop();
		reverseStack(s);
		
		//Step 3: Induction : Inserting top element at sorted location is induction step
		insert(s,temp);
		
		return s;
	}
	public static void insert(Stack<Integer> s,int temp) {
		//Insert using recursion 
		//Base Condition
		if(s.size()==0) {
			s.push(temp);
			return;
		}
		// Step 2 : Hypothesis of Insert Step to insert in smaller sorted stack
		int val=s.pop();
		insert(s,temp);
		// Step 3: Insert - Induction put the 
		s.push(val);
	}

}
