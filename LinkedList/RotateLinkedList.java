// Given the head of a linked list, rotate the list to the right by k places.
// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RotateLinkedList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Compute length
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Step 2: Make it circular
        temp.next = head;

        // Step 3: Optimize K (avoid unnecessary full rotations)
        k = k % length;
        int stepsToNewHead = length - k;

        // Step 4: Find new tail
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break circular list
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Utility function to print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int k = 2;
        head = rotateRight(head, k);

        System.out.println("Rotated List by " + k + " positions:");
        printList(head);
    }
}
