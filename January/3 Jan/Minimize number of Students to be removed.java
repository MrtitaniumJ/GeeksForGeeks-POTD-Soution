//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] H, int N) {
        // code here
        int L = lengthOfL(H);
        return N - L;
    }
    
    public static int lengthOfL(int[] H) {
        int[] arr = new int[H.length + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = Integer.MIN_VALUE;
        for(int h : H) {
            int index = searchL(arr, h);
            arr[index + 1] = h;
        }
        for(int i = arr.length - 1; i >= 0; i--) 
            if(arr[i] != Integer.MAX_VALUE)
                return i;
        return 0;
    }
    
    public static int searchL(int[] arr, int n) {
        int low = 0, high = arr.length - 1, sol = 0;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] < n) {
                low = mid+1;
                sol = Math.max(sol, mid);
            } else {
                high = mid-1;
            }
        }
        return sol;
    }
};
