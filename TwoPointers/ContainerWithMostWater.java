// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.
// Example 1:
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
// Example 2:

// Input: height = [1,1]
// Output: 1
 
// Constraints:

// n == height.length
// 2 <= n <= 105
// 0 <= height[i] <= 104


class Solution {
    public int maxArea(int[] height) {
        // Initialize two pointers: one at the start and one at the end of the array
        int left = 0;
        int right = height.length - 1;
        
        // Variable to keep track of the maximum area found
        int maxArea1 = 0;

        // Loop until the two pointers meet
        while (left < right) {
            // Find the height of the shorter line between the two pointers
            int minHeight = Math.min(height[left], height[right]);

            // Calculate the area formed between the two lines
            int area = minHeight * (right - left);

            // Update maxArea1 if the current area is greater than the previous maximum
            maxArea1 = Math.max(area, maxArea1);

            // Move the pointer which is at the shorter line
            // This helps in potentially finding a taller line and a larger area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        // Return the maximum area found
        return maxArea1;
    }
}
