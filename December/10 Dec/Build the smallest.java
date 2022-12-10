//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String buildLowestNumber(String str, int N) {
        // code here
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            while(s.size() > 0 && s.peek() > ch && N > 0) {
                N--;
                s.pop();
            }
            s.push(ch);
        }
        
        StringBuilder stringbuilder = new StringBuilder();
        while(s.size() > 0) {
            char ch = s.pop();
            if(N > 0) {
                N--;
                continue;
            }
            stringbuilder.append(Character.toString(ch));
        }
        
        String sol = stringbuilder.reverse().toString();
        for(int i = 0; i < sol.length(); i++) {
            if(sol.charAt(i) != '0') return sol.substring(i);
        }
        return "0";
    }
}
