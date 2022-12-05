//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String rearrange(String str, int N){
        int arr[]= new int[123];
        for(char i: str.toCharArray()){
            arr[i]++;
        }
        StringBuffer sb= new StringBuffer();
        StringBuffer s = new StringBuffer();
        StringBuffer ans = new StringBuffer();
        
        for(int i=97;i<123;i++){
            if(arr[i]!=0 ){
                if(i== 'a' || i== 'e' || i== 'i' || i== 'o' || i== 'u' ){
                    for(int j=0;j<arr[i];j++){
                        char ch = (char)i;
                        sb.append(ch);
                    }
                }else{
                    for(int j=0;j<arr[i];j++){
                        char ch = (char)i;
                        s.append(ch);
                    }
                }
            }
        }
        int n = sb.length();
        int m = s.length();
        // System.out.print(n+" "+m +" "+ sb.toString()+" "+s.toString());
        if(Math.abs(n - m) >1){
            return "-1";
        }
        else{
            if(n == m){
                if((int)sb.charAt(0) > (int)s.charAt(0) ){
                    return second(sb,s, n,m);
                }else{
                    return first(sb,s, n,m);
                }
            }
            else if(n>m){
               return  first(sb,s, n,m);
             }
            
        }
        return second(sb,s, n,m);
    }
    
    public static String first(StringBuffer sb, StringBuffer s,int n, int m){
        StringBuffer ans = new StringBuffer();
        for(int i=0;i<n;i++){
            if(i<n){
                ans.append(sb.charAt(i));
            }
            if(i<m){
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
    public static String second(StringBuffer sb, StringBuffer s, int n, int m ){
        StringBuffer ans = new StringBuffer();
        for(int i=0;i<m;i++){
                if(i<m){
                    ans.append(s.charAt(i));
                }
                if(i<n){
                    ans.append(sb.charAt(i));
                }
            }
            return ans.toString();
    }
}
