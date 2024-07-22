// Problem statement
// Given an ‘N’ x ‘M’ integer matrix, if an element is 0, set its entire row and column to 0's, and return the matrix. In particular, your task is to modify it in such a way that if a cell has a value 0 (matrix[i][j] == 0), then all the cells of the ith row and jth column should be changed to 0.
// You must do it in place.
// For Example:
// If the given grid is this:
// [7, 19, 3]
// [4, 21, 0]

// Then the modified grid will be:
// [7, 19, 0]
// [0, 0,  0]

import java.io.*;
import java.util.*;

public class Solution {
    public static void setZeros(int matrix[][]) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        // Arrays to keep track of which rows and columns need to be set to zero
        boolean[] rows = new boolean[numRows];
        boolean[] cols = new boolean[numCols];

        // Mark the rows and columns that contain zeros
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Set the marked rows to zero
        for (int i = 0; i < numRows; i++) {
            if (rows[i]) {
                for (int j = 0; j < numCols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set the marked columns to zero
        for (int j = 0; j < numCols; j++) {
            if (cols[j]) {
                for (int i = 0; i < numRows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
Explanation:
1. Determine Dimensions: Get the number of rows and columns using matrix.length and matrix[0].length.
2. Mark Rows and Columns: Iterate through the matrix and mark the rows and columns that should be set to zero in the rows and cols arrays.
3. Set Rows to Zero: Iterate through the rows array and set the entire row to zero if it is marked.
4. Set Columns to Zero: Iterate through the cols array and set the entire column to zero if it is marked.
Important Points:
1. Marking Phase: First pass through the matrix to mark the rows and columns that contain zeroes.
2. Setting Phase: Second pass to set the corresponding rows and columns to zero.
This ensures that you avoid the issue of modifying the matrix while still in the process of checking for zeroes.
```````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
