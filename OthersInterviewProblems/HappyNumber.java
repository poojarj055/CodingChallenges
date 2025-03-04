Given a number N find whether its a happy number or not. 
A number is called happy if it leads to 1 after a sequence of steps wherein each step, the number is replaced by the sum of squares 
  of its digit that is if we start with Happy Number and keep replacing it with digits square sum, we reach 1.

Example 1:

Input: 
N = 19
Output: 
1
Explanation:
19 is a Happy Number,
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
As we reached to 1, 
19 is a Happy Number.

class Solution { 
    static int isHappy(int N) { 
        // Create a HashSet to detect cycles
        HashSet<Double> set = new HashSet<>();
        
        while(true) {
            double sum = 0;
            
            // Calculate sum of squares of digits
            while(N != 0) {
                double pow = Math.pow(N % 10, 2);
                sum = sum + pow;
                N = N / 10;  // This line was missing in your code
            }
            
            // Check if we've reached 1 (happy number)
            if(sum == 1) {
                return 1;
            }
            
            // Check if we're in a cycle (not a happy number)
            if(set.contains(sum)) {
                return 0;
            }
            
            // Add current sum to HashSet and continue with next iteration
            set.add(sum);
            N = (int)sum;  // Update N for the next iteration
        }
    }
}
