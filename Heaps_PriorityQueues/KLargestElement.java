// You are given an unsorted array containing ‘N’ integers. You need to find ‘K’ largest elements from the given array.
//   Also, you need to return the elements in non-decreasing order.

import java.util.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static int[] Klargest(int[] a, int k, int n) {
        // Write your code here
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int num:a){
            minHeap.offer(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }  int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }

       
        Arrays.sort(result);
        return result;
    }
}

```````````````````````````````````````````````````````````````````````````````````````````````````
Explanation:
1. Min-Heap Initialization:
A PriorityQueue (min-heap) is used to keep track of the k largest elements.
2. Adding Elements to the Min-Heap:
3. Iterate through each element in the array and add it to the minHeap.
4. If the size of the minHeap exceeds k, remove the smallest element using poll(). This ensures that the minHeap only contains the k largest elements.
5. Extracting Elements:
6. Create an array result of size k.
7. Extract all elements from the minHeap into the result array.
8. Sorting the Result:
9. Use Arrays.sort(result) to sort the array in non-decreasing order.
10. Returning the Result:
11. Return the sorted result array.
`````````````````````````````````````````````````````````````````````````````````````````````````````


