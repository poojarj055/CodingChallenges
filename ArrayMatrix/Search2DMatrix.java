// 74. Search a 2D Matrix
// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.
// You must write a solution in O(log(m * n)) time complexity.
// Example 1:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true
// Example 2:

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false
//O(n*m) Brute Force
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
//O(log n*m)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=m*n-1;
        
        while(left<=right){
            int mid=(left+right)/2;
            int i = mid / n;  
            int j = mid % n; 

            if(target == matrix[i][j]) {
                return true;
            } else if (target<matrix[i][j]) {
                right=mid-1;
            } else { 
                left=mid+1;
            }
        }
        return false;
    }
}


// Logic in Simple Steps:
// Convert 2D to 1D Indexing:
// Treat the 2D matrix like a 1D array with length m * n.
// Use mid / n to get the row, and mid % n to get the column.

// Binary Search:
// Do binary search from index 0 to m*n - 1.
// At each mid, get the actual value using matrix[i][j].
// Compare it with target and move left or right accordingly.
// Return true if found, else false.
