// You are given the head of a linked list, and an integer k.
// Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
// Example 1:


// Input: head = [1,2,3,4,5], k = 2
// Output: [1,4,3,2,5]
// Example 2:

// Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
// Output: [7,9,6,6,8,7,3,0,9,5]
 

// Constraints:

// The number of nodes in the list is n.
// 1 <= k <= n <= 105
// 0 <= Node.val <= 100

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        ListNode firstPtr=dummy;
        ListNode secondPtr=dummy;
        //go till kth node from begining save its value in temp to swap
        for(int i=1;i<=k;i++){
           firstPtr=firstPtr.next; 
        }
        int temp1=firstPtr.val;
        //go till kth node till N to find the total number of nodes, 
        int n=0;
        while(secondPtr.next!=null){
            n++;
            secondPtr=secondPtr.next;
        }
        secondPtr=dummy;
        //then move till N-k , have its value stored in temp, and swap with first temp
        for(int i=1;i<=n-k;i++){
            secondPtr=secondPtr.next;
        }
        //and swap the first temp with this 2nd temp
        int temp2=secondPtr.next.val;
        secondPtr.next.val=temp1;
        firstPtr.val=temp2;

        return dummy.next;
    }
}
