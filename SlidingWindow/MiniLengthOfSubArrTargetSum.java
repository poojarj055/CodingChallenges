// Given an array of positive integers nums and a positive integer target, return the minimal length of a 
// subarray
//  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

// Example 1:

// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem constraint.
// Example 2:

// Input: target = 4, nums = [1,4,4]
// Output: 1
// Example 3:

// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // Expand window by adding nums[right]

            // Shrink window from the left while the sum is >= target
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left]; // Remove the leftmost element
                left++; // Move the left pointer forward
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength; // If no valid subarray found, return 0
    }
}



----------------------------------------------------------

Explanation of the Approach:
----------------------------
Use a Sliding Window (Two Pointers Approach)
Expand the window by adding nums[right].
If sum >= target, shrink the window from the left by removing nums[left] and updating minLength.
Keep track of the smallest valid subarray length.
Return 0 if no valid subarray is found (i.e., if minLength remains Integer.MAX_VALUE).
  
Time Complexity Analysis
  -----------------------
O(n) → Each element is processed at most twice (once when expanding and once when shrinking).
O(1) Space Complexity → Uses only a few integer variables.



  
  
