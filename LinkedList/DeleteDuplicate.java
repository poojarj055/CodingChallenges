// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
//   Return the linked list sorted as well.

// Example 1:
// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]
// Example 2:
// Input: head = [1,1,1,2,3]
// Output: [2,3]

/
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;
        while(curr!=null){
            if(curr.next!=null && curr.val==curr.next.val ){
                while(curr.next!=null && curr.val==curr.next.val){
                    curr=curr.next;
                }
                prev.next=curr.next;
            }
            else{
                prev=prev.next;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}

--------------------------------------------------------------------------

# Explanation of `deleteDuplicates` Method
This method removes all duplicate nodes from a sorted linked list, leaving only distinct numbers.  

---
🔹 Approach:
- Uses two pointers (`prev` and `curr`) to traverse the list.
- Skips all occurrences of a duplicate value instead of keeping any.

---
## 💡 Step-by-Step Breakdown
### 1️⃣ Create a Dummy Node
```
ListNode dummy = new ListNode(0);
dummy.next = head;
```
- A dummy node is used to handle cases where the first node(s) have duplicates.
- `dummy.next` points to the head of the list.

---
### 2️⃣ Initialize Pointers

ListNode prev = dummy;
ListNode curr = head;
```
- `prev`: Keeps track of the last unique node.
- `curr`: Traverses the list to detect duplicates.

---
### 3️⃣ Traverse the List

while (curr != null) {
```
- Loops through the entire linked list.

---
### 4️⃣ Skip Duplicates

if (curr.next != null && curr.val == curr.next.val) {
    while (curr.next != null && curr.val == curr.next.val) {
        curr = curr.next; // Skip all duplicates
    }
    prev.next = curr.next; // Remove all occurrences of duplicate values
}
```
- If duplicates are found, move `curr` until the last duplicate.
- `prev.next = curr.next;` skips all occurrences of the duplicate.

---
### 5️⃣ Move `prev` Pointer for Unique Nodes

else {
    prev = prev.next;
}
```
- If `curr` is not a duplicate, move `prev` forward normally.

---
### 6️⃣ Move `curr` Pointer

curr = curr.next;
```
- Move to the next node for processing.

---
### 7️⃣ Return Updated List

return dummy.next;
```
- `dummy.next` is the new head of the list.

---
## 🔹 Example Walkthrough
### Input:

head = [1, 2, 3, 3, 4, 4, 5]
```

### Initial State
```
dummy → 1 → 2 → 3 → 3 → 4 → 4 → 5
prev    curr
```

---
### Processing Each Node
#### ✅ `1` and `2` are unique (move forward)  
```
dummy → 1 → 2 → 3 → 3 → 4 → 4 → 5
         prev  curr
```
#### ❌ `3` is a duplicate (skip all `3`s)
```
dummy → 1 → 2 → (X 3 → 3 X) → 4 → 4 → 5
         prev              curr
prev.next = curr.next  (Skipping `3`s)
```
#### ❌ `4` is a duplicate (skip all `4`s)
```
dummy → 1 → 2 → (X 3 → 3 X) → (X 4 → 4 X) → 5
         prev                                curr
prev.next = curr.next  (Skipping `4`s)
```
#### ✅ `5` is unique (move forward)
```
dummy → 1 → 2 → 5
```
---
### Final Output

[1, 2, 5]
```

---
## 🔹 Time and Space Complexity
| Complexity | Explanation |
|------------|------------|
| O(n) | Traverses the list once. |
| O(1) | Uses constant extra space (only pointers). |

---
## 🔹 Why This Works?
✅ Handles first-node duplicates correctly using `dummy`  
✅ Deletes all duplicate occurrences instead of keeping one  
✅ Efficient O(n) solution with no extra space  

---
Let me know if you need further clarification! 🚀😊


  

