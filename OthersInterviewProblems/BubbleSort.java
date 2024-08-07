// Bubble Sort Algorithm:
// Bubble Sort is a simple comparison-based sorting algorithm that repeatedly steps through the list,
// compares adjacent elements, and swaps them if they are in the wrong order. This process is repeated until the list is sorted.

public class Solution {

    public static void bubbleSort(int[] arr, int n) {
        // Outer loop to ensure n-1 passes over the array
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;  // Flag to detect if any swap was made in this pass
            
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                // If the current element is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    // Swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;  // Mark swapped as true
                }
            }
            
            // If no swaps were made in this pass, the array is already sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};  // Example array to be sorted
        int n = arr.length;
        bubbleSort(arr, n);  // Call to bubbleSort method
        
        // Print the sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

````````````````````````````````````````````````````````````````````````````````````````````````````
Explanation of Key Parts:
1. Outer Loop (for (int i = 0; i < n - 1; i++)):
This loop runs n-1 times because after n-1 passes, the array will be sorted.
i is the current pass number.
2. Inner Loop (for (int j = 0; j < n - 1 - i; j++)):
This loop runs through the array, comparing each pair of adjacent elements.
The - i part ensures that the already sorted elements at the end of the array are not compared again.
3. Swapping Elements (if (arr[j] > arr[j + 1])):
If the current element is greater than the next element, they are swapped.
The swapped flag is set to true to indicate that a swap has occurred.
4. Optimization (if (!swapped) break;):
If no elements were swapped in the inner loop, it means the array is already sorted, and the algorithm can terminate early.

````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
