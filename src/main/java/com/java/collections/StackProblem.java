package com.java.collections;

import java.util.Scanner;
import java.util.Stack;

public class StackProblem {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		  
		 while (sc.hasNext()) { 
			 String input=sc.next(); //Complete the code }
			 if(isBalanced(input))
				 System.out.println("true");
			 else 
				 System.out.println("false");
		 }
		 
		/*String arg = "({[})]";
		if(isBalanced(arg))
			System.out.println("is Balanced");
		else 
			System.out.println("Not Balanced"); */
	}

	public static boolean isBalanced(String s) {

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			if (a == '(' || a == '{' || a == '[') {
				stack.push(a);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char checking;
			switch (a) {

			case ')':
				checking = stack.pop();
				if (checking == '}' || checking == ']')
					return false;
				break;

			case '}':
				checking = stack.pop();
				if (checking == ')' || checking == ']')
					return false;
				break;

			case ']':
				checking = stack.pop();
				if (checking == '}' || checking == ')')
					return false;
				break;

			}
			
		}
		return(stack.isEmpty());

	}

}
