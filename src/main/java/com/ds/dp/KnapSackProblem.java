package com.ds.dp;

public class KnapSackProblem {
	static int count;
	public static void main(String[] args) {

		int []wt= {'1','3','4','5'};
		int []val= {'1','4','5','7'};
		int W=7;
		int n=wt.length;
		System.out.println(n);
		
		int check=0;
		System.out.println(knapsack(wt, val, W, n));
		//System.out.println(count);
		//System.out.println(" Value of check" +check );

	}
	public static int knapsack(int wt[],int val[],int W,int n) {
		count++;
		//1. Create Matrix for Size n+1 and W+1 for containing n,W values
		int [][]t=new int[n+1][W+1];
		//2.  Set initial values in the Matrix to -1
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<W+1;j++) {				
					t[i][j]=-1;
			}
		}
		/*for(int i=0;i<n+1;i++) {
			for(int j=0;j<W+1;j++) {
				System.out.print(t[i][j]+"	");
			}
			System.out.println(" ");
		} */
		//3. Base condition
		if(n==0||W==0)
			return 0;
		//4. Check in the Matrix first 
		if(t[n][W]!=-1)
			return t[n][W];
		// 5. From the Choice Diagram while
		if(wt[n-1]<=W) {
			t[n][W]=Math.max(val[n-1]+knapsack(wt, val, W-wt[n-1], n-1),knapsack(wt, val, W, n-1));
			System.out.println(t[n][W]);
			return t[n][W];
		}
		else
			return t[n][W]=knapsack(wt, val, W, n-1);
	 
	//	return 0;
	}

}
