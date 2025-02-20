You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);  // Dummy node
        ListNode returnNode = dummy;  // Pointer to construct the merged list
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                returnNode.next = list1;
                list1 = list1.next;
            } else {
                returnNode.next = list2;
                list2 = list2.next;
            }
            returnNode = returnNode.next;
        }
        
        // Append the remaining nodes of the non-empty list
        if (list1 != null) {
            returnNode.next = list1;
        } else {
            returnNode.next = list2;
        }
        
        return dummy.next;  // Return the merged list starting from the first real node
    }
}


