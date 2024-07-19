// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

// Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

var missingNumber = function(nums) {
    let sum1=0;
    let sum2=0;
    for(let i=0;i<nums.length;i++){
        sum1=sum1+nums[i];
        sum2=sum2+i;
    }
    return sum2+nums.length-sum1;
   
};
