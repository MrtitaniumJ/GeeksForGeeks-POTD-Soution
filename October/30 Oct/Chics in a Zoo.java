//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long NoOfChicks(int N)
    {
        // Code here
        long[][] dynamic = new long[N+1][2];
        dynamic[1][0] = 1;
        dynamic[1][1] = 1;
        
        for(int i = 2; i <= N; i++) {
            if(i>6) {
                dynamic[i][1] = ((dynamic[i-1][0] - dynamic[i-6][1])*2);
                
                dynamic[i][0] = dynamic[i][1] + dynamic[i-1][0] - dynamic[i-6][1];
            } else {
                dynamic[i][1] = (dynamic[i-1][0]*2);
                
                dynamic[i][0] = dynamic[i][1]+dynamic[i-1][0];
            }
        }
        
        return dynamic[N][0];
    }
}
