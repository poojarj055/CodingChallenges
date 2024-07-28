// The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. 
// If there is no next greater element, then the answer for this query is -1.
// Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

// Example 1:

// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
// - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.  


let nge = new Array(nums1.length).fill(-1);
    
    for (let i = 0; i < nums1.length; i++) {
        let found = false;
        for (let j = 0; j < nums2.length; j++) {
            if (nums2[j] === nums1[i]) {
                found = true;
            }
            if (found && nums2[j] > nums1[i]) {
                nge[i] = nums2[j];
                break;
            }
        }
    }
    
    return nge;

```````````````````````````
Explanation:
Initialization of nge: The nge array is initialized with -1 for all elements.
Outer Loop: The outer loop goes through each element in nums1.
Inner Loop: The inner loop goes through each element in nums2.
found is used to start looking for the next greater element only after finding the nums1[i] in nums2.
Once nums1[i] is found (nums2[j] === nums1[i]), set found to true.
After found is true, check if the current nums2[j] is greater than nums1[i].
If a greater element is found, set nge[i] to that element and break out of the inner loop.
This code ensures that you correctly find the next greater element in nums2 for each element in nums1.

``````````````````````````````````````````````````````````````````````````````````````````````````


