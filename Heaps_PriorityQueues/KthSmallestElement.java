import java.util.PriorityQueue;
import java.util.Collections;

public class Solution {
    public static int kthSmallest(int n, int k, int[] arr) {
        // Create a max-heap of size k
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            // Add current element to the heap
            maxHeap.add(num);
            
            // If heap size exceeds k, remove the maximum element
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // The root of the heap is the kth smallest element
        return maxHeap.peek();
    }
}



Explanation:
```````````````````````````````````````````````````````````````````````````````````
Explanation:
1. Max-Heap: The heap stores the smallest k elements encountered so far. The largest of these k elements is at the root of the heap.
2. Adding Elements: For each element in the array, add it to the heap. If the heap's size exceeds k, remove the largest element (root of the heap). This way, the heap will always contain the k smallest elements of the array.
3. Result: After processing all elements, the root of the heap (maxHeap.peek()) will be the kth smallest element.
