//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            while(stack.size() > 0) {
                int index = stack.peek();
                if(asteroids[i] < 0) {
                    if(asteroids[index] > 0) {
                        if(-asteroids[i] < asteroids[index]) {
                            asteroids[i] = 0;
                            break;
                        } else if(-asteroids[i] == asteroids[index]) {
                            asteroids[i] = 0;
                            asteroids[index] = 0;
                            stack.pop();
                            break;
                        } else {
                            asteroids[index] = 0;
                            stack.pop();
                        }
                    } else break;
                } else if(asteroids[i]==0) break;
                else break;
            }
            if(asteroids[i]!=0) stack.push(i);
        }
        int[] sol = new int[stack.size()];
        int index = sol.length - 1;
        while(stack.size() > 0) {
            sol[index] = asteroids[stack.pop()];
            index--;
        }
        return sol;
    }
}
