// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

var moveZeroes = function(nums) {
    let j=-1;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 0) {
            j = i;
            break;
        }
    }
     // No non-zero elements
    if (j === -1) return nums;
    // Move the pointers i and j and swap accordingly 0 elements accordingly
    for(let i=j+1;i<nums.length;i++){
        if(nums[i]!==0)
        {
            let temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            j++;
        }
    }
    return nums;
};
