package com.ds.recursion;

import java.util.Stack;

public class SortingStack {
	static int count;

	public static void main(String[] args) {

		Stack<Integer> s=new Stack<Integer>();
		s.push(5);
		s.push(0);
		s.push(2);
		s.push(1);
		System.out.println("Stack Before sorting "+s);
		sort(s);
		System.out.println("Stack After sorting "+s);
		System.out.println(" No of Execution of code "+count);
	}

	public static void sort(Stack<Integer> s) {
		count++;
	// Step 1: Base condition
		if(s.size()==1)
			return;
	// Step 2: Hypothesis of sorting
		int temp=s.pop();
		sort(s);
	// Step 3: Induction step
		insert(s,temp);

	}

	public static void insert(Stack<Integer> s, int temp) {
		count++;
		// Step 1: Base Condition to Insert element if stack is empty or element is greater than top of stack.
		if(s.size()==0||s.peek()<=temp) {
			s.push(temp);
			return;
		}
		// Step 2: Hypothesis that value is inserted into sorted set
		int val=s.pop();
		insert(s,temp);
		// Step 3: Insert the pop element at the top
		s.push(val);
	}

}
