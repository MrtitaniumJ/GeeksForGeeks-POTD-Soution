//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int N, int M)
    {
        // add your code here
        long modulus = 1000000007;
        long sol = 0;
        long total = N*M;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                sol += ((total-1) - rqrMoves(i, j, N, M));
                sol %= modulus;
            }
        }
        return (int)sol;
    }
    
    public static int rqrMoves(int i, int j, int n, int m) {
        int sol = 0;
        if(i-1 > 0) {
            if(j-2 > 0) sol++;
            
            if(j+2 <= m) sol++;
        }
        if(i-2>0) {
            if(j-1 > 0) sol++;
            
            if(j+1 <= m) sol++;
        }
        if(i+1 <= n) {
            if(j-2 > 0) sol++;
            
            if(j+2<=m) sol++;
        }
        if(i+2<=n) {
            if(j-1>0) sol++;
            
            if(j+1<=m) sol++;
        }
        return sol;
    }
}
