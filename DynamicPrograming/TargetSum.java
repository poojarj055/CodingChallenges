// You are given an integer array nums and an integer target.
// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.
// Example 1:

// Input: nums = [1,1,1,1,1], target = 3
// Output: 5
// Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3
// Example 2:

// Input: nums = [1], target = 1
// Output: 1
 

// Constraints:

// 1 <= nums.length <= 20
// 0 <= nums[i] <= 1000
// 0 <= sum(nums[i]) <= 1000
// -1000 <= target <= 1000

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if((sum+target)%2!=0) return 0;

        int subsetSum=(sum+target)/2;
    
        return findTargetSumWaysRecur(nums, 0, subsetSum);
    }
    int findTargetSumWaysRecur(int []nums, int index, int subsetSum){
        if(index==nums.length && subsetSum==0) return 1;
        if(index>=nums.length) return 0;

        int include=0;
        if(nums[index]<=subsetSum){
            include=findTargetSumWaysRecur(nums, index+1, subsetSum-nums[index]);
        }
        int exclude=findTargetSumWaysRecur(nums, index+1, subsetSum);

        return include+exclude;
    }
}
