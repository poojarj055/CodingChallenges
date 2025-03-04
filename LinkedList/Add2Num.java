You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself. 

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

public ListNode addTwoNum(ListNode l1, ListNode l2){
  ListNode result=new ListNode(0);
  ListNode ptr=result;
  int carry=0;

  while(l1!=null || l2!=null){
    int sum= 0+carry;
    if(l1!=null){
      sum=sum+l1.val;
      l1=l1.next;
    }
    if(l2!=null){
      sum=sum+l2.val;
      l2=l2.next;
      }
    carry=sum/10;
    sum=sum%10;
    ptr.next=new ListNode(sum);
    ptr=ptr.next;
}
  if(carry==1)
  {
    ptr.next=new ListNode(1);
  }
  return result.next;
} 
-----------------------------------------------------------



I'll explain the logic of the "Add Two Numbers" solution:

### Problem Overview
We have two numbers represented as linked lists in reverse order. For example:
- 342 is represented as [2,4,3]
- 465 is represented as [5,6,4]

Our task is to add these numbers and return the result as a linked list in the same format.

### The Algorithm Logic

1. **Initialize the Result Structure**
   ```java
   ListNode result = new ListNode(0);  // Dummy head node
   ListNode ptr = result;              // Pointer to build the result list
   int carry = 0;                      // Initialize carry to 0
   ```
   We create a dummy head node to make building the list easier, and we'll return `result.next` at the end.

2. **Process Both Lists Simultaneously**
   ```java
   while (l1 != null || l2 != null) {
       // Loop continues as long as either list has nodes left
   ```
   This ensures we process all digits from both numbers.

3. **Calculate Sum for Current Position**
   ```java
   int sum = 0 + carry;  // Start with any carry from previous position
   
   if (l1 != null) {
       sum = sum + l1.val;  // Add digit from first number
       l1 = l1.next;        // Move to next digit
   }
   
   if (l2 != null) {
       sum = sum + l2.val;  // Add digit from second number
       l2 = l2.next;        // Move to next digit
   }
   ```
   We add the current digits from both lists along with any carry from the previous position.

4. **Handle Carry and Remainder**
   ```java
   carry = sum / 10;   // Calculate new carry (0 or 1)
   sum = sum % 10;     // Calculate digit to store (0-9)
   ```
   If the sum is 10 or greater, we need to carry the 1 to the next position.

5. **Build Result List**
   ```java
   ptr.next = new ListNode(sum);  // Add new node with current digit
   ptr = ptr.next;                // Move pointer to the new node
   ```
   We attach a new node with the current digit to our result list.

6. **Handle Final Carry**
   ```java
   if (carry == 1) {
       ptr.next = new ListNode(1);  // If there's a final carry, add it
   }
   ```
   If there's a carry after processing all digits, we need to add an extra node (like in example 3).

7. **Return Result**
   ```java
   return result.next;  // Skip the dummy head node
   ```
   We return `result.next` to skip the dummy head node.

### Example Walkthrough

Let's trace example 1: [2,4,3] + [5,6,4]

1. Initialize `result` with dummy head node (0), `ptr` points to it, `carry` = 0
2. First iteration:
   - `sum` = 0 + 2 + 5 = 7
   - `carry` = 0, `sum` = 7
   - Add node with value 7 to result
   - Result so far: [0] → [7]
3. Second iteration:
   - `sum` = 0 + 4 + 6 = 10
   - `carry` = 1, `sum` = 0
   - Add node with value 0 to result
   - Result so far: [0] → [7] → [0]
4. Third iteration:
   - `sum` = 1 + 3 + 4 = 8
   - `carry` = 0, `sum` = 8
   - Add node with value 8 to result
   - Result so far: [0] → [7] → [0] → [8]
5. Both lists are empty, and carry is 0, so we're done
6. Return `result.next` which is [7] → [0] → [8]

This gives us 807, which is indeed 342 + 465.  
