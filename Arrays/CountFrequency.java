// Given an Array Arr of N positive integers and an integer X. Return the frequency of X in the array.
// Example 1:

// Input:
// N = 5
// Arr = {1, 1, 1, 1, 1}
// X = 1
// Output: 
// 5
// Explanation: Frequency of 1 is 5.

class Solution{
    int findFrequency(int Arr[], int X){
        int counter=0;
       
        for(int i=0;i<Arr.length;i++)
        {
            if (Arr[i]==X)
            counter++;
        }
        
        return counter;
    }
}
