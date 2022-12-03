//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.numoffbt(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static int numoffbt(int arr[], int n)
    {
         // Your code goes here
         int ans = 0;
         int min = Integer.MAX_VALUE;
         int max = 1;
         for(int i : arr){
             min = Math.min(min, i);
             max = Math.max(max, i);
         }
         int[] dp = new int[max+1];
         
         for(int i:arr){
             dp[i] = 1;
         }
         
         for(int i = min; i<= max; i++){
             if(dp[i]!=0){
                 for(int j = 2*i; j <= max && (j/i) <= i; j += i){
                     if(dp[j]!=0){
                         dp[j] += (dp[i]*dp[j/i]);
                         if(i!=(j/i)){
                             dp[j] += (dp[i]*dp[j/i]);
                         }
                     }
                 }
                 ans = (ans+dp[i])%1000000007;
             }
         }
         return ans%1000000007;
    }
}
