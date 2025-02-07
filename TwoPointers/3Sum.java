// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.
// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
// Example 2:

// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.
// Example 3:

// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.
---------------------------------------------------------------------------------------------
import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.List;  

class Solution {  
    public List<List<Integer>> threeSum(int[] nums) {  
        Set<List<Integer>> result = new HashSet<>();  
        Arrays.sort(nums); // Step 1: sort the array  

        for (int i = 0; i < nums.length - 2; i++) {   

            int left = i + 1; // Second pointer  
            int right = nums.length - 1; // Third pointer  
            
            while (left < right) {  
                int threeSum = nums[i] + nums[left] + nums[right];  

                if (threeSum == 0) {  
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));  
                    // Move the second pointer to the right  
                    left++;  
                    right--;  
                } else if (threeSum < 0) {  
                    left++; // We need a larger sum  
                } else {  
                    right--; // We need a smaller sum  
                }  
            }  
        }  
        return new ArrayList<>(result);  
    }  
}


--------------------------------------------
// Optimization
// Instead of using Set<List<Integer>>, we can avoid duplicates in O(1) space by skipping duplicate elements in the loop:

if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate numbers
This will reduce space complexity to O(1) while maintaining the same time complexity.

// Summary
// Sort the array to help with the two-pointer approach.
// Iterate through the array, fixing one number at a time.
// Use two pointers (left, right) to find pairs that sum to 0 - nums[i].
// Avoid duplicates using a Set or by skipping duplicate elements.
// Time complexity: O(n²), Space complexity: O(n) (or O(1) if duplicates are handled in place).


