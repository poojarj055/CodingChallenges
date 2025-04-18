// 885. Spiral Matrix III
// You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, 
//   and the southeast corner is at the last row and column.

// You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, 
//   we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.

// Return an array of coordinates representing the positions of the grid in the order you visited them.

// Input: rows = 1, cols = 4, rStart = 0, cStart = 0
// Output: [[0,0],[0,1],[0,2],[0,3]]
// Example 2:
// Input: rows = 5, cols = 6, rStart = 1, cStart = 4
// Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] newArr = new int[rows * cols][2];
        int index = 0;
        int r = rStart, c = cStart;
        int steps = 1;

        newArr[index++] = new int[]{r, c};

        while (index < rows * cols) {
            // move right
            for (int i = 0; i < steps; i++) {
                c++;
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    newArr[index++] = new int[]{r, c};
                }
            }
            // move down
            for (int i = 0; i < steps; i++) {
                r++;
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    newArr[index++] = new int[]{r, c};
                }
            }

            steps++;

            // move left
            for (int i = 0; i < steps; i++) {
                c--;
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    newArr[index++] = new int[]{r, c};
                }
            }
            // move up
            for (int i = 0; i < steps; i++) {
                r--;
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    newArr[index++] = new int[]{r, c};
                }
            }

            steps++;
        }

        return newArr;
    }
}


//Explanation

### 🔄 **Goal:**
Return the coordinates of all cells in a `rows x cols` matrix starting from `(rStart, cStart)` in a **spiral order**.

---

### 🚶‍♂️**How it works:**

1. **Initialize**:
   - `newArr`: Stores all visited coordinates.
   - `r`, `c`: Current position (starts at `rStart`, `cStart`).
   - `steps`: Number of steps to take in each direction (starts at 1).
   - `index`: Tracks how many cells have been added to `newArr`.

2. **Add starting point** to `newArr`.

3. **Spiral Movement** (repeat until all cells are visited):
   - Move **right** → `c++`
   - Move **down** → `r++`
   - Increase `steps` by 1
   - Move **left** → `c--`
   - Move **up** → `r--`
   - Increase `steps` again

4. **Boundary Check**:
   - Only add coordinates to `newArr` **if inside** the matrix bounds.

---

### 🧭 Direction Pattern:
Right → Down → Left → Up → (repeat, with more steps)

---

Let me know if you want a diagrammatic walkthrough too!

