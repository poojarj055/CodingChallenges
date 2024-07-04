import java.util.*;
public class Solution {
    public static List< Integer > majorityElement(int []nums) {
        // Write your code here
         List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int requiredCount = n / 3;

        // Step 1: Count frequencies using HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find elements with frequency greater than n / 3
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > requiredCount) {
                result.add(entry.getKey());
            }
        }

        // Step 3: Sort the result list
       Collections.sort(result);

        return result;
    }
}

// NOTE:
// getOrDefault method:

// getOrDefault(num, defaultValue) is a method in HashMap that returns the value to which the specified key (num) is mapped, or a default value (defaultValue) if the key is not present in the map.
// In the context of the line freqMap.put(num, freqMap.getOrDefault(num, 0) + 1), it ensures that you fetch the current count (freqMap.getOrDefault(num, 0)) and then increment it by 1 (+ 1).
// Here's a step-by-step explanation of what happens:

// freqMap.getOrDefault(num, 0): This part retrieves the current count of num from the freqMap. If num is present in freqMap, it returns its current count (value associated with num). If num is not present, it returns 0 (the default value provided).
// + 1: This increments the retrieved count by 1.
// freqMap.put(num, ...): Finally, this line updates freqMap with the incremented count (freqMap.put(num, freqMap.getOrDefault(num, 0) + 1)).
// Example:
// If freqMap initially is {1=2, 2=1} and you execute freqMap.put(1, freqMap.getOrDefault(1, 0) + 1):

// freqMap.getOrDefault(1, 0) will return 2 (since 1 is mapped to 2 in freqMap).
// 2 + 1 equals 3.
// So, freqMap.put(1, 3) will update the entry for 1 in freqMap to {1=3, 2=1}.
// This approach is useful for counting occurrences of elements in a collection efficiently, ensuring that the map doesn't throw a NullPointerException when the key is absent by providing a default value.
