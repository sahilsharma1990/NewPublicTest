package com.java.basic;

import java.util.Scanner;

public class Test67537 {

	public static void main(String[] args) {
		
		    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

		Scanner sc = new Scanner(System.in);
		    int n=sc.nextInt();
		int a[]=new int[n];

		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }

		    System.out.println(diff(a));

		}

		static int diff(int a[])

		{
		    int t,s;
		    s=t=0;

		    for(int i=0;i<a.length;i++)
		    {

		        for(int j=0;j<t;j++)
		         s=s+( max(a,i,j)-min(a,i,j));   

		        t++;
		      }

		  return s;  
		}

		static int max(int a[],int i,int j)
		{
		    int m=a[i];
		    for(int k=i;k<j;k++)
		        if(m>=a[k])
		            m=a[k];

		    return m;
		}

		 static int min(int a[],int i,int j)
		{
		    int m=a[i];
		    for(int k=i;k<j;k++)
		        if(m<=a[k])
		            m=a[k];

		    return m;
		}

	}


