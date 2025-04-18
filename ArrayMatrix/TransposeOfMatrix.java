// Given a 2D integer array matrix, return the transpose of matrix.

// The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices
 

// Example 1:

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[1,4,7],[2,5,8],[3,6,9]]
// Example 2:

// Input: matrix = [[1,2,3],[4,5,6]]
// Output: [[1,4],[2,5],[3,6]]

//Code (for any matrix, square or rectangular):


class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;        // number of rows
        int m = matrix[0].length;     // number of columns

        int[][] result = new int[m][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}


---

### 🔁 Example

**Input:**
```java
[
 [1, 2, 3],
 [4, 5, 6]
]
```

**Output (transpose):**
```java
[
 [1, 4],
 [2, 5],
 [3, 6]
]
```

---
