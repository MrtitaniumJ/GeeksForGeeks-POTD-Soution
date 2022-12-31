//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int start[] = new int[N];
            int end[] = new int[N];

            String inputLine2[] = br.readLine().trim().split(" ");
            String inputLine3[] = br.readLine().trim().split(" ");
            
            for (i = 0; i < N; i++) {
                start[i] = Integer.parseInt(inputLine2[i]);
                end[i] = Integer.parseInt(inputLine3[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.minLaptops(N, start, end));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minLaptops(int N, int[] start, int[] end) {
        // code here
        int[] list = new int[2*N];
        int index = 0;
        for(int val : start) list[index++] = val;
        for(int val : end) list[index++] = val;
        Arrays.sort(list);
        Arrays.sort(start);
        Arrays.sort(end);
        
        int sol = 0;
        for(int i = 0; i < list.length - 1; i++) {
            int user = startedBefore(start, list[i + 1]) - endedBeforeOrEqualTo(end, list[i]);
            sol = Math.max(sol, user);
        }
        
        return sol;
    }
    
    public static int startedBefore(int[] a, int val) {
        int low = 0, high = a.length-1;
        int sol = 0;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(a[mid] < val) {
                low = mid+1;
                sol = Math.max(sol, low);
            } else {
                high = mid-1;
            }
        }
        return sol + 1;
    }
    
    public static int endedBeforeOrEqualTo(int[] a, int val) {
        int low = 0, high = a.length-1;
        int sol = 0;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(a[mid] <= val) {
                low = mid+1;
                sol = Math.max(sol, low);
            } else {
                high = mid-1;
            }
        }
        return sol + 1;
    }
}
