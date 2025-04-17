// 2022. Convert 1D Array Into 2D Array
// Solved
// Easy
// Topics
// Companies
// Hint
// You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n. You are tasked with creating a 2-dimensional (2D) array with  m rows and n columns using all the elements from original.

// The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array, the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and so on.

// Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.

//brute-force

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m*n) return new int[0][0];
        int [][] newArr=new int[m][n];
        int l=m*n;
        int k=0;
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(k<l){
                newArr[i][j]=original[k];
                k++;
                }
            }
        }
        return newArr;
    }
}


// O(n) solution
//You can flatten the loop — iterate through the 1D array once and directly compute i and j for the 2D array using:

// i = k / n

// j = k % n

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[0][0];

        int[][] newArr = new int[m][n];

        for (int k = 0; k < original.length; k++) {
            int i = k / n;  // Row index
            int j = k % n;  // Column index
            newArr[i][j] = original[k];
        }
        return newArr;
    }
}



