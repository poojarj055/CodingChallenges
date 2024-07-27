// Given a increasing sorted rotated array arr of distinct integers. The array is right-rotated k times. Find the value of k.
// Let's suppose we have an array arr = [2, 4, 6, 9], so if we rotate it by 2 times so that it will look like this:
// After 1st Rotation : [9, 2, 4, 6]
// After 2nd Rotation : [6, 9, 2, 4]

// Examples:

// Input: arr = [5, 1, 2, 3, 4]
// Output: 1
// Explanation: The given array is 5 1 2 3 4. The original sorted array is 1 2 3 4 5. We can see that the array was rotated 1 times to the right.


class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int max=Integer.MAX_VALUE, index=-1;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)<max){
                max=arr.get(i);
                index=i;
            }
        }
        return index;
    }
}


````````````````````````````````````````````````````````````````````````````
The method iterates through the list to find the smallest element and its index.
The index of the smallest element represents the number of rotations performed on the originally sorted array.
This is a linear-time solution (O(n)) for finding the rotation count.
``````````````````````````````````````````````````````````````````````````````````````````````````````````````


