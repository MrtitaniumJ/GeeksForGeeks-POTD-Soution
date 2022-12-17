//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String BalancedString(int N) {
        // code here
        StringBuilder sb = new StringBuilder();
        int value = sum(N);
        while(N > 0) {
            if(N >= 26) {
                sb.append(find(26, 0));
                N -= 26;
            } else {
                if(N % 2 == 0) {
                    sb.append(find(N / 2, 0));
                    sb.append(find(N / 2, 1));
                } else {
                    if(value%2 == 0) {
                        sb.append(find((N + 1)/2, 0));
                        sb.append(find((N - 1)/2, 1));
                    } else {
                        sb.append(find((N - 1)/2, 0));
                        sb.append(find((N + 1)/2, 1));
                    }
                }
                N=0;
            }
        }
        return sb.toString();
    }
    public static int sum(int n) {
        int sol = 0;
        while(n > 0) {
            sol += (n % 10);
            n /= 10;
        }
        return sol;
    }
    public static String find(int value, int pos) {
        StringBuilder sb = new StringBuilder();
        if(pos == 0) {
            for(char i= 'a'; value > 0; value--, i++) {
                sb.append(Character.toString(i));
            }
        } else {
            for(char i = 'z'; value > 0; value--, i--) {
                sb.append(Character.toString(i));
            }
            sb.reverse();
        }
        return sb.toString();
    }
}
