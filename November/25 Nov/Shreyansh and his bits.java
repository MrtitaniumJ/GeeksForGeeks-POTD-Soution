//{ Driver Code Starts
//Initial Template for Java

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
            String input_line[] = read.readLine().trim().split("\\s+");
            long  N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
    long count(long n)
    {
        // Code Here
        ArrayList<Integer> arrlist = new ArrayList<>();
        int ctr = 0;
        while(n > 0) {
            if(n%2 == 0) arrlist.add(0);
            else {
                ctr++;
                arrlist.add(1);
            }
            n /= 2;
        }
        
        int[] size = new int[arrlist.size()];
        for(int i=0, j = size.length-1; i < arrlist.size(); i++, j--)
            size[i] = arrlist.get(j);
        
        return f(size, 0, ctr, 0, new Long[size.length][ctr+1][2])-1;
    }
    
    public static long f(int[] num, int idx, int ctr, int turn, Long[][][] dp) {
        if(idx >= num.length) {
            if(ctr != 0) return 0;
            return 1;
        }
        if(ctr == 0) return 1;
        
        if(dp[idx][ctr][turn] != null) return dp[idx][ctr][turn];
        long sol;
        if(num[idx] == 1) 
            sol = f(num, idx + 1, ctr-1, turn, dp) + f(num, idx+1, ctr, 1, dp);
        else {
            if(turn == 0)
                sol = f(num, idx+1, ctr, turn, dp);
            else
                sol = f(num, idx+1, ctr-1, 1, dp) + f(num, idx+1, ctr, 1, dp);
        }
        
        return dp[idx][ctr][turn] = sol;
    }
}
