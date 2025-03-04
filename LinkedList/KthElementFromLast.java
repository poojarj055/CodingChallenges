Given the head of a linked list and the number k, Your task is to find the kth node from the end. 
  If k is more than the number of nodes, then the output should be -1.

Input: LinkedList: 1->2->3->4->5->6->7->8->9, k = 2
Output: 8
Explanation: The given linked list is 1->2->3->4->5->6->7->8->9. The 2nd node from end is 8.


Input: LinkedList: 10->5->100->5, k = 5
Output: -1
Explanation: The given linked list is 10->5->100->5. Since 'k' is more than the number of nodes, the output is -1.



class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        // Your code here
        Node firstPtr=head;
        Node secondPtr=head;
        
        for(int i=0;i<k;i++){
            if(secondPtr!=null)
            secondPtr=secondPtr.next;
            else
            return -1;
        }
        while(secondPtr!=null){
            firstPtr=firstPtr.next;
            secondPtr=secondPtr.next;
        }
        return firstPtr.data;
    }
}



