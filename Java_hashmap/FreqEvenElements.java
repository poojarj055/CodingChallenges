// Given an integer array nums, return the most frequent even element.
// If there is a tie, return the smallest one. If there is no such element, return -1.
// Example 1:

// Input: nums = [0,1,2,2,4,4,1]
// Output: 2
// Explanation:
// The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
// We return the smallest one, which is 2.
// Example 2:

// Input: nums = [4,4,4,9,2,4]
// Output: 4
// Explanation: 4 is the even element appears the most.
// Example 3:

// Input: nums = [29,47,21,41,13,37,25,7]
// Output: -1
// Explanation: There is no even element.


import java.util.*;

class Solution {
    public int mostFrequentEven(int[] nums) {
        // Count frequency of each even number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }
        
        // Find the even number with highest frequency; tie-breaker: smallest value
        int maxCount = 0;
        int answer = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount || (count == maxCount && num < answer)) {
                maxCount = count;
                answer = num;
            }
        }
        
        return answer;
    }
}


-------------------Better solution---------------------------

    
    class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxCount=0;
        int answer=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                continue;
            }
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);

            if(count>maxCount || (count==maxCount && nums[i]<answer)){
            maxCount=count;
            answer=nums[i];
            }
        }
        return answer;
    }
}

