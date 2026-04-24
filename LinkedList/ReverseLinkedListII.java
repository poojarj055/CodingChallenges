// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

// Example 1:


// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]
// Example 2:

// Input: head = [5], left = 1, right = 1
// Output: [5]
 

// Constraints:

// The number of nodes in the list is n.
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
 

// Follow up: Could you do it in one pass?







class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1. Create a dummy node to handle cases where the head itself is reversed
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 2. Advance 'leftNode' to the node immediately BEFORE the reversal starts
        // Advance 'currNode' to the actual start of the reversal (at position 'left')
        ListNode leftNode = dummy;
        ListNode currNode = head;
        for (int i = 0; i < left - 1; i++) {
            currNode = currNode.next;
            leftNode = leftNode.next;
        }

        // 3. Mark the current node; it will become the tail of the reversed sub-section
        ListNode subListHead = currNode;
        ListNode preNode = null;

        // 4. Standard linked list reversal for the range [left, right]
        for (int i = 0; i <= right - left; i++) {
            ListNode nextNode = currNode.next; // Temporarily store the next node
            currNode.next = preNode;           // Reverse the current node's pointer
            preNode = currNode;                // Move preNode forward
            currNode = nextNode;               // Move currNode forward
        }

        // 5. Re-connect the reversed section back into the main list
        // 'preNode' is now the new head of the reversed section
        leftNode.next = preNode; 
        
        // 'currNode' is now the node immediately following the 'right' position
        subListHead.next = currNode; 

        return dummy.next;
    }
}
