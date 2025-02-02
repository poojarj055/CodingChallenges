// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.
// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate left prefix product
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply with right suffix product
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i]; // Update right product
        }

        return result;
    }
}

// How This Works:
// Step 1: Compute Left Prefix Products
// Stores product of all elements before index i in result[].

// Index	nums[i]	result[] (Left Prefix Product)
// 0	1	1
// 1	2	1
// 2	3	1 * 2 = 2
// 3	4	1 * 2 * 3 = 6


// Step 2: Multiply by Right Suffix Product
// Iterates from right to left, multiplying by the right-side product.

// Index	nums[i]	Right Product	Final result[]
// 3	4	1	6 * 1 = 6
// 2	3	4	2 * 4 = 8
// 1	2	12	1 * 12 = 12
// 0	1	24	1 * 24 = 24
// Final Output: [24, 12, 8, 6] 




