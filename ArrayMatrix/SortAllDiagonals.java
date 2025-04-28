// 1329. Sort the Matrix Diagonally
// A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column 
// and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], 
// where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

// Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
// Example 1:
// Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
// Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
// Example 2:

// Input: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
// Output: [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]


class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Process diagonals starting from the first column
        for (int row = m - 1; row >= 0; row--) {
            sortDiagonal(mat, row, 0, m, n);
        }

        // Process diagonals starting from the first row (excluding 0,0 because it's already done)
        for (int col = 1; col < n; col++) {
            sortDiagonal(mat, 0, col, m, n);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col, int m, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int r = row, c = col;

        // Step 1: Collect the diagonal
        while (r < m && c < n) {
            list.add(mat[r][c]);
            r++;
            c++;
        }

        // Step 2: Sort the diagonal
        Collections.sort(list);

        // Step 3: Put back the sorted values
        r = row;
        c = col;
        int idx = 0;
        while (r < m && c < n) {
            mat[r][c] = list.get(idx++);
            r++;
            c++;
        }
    }
}
