//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.maxGcd(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long solve(long n) {
        // code here
        long A = n;
        int exist = 0;
        for(long i = n-1; i >= 1; i--) {
            long gc = gcd(A, i);
            if(gc == 1) {
                A *= i;
                exist++;
            }
            if(exist == 3) return A;
        }
        return A;
    }
    
    long maxGcd(int N) {
        return Math.max(solve(N), solve(N-1));
    }
    
    long gcd(long n1, long n2) {
        if(n1 == 0) return n2;
        return gcd(n2%n1, n1);
    }
}
