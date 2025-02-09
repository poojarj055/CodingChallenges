// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]

import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies using a HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a min-heap (PriorityQueue) to keep track of top k elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        // Step 3: Extract k most frequent elements from the heap
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(topKFrequent(nums1, k1))); // Output: [1, 2]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(topKFrequent(nums2, k2))); // Output: [1]
    }
}


--------------------------------------------------
Explanation
Count Frequencies

Use a HashMap<Integer, Integer> to store the frequency of each number.
Example: {1=3, 2=2, 3=1} for nums = [1,1,1,2,2,3].
Use a Min-Heap (PriorityQueue)

The heap stores elements with the smallest frequency at the top.
Comparator: Comparator.comparingInt(Map.Entry::getValue) ensures sorting by frequency.
If the heap size exceeds k, we remove the least frequent element to keep only the top k.
Extract k Most Frequent Elements

Poll elements from the heap into an array.


