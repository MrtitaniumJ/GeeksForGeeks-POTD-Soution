//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
import java.lang.*;


class GFG {
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine()); // input size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split("\\s+");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    Solve T = new Solve();
            long ans = T.maxArea(arr,n);
            System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solve{
    
    long maxArea(int A[], int len){
        // Code Here
        long sol = 0;
        int left;
        int right;
        int width;
        for(int height = 1; height <= 100; height++) {
            left = 0;
            for(int i = 0; i < len; i++) {
                if(A[i] >= height) {
                    left = i;
                    break;
                }
            }
            
            right = 0;
            for(int i = len-1; i >= 0; i--) {
                if(A[i] >= height) {
                    right = i;
                    break;
                }
            }
            width = right - left;
            sol = Math.max(sol, height*width);
        }
        
        return sol;
    }
    
}
