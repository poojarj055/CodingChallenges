//https://www.naukri.com/code360/problems/reverse-the-array_1230540?interviewProblemRedirection=true&search=reverse%20&leftPanelTabValue=SUBMISSION

import java.util.Scanner;

public class ReverseArray {

    public void reverseArr(int n, int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " "); // Print array elements with a space separator
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution solution = new Solution(); // Create an instance of Solution class
        solution.reverseArr(n, arr); // Call reverseArr method on the instance
        System.out.println(); // Print a new line after printing the reversed array
        sc.close(); // Close the Scanner
    }
}
