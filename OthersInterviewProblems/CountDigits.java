// Given a number n. Count the number of digits in n which evenly divide n. Return an integer, total number of digits of n which divides n evenly.

// Note :- Evenly divides means whether n is divisible by a digit i.e. leaves a remainder 0 when divided.
 

// Examples :

// Input: n = 12
// Output: 2
// Explanation: 1, 2 when both divide 12 leaves remainder 0.


class Solution {
    static int evenlyDivides(int N) {
        int c = 0;
        int originalNumber = N; // Store the original number to use in the condition
        while (N > 0) {
            int r = N % 10;
            if (r != 0 && originalNumber % r == 0) {
                c++;
            }
            N = N / 10;
        }
        return c;
    }
}


`````````````````````````````````````````````````````````````````````````````````````````
Explanation:

Store the Original Number: Store the original value of N in originalNumber to use in the condition.
Check for Division by Zero: Ensure r is not zero before checking if it divides originalNumber evenly.
Check for Even Division: Use originalNumber % r == 0 to check if r is a divisor of originalNumber.
This way, you ensure that only digits that divide the number N evenly are counted.
````````````````````````````````````````````````````````````````````````````````````````````````````


