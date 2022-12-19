//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        int[][] g = new int[n][n];
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int[] flight : flights){
            int a = flight[0]-1, b = flight[1]-1, c = flight[2];
            g[a][b] = c;
        }
        int source = k-1;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        distance[source] = 0;
        while(!queue.isEmpty()){
            int a = queue.poll();
            for(int b = 0; b < n; b++){
                if(g[a][b] != 0 && distance[b] > distance[a] + g[a][b]){
                    distance[b] = distance[a] + g[a][b];
                    queue.add(b);
                }
            }
        }
        int minCost = 0;
        for(int i = 0; i<n; i++){
            minCost = Math.max(minCost, distance[i]);
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
