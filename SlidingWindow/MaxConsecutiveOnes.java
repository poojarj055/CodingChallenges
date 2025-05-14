// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
// Example 1:

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// Example 2:

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int maxOnes=0;
        int zeroCount=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[left]==0){
                zeroCount--;
                }
                left++;
            }
            
            maxOnes=Math.max(maxOnes, right-left+1);
        }
        return maxOnes;
    }
}


---------------------------
Input: nums = [1,1,0,0,1,1,1,0], k = 2

We are allowed to flip up to 2 zeros.
Sliding window will expand until more than 2 zeros are in the window.
Then it will shrink from the left until the number of zeros is ≤ 2.
It keeps track of the maximum window size where this condition holds.
Output: 6 (subarray [1,1,0,0,1,1] → flip both 0s → six 1s)



✅ Time Complexity:
O(n), where n is the length of nums.

Each element is visited at most twice (once by right and once by left), hence it's linear.

✅ Space Complexity:
O(1) — constant space.

We're only using a few integer variables: left, right, zeroCount, and maxOnes.


