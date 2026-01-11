// You are given a positive integer num, return true if num is a perfect square or false otherwise.

// A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

// You must not use any built-in library function, such as sqrt.

// Example 1:

// Input: num = 16

// Output: true
// Explanation: We return true because 4 * 4 = 16 and 4 is an integer.

// Example 2:

// Input: n = 15

// Output: false
// Explanation: We return false because square root of 15 is not an integer.

// Constraints:
// 1 <= n <= ((2^31) - 1)


class Solution {
    public boolean isPerfectSquare(int num) {
        long left=1;
        long right=num;
        while(left<=right){
            long mid=left+(right-left)/2;
            long product=mid*mid;
            if(product==num){
                return true;
            }
            else if(product>num){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return false;
    }
}
