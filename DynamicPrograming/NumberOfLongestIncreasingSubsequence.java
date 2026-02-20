// Given an integer array nums, return the number of longest increasing subsequences.
// Notice that the sequence has to be strictly increasing.
// Example 1:

// Input: nums = [1,3,5,4,7]
// Output: 2
// Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
// Example 2:

// Input: nums = [2,2,2,2,2]
// Output: 5
// Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 
class Solution {
    public int findNumberOfLIS(int[] nums) {
        Integer [][]cache1=new Integer[nums.length+1][nums.length+1];
        Integer [][][]cache2=new Integer[nums.length+1][nums.length+1][nums.length+1];
        int lisLength = findNumberOfLISRecur(nums, 0, -1, cache1);
        return countNumberOfLISRecur(nums, 0, -1, lisLength, cache2);
    }

    // First: compute LIS length
    int findNumberOfLISRecur(int[] nums, int index, int prevIndex, Integer [][]cache) {
        if (index == nums.length) return 0;

        if(prevIndex!=-1 && cache[index][prevIndex]!=null){
            return cache[index][prevIndex];
        }

        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + findNumberOfLISRecur(nums, index+1, index, cache);
        }
        int dontTake = findNumberOfLISRecur(nums, index+1, prevIndex, cache);
        if(prevIndex!=-1){
        cache[index][prevIndex]= Math.max(take, dontTake);
        }
        return  Math.max(take, dontTake);
    }

    // Second: count subsequences of LIS length
    int countNumberOfLISRecur(int[] nums, int index, int prevIndex, int length,Integer [][][]cache) {
        if (length == 0) {
            return 1;
        }
        if (index == nums.length) {
            return 0;
        }

        if(prevIndex!=-1 && cache[index][prevIndex][length]!=null){
            return cache[index][prevIndex][length];
        }

        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = countNumberOfLISRecur(nums, index+1, index, length-1, cache);
        }
        int dontTake = countNumberOfLISRecur(nums, index+1, prevIndex, length, cache);

        if(prevIndex!=-1){
            cache[index][prevIndex][length]= take + dontTake;
        }

        return take + dontTake;
    }
}

