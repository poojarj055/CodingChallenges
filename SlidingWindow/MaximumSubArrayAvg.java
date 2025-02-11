643. Maximum Average Subarray I
// You are given an integer array nums consisting of n elements, and an integer k.
// Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
// Example 1:

// Input: nums = [1,12,-5,-6,50,3], k = 4
// Output: 12.75000
// Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
// Example 2:

// Input: nums = [5], k = 1
// Output: 5.00000

  class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, maxSum;
        
        // Calculate the sum of the first k elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxSum = sum;

        // Sliding window technique
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i]; // Remove leftmost element, add new rightmost element
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
-------------------------------
 O(n) time complexity

Each iteration:
Subtracts the element going out of the window (nums[i - k]).
Adds the new element coming into the window (nums[i]).
Updates maxSum if sum is greater.
 
