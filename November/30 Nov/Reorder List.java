//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

  public class ReorderList {
    Node head; // head of lisl
    Node last; // last of linked list

    /* Linked list Node*/

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            last = head;
        } else {
            // Node temp = head;
            // while (temp.next != null) temp = temp.next;

            last.next = node;
            last = last.next;
        }
    }
    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            llist.head = new Solution().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}
// } Driver Code Ends


/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    Node reorderlist(Node head) {
        // Your code here
        int ctr = 0;
        Node temp = head;
        while(temp != null) {
            ctr++;
            temp = temp.next;
        }
        
        if(ctr == 1 || ctr == 2) return head;
        
        int left_ctr = ctr/2;
        if(ctr%2 == 1) left_ctr++;
        temp = head;
        while(left_ctr>0) {
            left_ctr--;
            temp = temp.next;
        }
        
        Node right = null;
        while(temp != null) {
            Node node = new Node(temp.data);
            node.next = right;
            right = node;
            
            temp = temp.next;
        }
        
        Node ans = null;
        Node tail = null;
        while(right != null) {
            Node node = new Node(head.data);
            if(ans == null) {
                ans = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            head = head.next;
            
            node = new Node(right.data);
            tail.next = node;
            tail = node;
            right = right.next;
            
        }
        
        if(ctr%2 == 1) {
            Node node = new Node(head.data);
            tail.next = node;
        }
        return ans;
    }
}
