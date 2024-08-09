// Problem statement
// Given an integer N, print all the prime numbers that lie in the range 2 to N (both inclusive).
// Print the prime numbers in different lines.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 1 <= N <= 100
// Sample Input 1:
// 9
// Sample Output 1:
// 2
// 3
// 5
// 7

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        /* Your class should be named Solution.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        printPrime(n);
    }

    public static void printPrime(int num) {
        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;  // 2 is the only even prime number
        if (n % 2 == 0) return false; // eliminate other even numbers

      //The loop checks only odd numbers up to the square root of n to determine if n is prime.
//This method is more efficient than checking all possible divisors up to n, reducing the number of operations needed to determine primality.

        for (int i = 3; i * i <= n; i += 2) { // check divisibility by odd numbers up to sqrt(n)
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}




