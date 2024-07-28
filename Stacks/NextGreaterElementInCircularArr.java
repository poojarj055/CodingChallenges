import java.util.Stack;

public class Solution {
    
    public static int[] nextGreater(int[] arr, int n) {
        // Result array to store the next greater elements
        int[] nge = new int[n];
        // Stack to store indices of the array elements
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the array twice to handle the circular nature
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Use modulo to wrap around the array
            int index = i % n;
            // Pop elements from the stack that are less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[index]) {
                stack.pop();
            }
            // If stack is empty, it means there is no greater element, so store -1
            nge[index] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current element onto the stack
            stack.push(arr[index]);
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
