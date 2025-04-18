Given an m x n matrix, return all elements of the matrix in spiral order.
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         // rowstart, colstart, rowend, colend
        int rowStart=0;
        int colStart=0;
        int rowEnd=matrix.length -1;
        int colEnd=matrix[0].length-1;
        List<Integer> list=new ArrayList<Integer>();
       while(rowStart<=rowEnd && colStart<=colEnd){
        //row trsaverse from row[i] to colend
        for(int i=colStart;i<=colEnd;i++){
            list.add(matrix[rowStart][i]);
        }
        rowStart++;
        //column traverse from colend to rowend
        for (int i = rowStart; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
        //row traverse from rownend to rowstart
        if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    list.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
        //col traverse from rowEnd to rowStart in reverse
        if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);
                }
                colStart++;
            }
       }
       return list;
    }
}


///Explanation

This method returns a list of elements from a 2D matrix in **spiral order** (clockwise).

### ✅ How it works:
- It uses four pointers:
  - `rowStart` and `rowEnd` for top and bottom rows
  - `colStart` and `colEnd` for left and right columns
- In each loop, it traverses:
  1. **Top row →** (left to right)
  2. **Right column ↓** (top to bottom)
  3. **Bottom row ←** (right to left, if rows remain)
  4. **Left column ↑** (bottom to top, if columns remain)
- After each step, it **shrinks the boundary** inward.

### ⏹️ Loop ends when all layers are visited.

Let me know if you want a visual diagram or dry run with an example!
