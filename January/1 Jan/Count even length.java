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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.compute_value(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    	int modInverse(int A, int M)
    {
        int m0 = M;
        int y = 0, x = 1;
     
        if (M == 1)
            return 0;
     
        while (A > 1) {
            int q = A / M;
            int t = M;
            M = A % M;
            A = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0)
            x += m0;
     
        return x;
    }
	int compute_value(int n)
	{
	    // Code here
	    int mod = 1000000007;
	    long sol = 2;
	    long prev = 1;
	    for(int i = 1; i <n ; i++){
	        long temp = ((((n+1-i)*prev)%mod)*modInverse(i, mod))%mod;
	        prev = temp;
	        long t = (temp*temp)%mod;
	        sol = (sol + t)%mod;
	    }
	    return (int)sol%mod;
	}
}
