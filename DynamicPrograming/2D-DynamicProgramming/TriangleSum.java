// Given a triangle array, return the minimum path sum to reach from top to bottom.

// For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

// Examples:

// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// Output: 11
// Explanation:
//      2
//    3 4
//   6 5 7
//  4 1 8 3
// The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11.
// Input: triangle = [[10]]
// Output: 10
// Constraint:
// 1 <= triangle.size() <= 200
// triangle[i].size() =  triangle[i-1].length + 1
// 1 <= triangle[i][j] <= 1000

class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        // Code here
       int height=triangle.size();
       int[][]cache=new int[height][height];
       for(int i=0;i<height;i++){
           Arrays.fill(cache[i],-1);
       }
       return minimumTotalRecur(triangle,0,0,cache);
    }
    int minimumTotalRecur(ArrayList<ArrayList<Integer>> triangle, int row, int col, int [][]cache){
        int n = triangle.size();
        if(row==n-1){
          return triangle.get(row).get(col);
        }
        if(cache[row][col]!=-1){
            return cache[row][col];
        }
        int right=minimumTotalRecur(triangle,row+1,col+1,cache);
        int bottom=minimumTotalRecur(triangle,row+1,col,cache);
        cache[row][col]=triangle.get(row).get(col)+ Math.min(right,bottom);
        return cache[row][col];
    }
}
