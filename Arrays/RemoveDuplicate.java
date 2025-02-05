// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
//The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

// Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

// Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. 
// The remaining elements of nums are not important as well as the size of nums.
// Return k.

import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        
        // Step 1: Add all elements to LinkedHashSet to remove duplicates
        for (int num : nums) {
            set.add(num);
        }

        // Step 2: Copy unique elements back to nums[]
        int index = 0;
        for (int num : set) {
            nums[index] = num;
            index++;
        }

        return set.size(); // New length of unique elements
    }
}

but space complexity is 0(n)

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int j = 0; // Pointer for unique elements
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) { // Found a new unique element
                j++;
                nums[j] = nums[i]; // Move unique element forward
            }
        }
        
        return j + 1; // Length of unique elements
    }
}

here time complexity is o(n) and space is o(1)



