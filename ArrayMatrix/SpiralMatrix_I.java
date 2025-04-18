// 59. Spiral Matrix II
// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
// Example 1:
// Input: n = 3
// Output: [[1,2,3],[8,9,4],[7,6,5]]
// Example 2:

// Input: n = 1
// Output: [[1]]
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] newMatrix=new int[n][n];
        int colStart=0;
        int colEnd=n-1;
        int rowStart=0;
        int rowEnd=n-1;
        int num=1;
        while(rowStart<=rowEnd && colStart <=colEnd){
            //row traverse right
            for(int i = colStart; i <= colEnd; i++){
                newMatrix[rowStart][i]=num++;
            }
            rowStart++;
            //column traverse bottom
            for(int i=rowStart;i<=rowEnd;i++){
                newMatrix[i][colEnd]=num++;
            }
            colEnd--;
            //row traverse left
            if(rowStart<=rowEnd){
            for(int i=colEnd;i>=colStart;i--){
                newMatrix[rowEnd][i]=num++;
            }
            rowEnd--;
            }
            if(colStart<=colEnd){
                for(int i=rowEnd;i>=rowStart;i--){
                    newMatrix[i][colStart]=num++;
                }
            colStart++;
            }
        }
        return newMatrix;
    }
}


//Explnation

Fill a square n x n matrix in spiral order starting from 1 to n².

Use 4 pointers (rowStart, rowEnd, colStart, colEnd) to define the boundaries.

In each loop:

Fill top row (→)

Fill right column (↓)

Fill bottom row (←)

Fill left column (↑)

Keep narrowing the bounds until the matrix is filled.
