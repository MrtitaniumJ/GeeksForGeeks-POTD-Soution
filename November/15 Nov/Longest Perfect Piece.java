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
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.longestPerfectPiece(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int longestPerfectPiece(int[] arr, int N) {
        // code here
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min=new PriorityQueue<>();
        int sol = 0;
        for(int i=0,j=0;i<N;i++){
            min.add(arr[i]);
            max.add(arr[i]);
            
            while(j<N && max.peek()-min.peek()>1){
                min.remove(arr[j]);
                max.remove(arr[j]);
                j++;
            }
            
            sol = Math.max(sol, i-j+1);
        }
        return sol;
    }
};