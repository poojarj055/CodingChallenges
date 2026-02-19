// Given an array of positive integers arr[], find the maximum sum of a subsequence such that the elements of the subsequence form a strictly increasing sequence.
// In other words, among all strictly increasing subsequences of the array, return the one with the largest possible sum.

// Examples:

// Input: arr[] = [1, 101, 2, 3, 100]
// Output: 106
// Explanation: The maximum sum of an increasing sequence is obtained from [1, 2, 3, 100].
// Input: arr[] = [4, 1, 2, 3]
// Output: 6
// Explanation: The maximum sum of an increasing sequence is obtained from [1, 2, 3].
// Input: arr[] = [4, 1, 2, 4]
// Output: 7
// Explanation: The maximum sum of an increasing sequence is obtained from [1, 2, 4].
// Constraints:
// 1 ≤ arr.size() ≤ 103
// 1 ≤ arr[i] ≤ 105

class Solution {
    public int maxSumIS(int arr[]) {
        // code here
        Integer[][] cache=new Integer[arr.length+1][arr.length+2];
        return maxSumISRecur(arr, 0, -1, cache);
    }
    int maxSumISRecur(int nums[], int index, int prevIndex, Integer [][]cache){
        if(index==nums.length){
            return 0;
        }
        
        if(prevIndex!=-1 && cache[index][prevIndex]!=null){
            return cache[index][prevIndex];
        }
        
        int take=0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]){
            take= nums[index] + maxSumISRecur(nums, index+1, index,cache);
        }
        int dontTake= maxSumISRecur(nums, index+1, prevIndex,cache);
        if(prevIndex!=-1){
             cache[index][prevIndex]= Math.max(take, dontTake);
        }
        return Math.max(take, dontTake);
    }
}
