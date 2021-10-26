package com.ds.recursion;

import java.util.ArrayList;

public class SortingAnArray {

	public static void main(String[] args) {
		ArrayList<Integer> al= new ArrayList<Integer>();
		al.add(2);
		al.add(5);
		al.add(4);
		al.add(6);
		al.add(9);
		al.add(7);
		System.out.println(" Before Sorting " +al);
		sort(al);
		System.out.println(" After  Sorting " +al);
	}
	public static void sort(ArrayList<Integer> al) {		
		if(al.size()==1)
			return ;
		int temp=al.remove(al.size()-1);
		sort(al);
		insert(al,temp);	
		
	}
	public static void insert(ArrayList<Integer> al, int temp) {
		if(al.size()==0||al.get(al.size()-1)<=temp) {
			al.add(temp);
			return;
		}
		int val=al.remove(al.size()-1);
		insert(al,temp);
		al.add(val);
	}
}
