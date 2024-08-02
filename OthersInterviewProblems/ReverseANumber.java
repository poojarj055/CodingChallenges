// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21

class Solution {
    public int reverse(int x) {
      long rev = 0;
        int digit;

        while(x!=0){
            digit = x%10;
            rev  = rev *10+digit;
            x = x/10; 
        }
        if(rev>Integer.MAX_VALUE || rev<Integer.MIN_VALUE){
            return 0;  
    
        }
        return (int)rev;
}
}

````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````

The code reverses the digits of an input integer x while checking for overflow. By using a long variable for the reversed number, 
the code can detect overflow conditions before converting the result back to int. If an overflow is detected, it returns 0; otherwise, it returns the reversed number.

``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
