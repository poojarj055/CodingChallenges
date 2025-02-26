Given the head of a linked list, remove the nth node from the end of the list and return its head.
Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        ListNode firstPtr=dummy;
        ListNode secondPtr=dummy;

        for(int i=0;i<n;i++){
            secondPtr=secondPtr.next;
        }

        while(secondPtr.next!=null){
            firstPtr=firstPtr.next;
            secondPtr=secondPtr.next;
        }

        firstPtr.next=firstPtr.next.next;

        return dummy.next;
    }
}


-------------------------------------------------------------------------


Step-by-Step Breakdown
1️⃣ Create a Dummy Node

ListNode dummy = new ListNode(-1);
dummy.next = head;
A dummy node is used to handle edge cases (e.g., when removing the first node).
dummy.next points to the head, ensuring we always have a reference to the start of the list.

2️⃣ Initialize Two Pointers

ListNode firstPtr = dummy;
ListNode secondPtr = dummy;
firstPtr and secondPtr both start at dummy.
These pointers will help locate the Nth node from the end.

3️⃣ Move secondPtr Ahead by n Steps
j
for (int i = 0; i < n; i++) {
    secondPtr = secondPtr.next;
}
secondPtr moves n steps ahead of firstPtr.
After this loop, secondPtr is exactly n nodes ahead of firstPtr.

4️⃣ Move Both Pointers Until secondPtr Reaches the Last Node

while (secondPtr.next != null) {
    firstPtr = firstPtr.next;
    secondPtr = secondPtr.next;
}
Both firstPtr and secondPtr move one step at a time.
When secondPtr.next == null, firstPtr is at the (N+1)th node from the end.

5️⃣ Remove the Nth Node

firstPtr.next = firstPtr.next.next;
firstPtr.next points to the Nth node from the end.
By setting firstPtr.next = firstPtr.next.next, we bypass the Nth node, effectively deleting it.

6️⃣ Return the Updated List

return dummy.next;
Since dummy.next still points to the head (or its updated version), we return it as the new list.
 
