// You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

// To perform a flood fill:

// Begin with the starting pixel and change its color to color.
// Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
// Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
// The process stops when there are no more adjacent pixels of the original color to update.
// Return the modified image after performing the flood fill.
// Example 1:
// Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2

// Output: [[2,2,2],[2,2,0],[2,0,1]]
// From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.

// Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.

// Example 2:
// Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0

// Output: [[0,0,0],[0,0,0]]
// The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.

class Solution {
    int rows;
    int cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image;

        rows = image.length;
        cols = image[0].length;

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Base case: out of bounds or not the original color
        if (r < 0 || c < 0 || r >= rows || c >= cols || image[r][c] != originalColor) {
            return;
        }

        // Fill the current cell with the new color
        image[r][c] = newColor;

        // Recursively call in all 4 directions
        dfs(image, r, c + 1, originalColor, newColor); // right
        dfs(image, r + 1, c, originalColor, newColor); // down
        dfs(image, r, c - 1, originalColor, newColor); // left
        dfs(image, r - 1, c, originalColor, newColor); // up
    }
}

