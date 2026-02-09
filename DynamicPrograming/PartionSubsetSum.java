// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
// Example 1:

// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
// Example 2:

// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
 

// Constraints:

// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100


  class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
          sum=sum+nums[i];
        }
        if (sum % 2 != 0) return false;
        int evenSum=sum/2; 
        Boolean cache[][]=new Boolean[evenSum+1][nums.length+1];
        return canPartitionRecur(nums, evenSum, 0,cache);
    }
     boolean canPartitionRecur(int[] nums, int evenSum, int index, Boolean [][]cache){
        if(evenSum==0) return true;
        if(index>=nums.length) return false;

        if(cache[evenSum][index]!=null){
            return cache[evenSum][index];
        }

        boolean include = false; 
        if (evenSum - nums[index] >= 0) {
          include=canPartitionRecur(nums, evenSum-nums[index], index+1,cache);
        }

        boolean exclude=canPartitionRecur(nums, evenSum, index+1,cache);

        cache[evenSum][index]= include||exclude;
        return cache[evenSum][index];
    }
}
