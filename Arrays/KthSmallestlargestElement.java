// You are given an array ‘Arr’ consisting of ‘N’ distinct integers and a positive integer ‘K’. 
//Find out Kth smallest and Kth largest element of the array. It is guaranteed that K is not greater than the size of the array.
// Example:
// Let ‘N’ = 4,  ‘Arr’ be [1, 2, 5, 4] and ‘K’ = 3.  
// then the elements of this array in ascending order is [1, 2, 4, 5].  Clearly, the 3rd smallest and largest element of this array is 4 and 2 respectively.

import java.util.ArrayList;
import java.util.Collections;


public class Solution {
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {

        Collections.sort(arr);

        // Get the k-th smallest element (min)
        int min = arr.get(k-1);

        // Get the k-th largest element (max)
        int max = arr.get(n-k);

        // Prepare the result array
        ArrayList<Integer> result = new ArrayList<>();
        result.add(min);
        result.add(max);

        return result;
	}
}
