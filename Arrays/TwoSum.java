// Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

// Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

// The tests are generated such that there is exactly one solution. You may not use the same element twice.

// Your solution must use only constant extra space.

// Example 1:

// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
// Example 2:

// Input: numbers = [2,3,4], target = 6
// Output: [1,3]
// Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; 
    }
}



// Initialize two pointers:

// left at index 0 (start of the array).
// right at index numbers.length - 1 (end of the array).
// Loop until left < right:

// Calculate sum = numbers[left] + numbers[right].
// If sum == target: Return the 1-based indices (left + 1, right + 1).
// If sum < target: Move left++ (increase the sum).
// If sum > target: Move right-- (decrease the sum).
// If no solution is found, return [-1, -1].

// Time & Space Complexity
// ✅ Time Complexity: O(N)

// Since we are traversing the array at most once, the complexity is O(N).
// ✅ Space Complexity: O(1)

// No extra data structures are used, so the space complexity is constant.
