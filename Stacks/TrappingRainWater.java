// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

BRUTE-FORCE Approach

import java.util.*;
class TUF {
    static int trap(int[] arr) {
        int n = arr.length;
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int leftMax = 0, rightMax = 0;
            while (j >= 0) {
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }
            j = i;
            while (j < n) {
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }
            waterTrapped += Math.min(leftMax, rightMax) - arr[i];
        }
        return waterTrapped;
    }
    public static void main(String args[]) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The duplicate element is " + trap(arr));
    }
}





import java.util.Stack;

public class Solution {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int water_trapped = 0;
        Stack<Integer> stack = new Stack<>();
        int n = height.length;

        for (int i = 0; i < n; i++) {
            // While stack is not empty and current height is greater than height at the index at the top of the stack
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop(); // Index of the bar that forms a boundary

                if (stack.isEmpty()) {
                    break; // No boundary on the left
                }

                // Calculate the distance between the current index and the new top of the stack
                int distance = i - stack.peek() - 1;
                // Calculate the bounded height
                int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
                // Update the water trapped
                water_trapped += distance * bounded_height;
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return water_trapped;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height)); // Output: 6
    }
}





Example Input
Height Array: [0, 1, 0, 2, 1, 0, 1, 3]
Diagrammatic Flow
Let's visualize the stack-based approach step-by-step.

Initial State

Height Array: [0, 1, 0, 2, 1, 0, 1, 3]
Stack: []
Answer (ans): 0
Iteration 1 (i = 0)

Current Bar Height: 0
Action: Push index 0 onto the stack.
Stack: [0]
Iteration 2 (i = 1)

Current Bar Height: 1
Action: Height of bar at index 1 is greater than the height of the bar at index 0.
Pop index 0 (Height: 0)
Stack after Pop: []
Since the stack is empty, no water trapped.
Push index 1 onto the stack.
Stack: [1]
Iteration 3 (i = 2)

Current Bar Height: 0
Action: Push index 2 onto the stack.
Stack: [1, 2]
Iteration 4 (i = 3)

Current Bar Height: 2
Action: Height of bar at index 3 is greater than the height of the bar at index 2.
Pop index 2 (Height: 0)
Width between indices 3 and 1: 3 - 1 - 1 = 1
Height of water trapped: min(2, 1) - 0 = 1
Water trapped: 1 * 1 = 1
Height of bar at index 3 is also greater than the height of the bar at index 1.
Pop index 1 (Height: 1)
Width between indices 3 and -1: 3 - (-1) - 1 = 3
Since the stack is empty after this pop, skip further calculations.
Push index 3 onto the stack.
Stack: [3]
Iteration 5 (i = 4)

Current Bar Height: 1
Action: Push index 4 onto the stack.
Stack: [3, 4]
Iteration 6 (i = 5)

Current Bar Height: 0
Action: Push index 5 onto the stack.
Stack: [3, 4, 5]
Iteration 7 (i = 6)

Current Bar Height: 1
Action: Height of bar at index 6 is greater than the height of the bar at index 5.
Pop index 5 (Height: 0)
Width between indices 6 and 4: 6 - 4 - 1 = 1
Height of water trapped: min(1, 1) - 0 = 1
Water trapped: 1 * 1 = 1
Height of bar at index 6 is also greater than the height of the bar at index 4.
Pop index 4 (Height: 1)
Width between indices 6 and 3: 6 - 3 - 1 = 2
Height of water trapped: min(1, 2) - 1 = 0
Water trapped: 0 * 2 = 0
Push index 6 onto the stack.
Stack: [3, 6]
Iteration 8 (i = 7)

Current Bar Height: 3
Action: Height of bar at index 7 is greater than the height of the bar at index 6.
Pop index 6 (Height: 1)
Width between indices 7 and 3: 7 - 3 - 1 = 3
Height of water trapped: min(3, 3) - 1 = 2
Water trapped: 2 * 3 = 6
Height of bar at index 7 is also greater than the height of the bar at index 3.
Pop index 3 (Height: 2)
Since the stack is empty after this pop, skip further calculations.
Push index 7 onto the stack.
Stack: [7]
Final Calculation

Total Water Trapped: 1 (i=3) + 1 (i=6) + 6 (i=7) = 8
Summary
Initialization:
Stack: Empty
Answer: 0
Push indices onto stack and compute water trapped when a higher bar is encountered.
Pop bars from the stack when a higher bar is encountered, calculate trapped water using the popped bar as the base.
Continue until all bars are processed.
Result for the input [0, 1, 0, 2, 1, 0, 1, 3] is 8 units of trapped water.

