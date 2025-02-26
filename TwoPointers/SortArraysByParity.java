// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
// Return any array that satisfies this condition.

// Example 1:

// Input: nums = [3,1,2,4]
// Output: [2,4,3,1]
// Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
// Example 2:

// Input: nums = [0]
// Output: [0]

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // Move left pointer if it's even
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            // Move right pointer if it's odd
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            // Swap elements if left is odd and right is even
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}


----------------------------------------------------------------------------

How It Works?
Two Pointers:
left starts from the beginning (looking for odd numbers).
right starts from the end (looking for even numbers).

Processing the Array:
left moves forward if the number is even.
right moves backward if the number is odd.

If nums[left] is odd and nums[right] is even, swap them.
Stop when left meets right.
 

