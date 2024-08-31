// Problem statement
// Write a program to input an integer N and print the sum of all its even digits and all its odd digits separately.
// Digits mean numbers, not the places! If the given integer is "13245", the even digits are 2 and 4, and the odd digits are 1, 3, and 5.


import java.util.Scanner;
class Solution {
	
	public static void main(String args[]) {
		
		// Write code here
		Scanner scanner = new Scanner(System.in);
        
        // Input integer N
        int N = scanner.nextInt();
        
        // Initialize sums for even and odd digits
        int evenSum = 0;
        int oddSum = 0;
        
        // Process each digit of N
        while (N > 0) {
            int digit = N % 10; // Get the last digit
            
            if (digit % 2 == 0) {
                evenSum += digit; // Add to evenSum if digit is even
            } else {
                oddSum += digit; // Add to oddSum if digit is odd
            }
            
            N = N / 10; // Remove the last digit from N
        }
        
        // Output the results
        System.out.println(evenSum + " " + oddSum);
        
        // Close the scanner
        scanner.close();
	}
}
