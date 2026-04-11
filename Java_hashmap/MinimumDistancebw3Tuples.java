// You are given an integer array nums.
// A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].
// The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value of x.
// Return an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.
// Example 1:

// Input: nums = [1,2,1,1,3]
// Output: 6
// Explanation:
// The minimum distance is achieved by the good tuple (0, 2, 3).
// (0, 2, 3) is a good tuple because nums[0] == nums[2] == nums[3] == 1. Its distance is abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6.
// Example 2:
// Input: nums = [1,1,2,3,2,1,2]
// Output: 8
// Explanation:
// The minimum distance is achieved by the good tuple (2, 4, 6).
// (2, 4, 6) is a good tuple because nums[2] == nums[4] == nums[6] == 2. Its distance is abs(2 - 4) + abs(4 - 6) + abs(6 - 2) = 2 + 2 + 4 = 8.
// Example 3:
// Input: nums = [1]
// Output: -1
// Explanation:
// There are no good tuples. Therefore, the answer is -1.


class Solution {
    public int minimumDistance(int[] nums) {
        int tuple=-1;
        int minTuple=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]==nums[j] && nums[j]==nums[k]){
                        tuple=Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                        minTuple=Math.min(minTuple, tuple);
                    }
                }
            }
        }
        
        return minTuple!=Integer.MAX_VALUE? minTuple: tuple;
    }
}


///optimized solution


class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Step 1: group indices by value
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        /*Loop through the array
        i is the current index.
        nums[i] is the current value.
        computeIfAbsent
        This method checks if the key (nums[i]) already exists in the map.
        If it does, it returns the existing list.
        If it doesn’t, it creates a new ArrayList (using the lambda k -> new ArrayList<>()) and puts it in the map.
        .add(i)
        Once you have the list for that value, you add the current index i to it. */

        int minTuple = Integer.MAX_VALUE;
        
        // Step 2: check each group
        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
                // Step 3: only consecutive triples matter
                for (int i = 0; i + 2 < indices.size(); i++) {
                    int a = indices.get(i), b = indices.get(i+1), c = indices.get(i+2);
                    int tuple = Math.abs(a-b) + Math.abs(b-c) + Math.abs(c-a);
                    minTuple = Math.min(minTuple, tuple);
                }
            }
        }
        
        return minTuple == Integer.MAX_VALUE ? -1 : minTuple;
    }
}
