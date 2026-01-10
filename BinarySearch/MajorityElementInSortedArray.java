// Check If a Number Is Majority Element in a Sorted Array
// Solved 
// Given an integer array nums sorted in non-decreasing order and an integer target, return true if target is a majority element, or false otherwise.

// A majority element in an array nums is an element that appears more than nums.length / 2 times in the array.

// Example 1:

// Input: nums = [2,4,5,5,5,5,5,6,6], target = 5

// Output: true
// Explanation: The value 5 appears 5 times and the length of the array is 9. Thus, 5 is a majority element because 5 > 9/2 is true.

// Example 2:

// Input: nums = [10,100,101,101], target = 101

// Output: false
// Explanation: The value 101 appears 2 times and the length of the array is 4. Thus, 101 is not a majority element because 2 > 4/2 is false.


// Constraints:

// 1 <= nums.length <= 1000
// 1 <= nums[i], target <= 10⁹
// nums is sorted in non-decreasing order.
o(n)
---------------
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int occurence=nums.length/2;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                count++;
            }
        }
        return count>occurence;
    }
}
 o(log n)
 --------------------  
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int occurence=nums.length/2;
        int upperbound=nums.length;
        int left=0;
        int right=nums.length-1;
        while(left <=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
                upperbound=mid;
            }
            else{
                left=mid+1;
            }
        }
        int lowerbound=-1;
        int l=0;
        int r=nums.length-1;
         while(l <=r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target){
                l=mid+1;
                lowerbound=mid;
            }
            else{
                r=mid-1;
            }
        }
        return (upperbound -1) - (lowerbound +1) + 1 > occurence;
    }
}
