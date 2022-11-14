//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0;
	    for(int a : arr) sum += a;
	    
	    int[][] dp = new int[n][sum + 1];
	    for(int i = 0; i < dp.length; i++) {
	        for(int j = 0; j < dp[i].length; j++)
	            dp[i][j]=-2;
	    }
	    
	    return f(arr, 0, sum, 0, dp);
	}
	
	public static int f(int[] arr, int idx, int sum,int sumn,int[][] dp) {
	    if(idx>=arr.length) {
	        return Math.abs((sum-sumn)-sumn);
	    }
	    
	    if(dp[idx][sumn]!=-2) return dp[idx][sumn];
	    
	    int f1 = f(arr,idx+1, sum, sumn + arr[idx],dp);
	    int f2 = f(arr,idx+1, sum, sumn, dp);
	    
	    return dp[idx][sumn] = Math.min(f1,f2);
	} 
}
