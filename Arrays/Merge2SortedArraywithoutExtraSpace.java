//mergeTwoSortedArraysWithoutExtraSpace
// Problem statement
// Given two non-decreasing sorted arrays, ‘A’ and ‘B’, having ‘N’ and ‘M’ elements, respectively.

// You must merge these arrays, ‘A’ and ‘B’, into a sorted array without using extra space. Of all the 'N + M' sorted elements, array 'A' should contain the first 'N' elements, and array 'B' should have the last 'M' elements.

// Note:
// You must perform the merge operation in place and must not allocate any extra space to merge the two arrays.
// For example:
// When ‘N’ = 4, ‘A’ = {1, 4, 5, 7} and ‘M’ = 3, ‘B’ = {2, 3, 6}. 
// We can merge these two arrays into {1, 2, 3, 4, 5, 6, 7} (The elements of ‘A’ are {1, 2, 3, 4} ).
// Hence, the answer is {1, 2, 3, 4, 5, 6, 7}.





import java.util.*;

public class tUf {

    public static void merge(long[] arr1, long[] arr2, int n, int m) {

        // Declare 2 pointers:
        int left = n - 1;
        int right = 0;

        // Swap the elements until arr1[left] is
        // smaller than arr2[right]:
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        merge(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

}

````````````````````````````````````````````````````````````````````````````````````````````````````````````````
Swapping the elements:
----------------------
1. Purpose: To swap elements between arr1 and arr2 if an element in arr1 is greater than an element in arr2.
Process:
2. Compare the element in arr1 at index left with the element in arr2 at index right.
If arr1[left] is greater than arr2[right], swap them.
3. Move the left pointer to the left and the right pointer to the right.
4. Continue this process until arr1[left] is no longer greater than arr2[right] or until one of the pointers goes out of bounds



Sorting the individual array:
---------------------------- 
Purpose: After swapping, the arrays are not guaranteed to be fully sorted. Sorting them ensures that both arrays are individually sorted.
 


  
