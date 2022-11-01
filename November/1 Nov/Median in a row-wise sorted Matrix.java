//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        // code here   
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        
        for(int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C-1]);
        }
        int required_value = ((R*C)/2);
        if(R % 2 == 0 || C % 2 == 0)
            required_value--;
        int ans = high;
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            int count=0;
            for(int i = 0; i < R; i++) {
                count += search(matrix[i], mid);
            }
            
            if(count <= required_value)
                low = mid+1;
            else {
                high = mid-1;
                ans = Math.min(ans, mid);
            }
        }
        return ans;
        
    }
    
    public static int search(int[] j,int s) {
        int low = 0, high = j.length-1;
        int ans=-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(j[mid] <= s) {
                low = mid+1;
                ans = Math.max(ans, mid);
            } else
                high = mid-1;
        }
        return ans+1;
    }
}
