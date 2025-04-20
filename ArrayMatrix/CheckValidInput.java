// An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).
// Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.
// Example 1:
// Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
// Output: true
// Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
// Hence, we return true.
// Example 2:
// Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
// Output: false
// Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
// Hence, we return false.
// Constraints:
// n == matrix.length == matrix[i].length
// 1 <= n <= 100


class Solution {
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            Set<Integer> rowSet=new HashSet<>();
            Set<Integer> colSet=new HashSet<>();
            for(int j=0;j<n;j++){
                int rowVal=matrix[i][j];
                int colVal=matrix[j][i];
                if(!rowSet.add(rowVal)) return false;
                if(rowVal<1 || rowVal>n) return false;
                if(!colSet.add(colVal)) return false;
                if(colVal<1 || colVal>n) return false;
            }
        }
        return true;
    }
}

//Explanation
You need a new Set for every row and every column.
Check if all values from 1 to n are present and unique in each row/column.
Use !rowSet.add(val) instead of contains() to detect duplicates quickly.


Complexity Type | Value
Time Complexity | O(n^2)
Space Complexity | O(n)  
