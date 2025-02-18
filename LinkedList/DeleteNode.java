 237. Delete Node in a Linked List
// There is a singly-linked list head and we want to delete a node node in it.
// You are given the node to be deleted node. You will not be given access to the first node of head.
// All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
// Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
//     The value of the given node should not exist in the linked list.
//     The number of nodes in the linked list should decrease by one.
//     All the values before node should be in the same order.
//     All the values after node should be in the same order.
// Custom testing:
//     For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
//     We will build the linked list and pass the node to your function.
//     The output will be the entire list after calling your function.

// Input: head = [4,5,1,9], node = 5
// Output: [4,1,9]
// Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;

        node.val = node.next.val;  // Copy value of next node
        node.next = node.next.next; // Skip the next node
    }
}

-------------------------------------------------------------------------
Let's assume we have the following linked list:

1 -> 2 -> 3 -> 4 -> 5

Now, let's delete the node 3.
Step 1: Identify the node to be deleted

1 -> 2 -> [3] -> 4 -> 5

We are given only the node 3, and we do not have access to the head.
Step 2: Copy the value of the next node (4) to 3

1 -> 2 -> [4] -> 4 -> 5

Now, node 3 has taken the value 4.
Step 3: Remove the duplicate node

1 -> 2 -> 4 -> 5

Node 3 is effectively removed because 3.next is updated to 3.next.next.




