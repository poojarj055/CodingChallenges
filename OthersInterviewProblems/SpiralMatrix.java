import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static List<Integer> printSpiral(int[][] mat) {
        
        // Define ans list to store the result.
        List<Integer> ans = new ArrayList<>();
        
        int n = mat.length; // no. of rows
        int m = mat[0].length; // no. of columns
        
        // Initialize the pointers required for traversal.
        int top = 0, left = 0, bottom = n - 1, right = m - 1;

        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right) {

            // For moving left to right
            for (int i = left; i <= right; i++)
                ans.add(mat[top][i]);

            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++)
                ans.add(mat[i][right]);

            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(mat[bottom][i]);

                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(mat[i][left]);

                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
        //Matrix initialization.
        int[][] mat = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}};
        
        List<Integer> ans = printSpiral(mat);

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }

        System.out.println();
    }
}



``````````````````````````````````````````````````````````````````````
1. In each outer loop traversal print the elements of a square in a clockwise manner.
2. Print the top row, i.e. Print the elements of the top row from column index left to right and increase the count of the top so that it will move to the next row.
3. Print the right column, i.e. Print the rightmost column from row index top to bottom and decrease the count of right.
4. Print the bottom row, i.e. if top <= bottom, then print the elements of a bottom row from column right to left and decrease the count of bottom
5. Print the left column, i.e. if left <= right, then print the elements of the left column from the bottom row to the top row and increase the count of left.
6. Run a loop until all the squares of loops are printed.


