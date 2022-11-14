//{ Driver Code Starts
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
            String S = read.readLine();
            String W = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(S,W));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberOfSubsequences(String S, String W){
        // code here
        int subsequence = 0;
        byte[] letter = new byte[S.length()];
        for(int i = 0; i <= S.length() - W.length(); i++) {
            int temp = 0;
            for(int j = 0; j < S.length(); j++) {
                if(S.charAt(j) == W.charAt(temp) && letter[j] == 0) {
                    temp++;
                    letter[j] = 1;
                }
                if(temp >= W.length())
                    break;
            }
            if(temp >= W.length())
                subsequence++;
        }
        return subsequence;
    }
}
