// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.
// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:

// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
// Example 3:

// Input: nums = [1,0,1,2]
// Output: 3


import java.util.Arrays;

class Solution {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums); // Sort the array
        int maxLength = 1, currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                currentLength++;  // Increase streak
            } else if (nums[i] != nums[i - 1]) {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;  // Reset for new sequence
            }
        }

        return Math.max(maxLength, currentLength);
    }

    public static void main(String[] args) {
        int[] input = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(input));
    }
}


 
