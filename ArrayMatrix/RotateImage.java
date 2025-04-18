// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
// DO NOT allocate another 2D matrix and do the rotation.
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


//1st Approach: 4way swap
class Solution {
    public void rotate(int[][] matrix) {
    int n=matrix.length;
    for(int i=0;i<n/2;i++){
      for(int j=i;j<n-1-i;j++){
        int temp=matrix[i][j];
        //swap bottom left with top left
        matrix[i][j]=matrix[n-1-j][i];
        //swap bottom left to bottom right
        matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
        //swap bottom right with top right
        matrix[n-1-i][n-j-1] =matrix[j][n - 1 - i];
        //swap top right with top left
        matrix[j][n - 1 - i]=temp;
      }
    }
  }
}


// Time Complexity = O(n²)

//2nd Approach : transpose of matrix and reverse each row

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}

// Time Complexity = O(n²)

        
