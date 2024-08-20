import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestValue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // Read number of test cases

        while (T-- > 0) {
            int N = sc.nextInt();  // Read number of elements in array
            int K = sc.nextInt();  // Read Kth position
            
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            // PriorityQueue to store the K largest elements
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // Iterate through the array
            for (int num : arr) {
                minHeap.add(num);

                // If the heap size exceeds K, remove the smallest element
                if (minHeap.size() > K) {
                    minHeap.poll();
                }
            }

            // The root of the heap is the Kth largest element
            System.out.println(minHeap.peek());
        }
        
        sc.close();
    }
}



Explanation:
1. PriorityQueue as Min Heap: Java's PriorityQueue defaults to a Min Heap, which helps keep track of the smallest element in the heap of size K.
2. Maintaining Heap Size: By maintaining the heap size as K, we ensure that after processing all elements, the smallest element in the heap is the Kth largest element in the array.
3. Efficiency: This solution runs in O(N log K) time for each test case, which is efficient given the constraints.



  
