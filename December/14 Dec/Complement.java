//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
        // code here
        Vector<Integer> sol = new Vector<>();
        int sum = 0;
        int maxSum = 0;
        for(int i = 0; i < n; i++) {
            int vector = str.charAt(i) - '0';
            if(vector == 0) vector = 1;
            else vector = -1;
            if(sum + vector < vector) sum = vector;
            else sum += vector;
            
            maxSum = Math.max(maxSum, sum);
        }
        sum = 0;
        if(maxSum == 0) sol.add(-1);
        else {
            int start = 0;
            for(int i = 0; i < n; i++) {
                int vector = str.charAt(i) - '0';
                if(vector == 0) vector = 1;
                else vector = -1;
                
                if(sum + vector < vector) {
                    sum = vector;
                    start = i;
                } else sum += vector;
                
                if(sum == maxSum) {
                    sol.add(start + 1);
                    sol.add(i + 1);
                    break;
                }
            }
        }
        return sol;
    }
}
