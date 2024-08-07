// Insertion Sort Overview:
// Insertion sort is a simple sorting algorithm that builds the final sorted array one element at a time. It is much like sorting playing cards in your hands.

public class Solution {

    public static void insertionSort(int n, int[] arr) {
        // Write your code here.
        for (int i = 1; i < n; i++) {  // Start from 1 since the first element is already considered sorted
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                // Swap arr[j] and arr[j - 1]
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;  // Decrement j
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};  // Example array to be sorted
        int n = arr.length;
        insertionSort(n, arr);  // Call to insertionSort method
        
        // Print the sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
How Insertion Sort Works:
Start with the first element: Assume the first element is already sorted.
Pick the next element: Take the next element from the unsorted portion of the array.
Find the correct position: Compare the picked element with the elements in the sorted portion and shift all the elements that are greater than the picked element one position to the right.
Insert the element: Insert the picked element into its correct position in the sorted portion.
Repeat: Repeat the process until all elements are sorted.

`````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
