import java.util.*;

class Solution {
    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        // Use a hash set to store unique elements of the first array
        Set<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }

        // Use another hash set to store the intersection elements
        Set<Integer> intersection = new HashSet<>();
        for (int num : b) {
            if (setA.contains(num)) {
                intersection.add(num);
                setA.remove(num); // Remove the element to avoid counting duplicates
            }
        }

        // The size of the intersection set is the result
        return intersection.size();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3};

        int result = NumberofElementsInIntersection(a, b, a.length, b.length);
        System.out.println("Number of elements in the intersection: " + result); // Output: 3
    }
}
