//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        // code here
        int i = A.length()-1;
        int j = B.length()-1;
        int ctr = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0) {
            int a1 = A.charAt(i)-'0';
            int b1 = B.charAt(j)-'0';
            sb.append((a1 ^ b1 ^ ctr));
            i--;
            j--;
            ctr = ((a1&b1) | (b1&ctr) | (a1&ctr));
        }
        while(i >= 0) {
            int a1 = A.charAt(i)-'0';
            sb.append((a1 ^ ctr));
            ctr = a1&ctr;
            i--;
        }
        
        while(j >= 0) {
            int b1 = B.charAt(j)-'0';
            sb.append((b1^ctr));
            ctr = b1&ctr;
            j--;
        }
        
        sb.append(ctr);
        sb.reverse();
        i = 0;
        while(i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        sb.delete(0,i);
        return sb.toString();
    }
}
