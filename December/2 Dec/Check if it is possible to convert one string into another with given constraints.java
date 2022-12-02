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
            String S[] = read.readLine().split(" ");
            Solution ob = new Solution();
            System.out.println(
                ob.isItPossible(S[0], S[1], S[0].length(), S[1].length()));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int isItPossible(String S, String T, int M, int N) {
        // code here
         if(M!=N) return 0 ;

        int p = 0 , q = 0 ;

        while(p<M)

        {

             while(p<M && S.charAt(p)=='#') p++;

             while(q<N && T.charAt(q)=='#') q++;

             if(q>=N && p<M) return 0;

             if(p>=M && q<N) return 0;

              if(p<M && q<N && (S.charAt(p)==T.charAt(q)))

              {

                  if(S.charAt(p)=='A' && q>p) return 0 ;
                  if(S.charAt(p)=='B' && q<p) return 0 ;
              }

              if(p<M && q<N && (S.charAt(p) !=T.charAt(q))) return 0 ;

              p++ ; q++;

        }
        return 1;
    }
};
