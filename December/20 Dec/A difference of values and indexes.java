//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int n = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[n];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<n;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Solution obj = new Solution();
		    int ans = obj.maxDistance(arr, n);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Solution{
    
   
    // Function for finding maximum and value pair
    public static int maxDistance (int arr[], int n) {
        //Complete the function
        int sol = Integer.MIN_VALUE;
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]-i);
            mini = Math.min(mini, arr[i]+i);
            
            int a = (arr[i] + i) - mini;
            int b = maxi - (arr[i] - i);
            
            sol = Math.max(sol, Math.max(a, b));
        }
        
        return sol;
    }
    
    
}


