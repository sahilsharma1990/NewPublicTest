package com.java.basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedPren {

	public static boolean ifBalanced(String arg){
		Deque<Character> stack =new ArrayDeque<Character>();
		for (int i=0;i<arg.length();i++)
		{
			char a=arg.charAt(i);
			if(a=='(' || a=='[' || a=='{')
				{
					stack.push(a);
					continue;
				}
			if(stack.isEmpty()){
				return false;
			}
			char checking;
			switch(a){
				case ')' :
						checking=stack.pop();
					if(checking== '{' ||checking == '['  )
						return false;
						break;
				case '}':
					checking=stack.pop();
					if(checking == '[' || checking== '(' )
						return false;
						break;
				case ']':
					checking=stack.pop();
					if(checking== '{' ||checking== '(' )
						return false;
						break;
						
					}
			}		
					return(stack.isEmpty());
		}
		
	public static void main(String[] args){
		String arg="(()([{}]))";
		if(ifBalanced(arg))
			System.out.println("Yes its balanced");
		else 
			System.out.println("Not Balanced");
	}

}
