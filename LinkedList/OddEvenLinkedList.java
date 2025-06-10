You must solve the problem in O(1) extra space complexity and O(n) time complexity.
Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:

Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]

  
````````````````````````````````````
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head; // Edge case

        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next; // Link next odd node
            odd = odd.next; // Move forward in odd list
            even.next = odd.next; // Link next even node
            even = even.next; // Move forward in even list
        }

        odd.next = evenHead; // Connect odd and even lists
        return head;
    }
}
