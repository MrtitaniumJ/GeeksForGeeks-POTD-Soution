//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                //br.readLine();
                String s;
                s = br.readLine();
                
                Solution obj = new Solution();
                int res = obj.beautySum(s);
                
                System.out.println(res);
                
            }
        }
    }
    
    // } Driver Code Ends
    
    
    class Solution {
        public static int beautySum(String s) {
            // code here
            int sol = 0;
            for(int i = 0; i < s.length(); i++) {
                int[] free = new int[26];
                for(int j = i; j < s.length(); j++) {
                    free[s.charAt(j)-'a']++;
                    sol += findBeauty(free);
                }
            }
            return sol;
        }
        
        public static int findBeauty(int[] free) {
            int max = Integer.MIN_VALUE, min=Integer.MAX_VALUE;
            for(int f : free) {
                if(f == 0)
                    continue;
                max = Math.max(max, f);
                min = Math.min(min, f);
            }
            return max-min;
        }
    }
            
    