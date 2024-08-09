// Problem statement
// For a given integer array/list 'ARR' of size 'N' containing all distinct values, find the total number of 'Inversions' that may exist.
// An inversion is defined for a pair of integers in the array/list when the following two conditions are met.
// A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:

// 1. 'ARR[i] > 'ARR[j]' 
// 2. 'i' < 'j'

// Where 'i' and 'j' denote the indices ranging from [0, 'N').

public class Solution {
    public static int countInversions(int[] arr) {
        int n = arr.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        int result = countInversions(arr);
        System.out.println("Total number of inversions: " + result); // Output: 6
    }
}


// Approach 2: Merge Sort (O(N log N) Time Complexity)
  
// The brute-force approach has a time complexity of O(N^2), which is not efficient for large arrays. 
//   To optimize this, we can use a modified merge sort algorithm that counts inversions while sorting the array.

// Merge Sort inherently works by splitting the array into halves and sorting them individually before merging them back together. 
//During the merge step, if an element in the right half is smaller than an element in the left half, then there are inversions for each element left in the left half.

// Here's how to implement the optimized approach:

public class Solution {
    public static int countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid + 1, right);
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left, swaps = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                swaps += (mid + 1) - (left + i);
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        int result = countInversions(arr);
        System.out.println("Total number of inversions: " + result); // Output: 6
    }
}
Explanation:
1. Merge Sort: The array is divided into two halves recursively until we reach single elements (base case).
2. Merge and Count: While merging two sorted halves, we count how many times an element from the right array needs to be placed before elements from the left array. Each such case represents inversions equal to the number of remaining elements in the left array.
3. Efficiency: The time complexity is O(N log N), making this approach efficient for large arrays.
Conclusion:
The brute-force approach is simple but only suitable for small arrays due to its O(N^2) time complexity. For larger arrays,
the merge sort-based approach is far more efficient with a time complexity of O(N log N).






