//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        ArrayList<Integer> primenum = primeNumber(1000000);
        ArrayList<Integer> sol = new ArrayList<>();
        for(long query1 : query) {
            sol.add(solve(primenum, query1));
        }
        return sol;
    }
    
    public static ArrayList<Integer> primeNumber(int n) {
        int[] primenum = new int[n+1];
        Arrays.fill(primenum, 1);
        primenum[0] = 0;
        primenum[1] = 0;
        
        for(int i = 2; i <= n; i++) {
            if(primenum[i] == 1) {
                for(int j = i + i; j <= n; j += i) {
                    primenum[j] = 0;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            if(prime[i] == 1)
                list.add(i);
        }
        return list;
    }
    
    public static int solve(ArrayList<Integer> primenum, long query) {
        int b1 = (int)Math.sqrt(query);
        int low = 0;
        int high = primenum.size()-1;
        int sol = 0;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(primenum.get(mid) <= b1) {
                low = mid+1;
                sol = Math.max(sol, mid+1);
            } else {
                high = mid-1;
            }
        }
        return sol;
    }
}
