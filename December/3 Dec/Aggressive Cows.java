//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low = 0, high = stalls[stalls.length-1];
        int sol = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isValid(stalls, k, mid)) {
                sol = Math.max(sol, mid);
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return sol;
    }
    
    public static boolean isValid(int[] a,int k, int dist) {
        int idx = 0;
        for(int i = 1; i < a.length; i++) {
            if(a[i] - a[idx] >= dist) {
                k--;
                idx = i;
            }
        }
        return k <= 1;
    }
}
