// Given an integer array nums, find the 
// subarray
//  with the largest sum, and return its sum.
// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        // Initialize variables to store the maximum sum and current sum
        int maxSum = nums[0];
        int currentSum = nums[0];

        // Iterate through the array, starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update the current sum by including the current element
            // or starting a new subarray at the current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the maximum sum if the current sum is larger
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};

        System.out.println("Example 1 Output: " + maxSubArray(nums1)); // Output: 6
        System.out.println("Example 2 Output: " + maxSubArray(nums2)); // Output: 1
        System.out.println("Example 3 Output: " + maxSubArray(nums3)); // Output: 23
    }
}

