// Given two sorted arrays of size n and m respectively, find their union. The Union of two arrays can be defined as the common and distinct elements in the two arrays. 
//   Return the elements in sorted order.

// Example 1:

// Input: 
// n = 5, arr1[] = {1, 2, 3, 4, 5}  
// m = 5, arr2 [] = {1, 2, 3, 6, 7}
// Output: 
// 1 2 3 4 5 6 7
// Explanation: 
// Distinct elements including both the arrays are: 1 2 3 4 5 6 7.

class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        Set<Integer> set=new TreeSet<>();
        for(int num:arr1){
            set.add(num);
        }
        for(int num:arr2){
            set.add(num);
        }
        ArrayList<Integer> result=new ArrayList<>(set);
        return result;
    }
}

Total space complexity is 
O(n+m) due to the TreeSet and ArrayList.
Time complexity:
O(nlogn)+O(mlog(n+m))


`````````````````
NOTE:

Set<String> set1 = new HashSet<>();       // Unordered, no duplicates
Set<String> set2 = new LinkedHashSet<>(); // Ordered by insertion, no duplicates
Set<String> set3 = new TreeSet<>();       // Sorted order, no duplicates
`````````````````


Another optimzed approach:
````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
import java.util.Arrays;

public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Pointers for arr1, arr2, and the merged array
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Merge arr1 and arr2 starting from the end
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }

        // Copy any remaining elements from arr2 (if any)
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }

        // No need to copy remaining elements from arr1 as they are already in place

        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 0, 0, 0};
        int[] arr2 = {2, 4, 6};
        int m = 3;
        int n = 3;

        int[] result = ninjaAndSortedArrays(arr1, arr2, m, n);
        System.out.println(Arrays.toString(result)); // Output: [1, 2, 3, 4, 5, 6]
    }
}

The time complexity is 
O(m+n) as we traverse both arrays only once. The space complexity is 
O(1) since we are modifying arr1 in place.

````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````

