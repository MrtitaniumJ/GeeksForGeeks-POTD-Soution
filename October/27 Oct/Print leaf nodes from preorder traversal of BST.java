//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] leafNodes(int arr[], int N)
    {
        // code here
        return f(arr,0,N-1);
    }
    
    public static int[] f(int[] a,int low,int high) {
        if(low>high) return new int[0];
        if(high==low) return new int[]{a[low]};
        int idx = low;
        for(int i=low+1;i<=high;i++) {
            if(a[i]<a[low]) {
                idx=i;
            } else {
                break;
            }
        }
        int[] left = f(a,low+1,idx);
        int[] right = f(a,idx+1,high);
        int[] ans = new int[left.length+right.length];
        idx=0;
        for(int val : left) {
            ans[idx]=val;
            idx++;
        }
        
        for(int val : right) {
            ans[idx]=val;
            idx++;
        }
        return ans;
    }
}
