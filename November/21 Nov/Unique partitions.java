
//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        // Code here
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        fun(n, sol, new ArrayList<>());
        return sol;
    }
    
    public static void fun(int n, ArrayList<ArrayList<Integer>> sol, ArrayList<Integer> list) {
        if(n <=0 ) {
            if(n == 0) sol.add((ArrayList)list.clone());
            return;
        }
        int j = n;
        if(list.size() > 0) j = list.get(list.size() - 1);
        
        for(int i = j; i >= 1; i--) {
            list.add(i);
            fun(n-i, sol, list);
            list.remove(list.size() - 1);
        }
    }
}