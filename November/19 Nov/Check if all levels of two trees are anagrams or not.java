
/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static boolean areAnagrams(Node node1, Node node2) {
        // code here
        ArrayDeque<Node> dq1 = new ArrayDeque<>();
        ArrayDeque<Node> dq2 = new ArrayDeque<>();
        dq1.add(node1);
        dq2.add(node2);
        while(dq1.size()>0 && dq2.size()>0) {
            int s1 = dq1.size();
            int s2 = dq2.size();
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            
            if(s1!=s2) return false;
            for(int i=0;i<s1;i++) {
                Node n1 = dq1.pop();
                Node n2 = dq2.pop();
                list1.add(n1.data);
                list2.add(n2.data);
                
                if(n1.left!=null) dq1.add(n1.left);
                if(n2.left!=null) dq2.add(n2.left);
                
                if(n1.right!=null) dq1.add(n1.right);
                if(n2.right!=null) dq2.add(n2.right);
            }
            
            Collections.sort(list1);
            Collections.sort(list2);
            
            for(int i=0;i<s1;i++) {
                // if(list1.get(i)!=list2.get(i)) return false;
                int v1 = list1.get(i);
                int v2 = list2.get(i);
                if(v1!=v2) return false;
            }
        }
        
        if(dq1.size()!=0 || dq2.size()!=0) return false;
        return true;
    }
}
        