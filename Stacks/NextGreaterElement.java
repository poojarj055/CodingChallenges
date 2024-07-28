// Problem statement
// You have been given an array/list ‘ARR’ consisting of ‘N’ positive integers. Your task is to return the Next Greater Element(NGE) for every element.
// The Next Greater Element for an element ‘X’ is the first element on the right side of ‘X’ in the array 'ARR', which is greater than ‘X’.
//   If no such element exists to the right of ‘X’, then return -1.
// For example:
// For the given array 'ARR' = [7, 12, 1, 20]

// The next greater element for 7 is 12.
// The next greater element for 12 is 20. 
// The next greater element for 1 is 20. 
// There is no greater element for 20 on the right side.

// So, the output is [12, 20, 20, -1].

import java.util.Stack;

public class Solution {

    public static int[] nextGreater(int[] arr, int n) {
        // Result array to store the next greater elements
        int[] nge = new int[n];
        // Stack to store indices of the array elements
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack that are less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            // If stack is empty, it means there is no greater element, so store -1
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current element onto the stack
            stack.push(arr[i]);
        }
        
        return nge;
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};
        int n = arr.length;
        int[] result = nextGreater(arr, n);

        // Print the result
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
```````````````````````````````````````````````````````````````````````````
Explanation:
Initialization:
The nge array is created to store the next greater elements.
A Stack<Integer> is used to keep track of indices of the elements.
Iterate through the array from right to left:
Start iterating from the last element to the first element of the array.
Stack Operations:
For each element, pop elements from the stack that are less than or equal to the current element. This ensures that the stack only contains potential candidates for the next greater element.
If the stack is empty after popping, it means there is no greater element for the current element, so we store -1 in the nge array.
Otherwise, the next greater element is the top element of the stack.
Push Current Element:
Push the current element onto the stack for future comparisons.
Return Result:
After iterating through the array, return the nge array containing the next greater elements for each element in the input array.

``````````````````````````````````````````````````````````````````````````````````````````````````````````````````


