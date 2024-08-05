// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:

// Input: nums = [1,2,3], k = 3
// Output: 2



import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store the cumulative sum and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initialize with 0 sum having one count
        map.put(0, 1);
        
        int sum = 0; // To store the cumulative sum
        int count = 0; // To store the number of subarrays that sum to k
        
        for (int num : nums) {
            sum += num; // Update the cumulative sum
            
            // Check if there is a subarray that sums to k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            // Update the map with the current cumulative sum in hashmap
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(sol.subarraySum(nums, k)); // Output should be 2
    }
}

``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
Explanation:

1. HashMap Initialization: The HashMap map is initialized with (0, 1) to handle the case when a subarray itself equals k.
2. Cumulative Sum Calculation: We iterate through the array and update the cumulative sum sum.
3. Subarray Check: For each cumulative sum, we check if (sum - k) exists in the map. If it does, it means there is a subarray ending at the current index which sums to k. We increment count by the frequency of (sum - k).
4. Update HashMap: We update the map with the current cumulative sum and its frequency.
5. This approach efficiently counts all subarrays that sum to k with a time complexity of O(n) and a space complexity of O(n).

`````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````



