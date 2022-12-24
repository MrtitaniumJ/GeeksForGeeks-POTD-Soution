//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            
            Solution g = new Solution();
            long ans = g.wineSelling(arr,N);
            
            System.out.println(ans);
            T--;
        }
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution {

    long wineSelling(int Arr[], int N){

        int buy =0;
        int sell = 0;
        long sol = 0;

        while(buy < N && sell < N){
            while(Arr[buy] <= 0){
                buy++;
                if(buy == N) return sol;
            }
            while(Arr[sell] >= 0){
                sell++;
                if(sell == N) return sol;
            }
            if(Math.abs(Arr[buy]) >= Math.abs(Arr[sell])){
                sol += Math.abs(buy - sell)*(Math.abs(Arr[sell]));
                Arr[buy] += Arr[sell];
                Arr[sell] = 0;
            }else{
                sol += Math.abs(buy - sell)* Arr[buy];
                Arr[sell] += Arr[buy];
                Arr[buy] = 0;
            }
        }
        return sol;
    }
}
