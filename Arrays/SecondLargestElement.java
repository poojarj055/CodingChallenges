//https://www.naukri.com/code360/problems/day-8-:-second-largest-element-in-the-array_873375?leftPanelTabValue=SUBMISSION

import java.util.*;

public class SecondLargestElement {

    public static int findSecondLargest(int n, int[] arr) {
        if (n < 2) return -1; // If there are less than 2 elements, return -1 as there's no second largest

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest; // Update secondLargest to previous largest
                largest = arr[i]; // Update largest to current element
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i]; // Update secondLargest if current element is greater than current secondLargest and not equal to largest
            }
        }
		 if (secondLargest == Integer.MIN_VALUE) return -1;
        return secondLargest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt(); // Read number of test cases
        while (testCase > 0) {
            int n = sc.nextInt(); // Read size of array
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt(); // Read elements of array
            }
            int result = findSecondLargest(n, arr); // Compute second largest element
            System.out.println(result); // Print the result
            testCase--;
        }
        sc.close(); // Close scanner
    }
}
