package com.ds.recursion;

public class KthGrammer {

	public static void main(String[] args) {
		int K=5;
		int N=6;
		// N=N << 2;
		//System.out.println(N);
		System.out.println(solve(N,K));
		
		
	}
	public static int solve(int N,int K) {
		int length=(int) Math.pow(2,N-1);
		int mid=length/2;
		if(N==1 && K==1) 
		{
		 return 0;
		}
		if(K<=mid) {
			return solve(N-1,K);
		}
		else	
			return solve(N-1,K-mid);
		
	
	}

}
