// Given a 0-indexed m x n integer matrix matrix, create a new 0-indexed matrix called answer. Make answer equal to matrix, 
//   then replace each element with the value -1 with the maximum element in its respective column.
// Return the matrix answer.

// Example 1:
// Input: matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
// Output: [[1,2,9],[4,8,6],[7,8,9]]
// Explanation: The diagram above shows the elements that are changed (in blue).
// - We replace the value in the cell [1][1] with the maximum value in the column 1, that is 8.
// - We replace the value in the cell [0][2] with the maximum value in the column 2, that is 9.
// Example 2:


// Input: matrix = [[3,-1],[5,2]]
// Output: [[3,2],[5,2]]
// Explanation: The diagram above shows the elements that are changed (in blue).

class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        
        int[][] answer=new int[m][n];
        int[] col=new int[n];
      
      //This loop finds the max of each column (ignoring -1) and stores it in col[].
        for(int j=0;j<n;j++){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<m;i++){
                if (matrix[i][j] != -1) {
                    max = Math.max(max, matrix[i][j]);
                }
            }
            col[j]=max;
        }
      
//It copies original values unless it's -1, in which case it replaces it with the column max from col[].
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]!=-1){
                answer[i][j]=matrix[i][j];
                }
                else{
                    answer[i][j]=col[j];
                }
            }
        }
        return answer;
    }
}

//Time and space complexity: O(m × n)
Input:
[
  [3, -1, 7],
  [5, 2, -1],
  [-1, 4, 9]
]

Column maxes:
- Col 0: max(3,5) = 5 (ignores -1)
- Col 1: max(2,4) = 4
- Col 2: max(7,9) = 9

Output:
[
  [3, 4, 7],
  [5, 2, 9],
  [5, 4, 9]
]






