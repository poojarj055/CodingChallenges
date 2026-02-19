// Given an integer array nums, return the length of the longest strictly increasing subsequence.
// Example 1:

// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
// Example 2:

// Input: nums = [0,1,0,3,2,3]
// Output: 4
// Example 3:

// Input: nums = [7,7,7,7,7,7,7]
// Output: 1

class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer [][] cache=new Integer[nums.length+1][nums.length+2];
        return lengthOfLISRecur(nums, 0, -1, cache);
    }

    int lengthOfLISRecur(int[] nums, int index, int prevIndex, Integer [][] cache){
        if(index==nums.length){
            return 0;
        }

        if(prevIndex!=-1 && cache[index][prevIndex]!=null){
            return cache[index][prevIndex];
        }


        int take=0;
            if(prevIndex==-1 || nums[index] > nums[prevIndex]) 
            { 
                take = 1 + lengthOfLISRecur(nums, index+1, index, cache);
            }
        int dontTake = lengthOfLISRecur(nums, index+1, prevIndex, cache);
        if(prevIndex!=-1){
        cache[index][prevIndex]= Math.max(take, dontTake);
        }
        return Math.max(take, dontTake);
    }

}
