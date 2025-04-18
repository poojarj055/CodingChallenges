// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.
// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: Check if first row has any zero
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: Check if first column has any zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step 3: Mark rows and columns that need to be zeroed
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 4: Zero matrix based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Zero out first row if needed
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 6: Zero out first column if needed
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}


//Explanation

### 🔍 Let's take an example matrix:

```txt
Input matrix:
[
  [1, 1, 1],
  [1, 0, 1],
  [1, 1, 1]
]
```

We need to set the entire **row 1** and **column 1** to 0s because `matrix[1][1] == 0`.

Expected output:
```txt
[
  [1, 0, 1],
  [0, 0, 0],
  [1, 0, 1]
]
```

Now let’s go step-by-step 👇

---

## 🧠 Code Explanation with Visuals

---

### 🔹 Step 1: Detect if the **first row** has any `0`

```java
for (int j = 0; j < n; j++) {
    if (matrix[0][j] == 0) {
        firstRowZero = true;
    }
}
```

- Row 0: `[1, 1, 1]` → No zero → `firstRowZero = false`

---

### 🔹 Step 2: Detect if the **first column** has any `0`

```java
for (int i = 0; i < m; i++) {
    if (matrix[i][0] == 0) {
        firstColZero = true;
    }
}
```

- Column 0: `[1, 1, 1]` → No zero → `firstColZero = false`

---

### 🔹 Step 3: Use **1st row and 1st column** to mark which rows & columns to zero

```java
for (int i = 1; i < m; i++) {
    for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
            matrix[i][0] = 0; // mark the row
            matrix[0][j] = 0; // mark the column
        }
    }
}
```

✅ `matrix[1][1] == 0`, so we mark:

- `matrix[1][0] = 0`
- `matrix[0][1] = 0`

Now matrix becomes:

```txt
[
  [1, 0, 1],   ← marked column 1
  [0, 0, 1],   ← marked row 1
  [1, 1, 1]
]
```

---

### 🔹 Step 4: Use the markers to set `0`s

```java
for (int i = 1; i < m; i++) {
    for (int j = 1; j < n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
            matrix[i][j] = 0;
        }
    }
}
```

We check for markers:
- For `matrix[1][1]`, row 1 and col 1 → marked → set to 0
- For `matrix[1][2]`, row 1 → marked → set to 0
- For `matrix[2][1]`, col 1 → marked → set to 0

Now the matrix becomes:

```txt
[
  [1, 0, 1],
  [0, 0, 0],
  [1, 0, 1]
]
```

---

### 🔹 Step 5 & 6: Set 0 in 1st row & col if needed

```java
if (firstRowZero) {
    for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
    }
}

if (firstColZero) {
    for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
    }
}
```

Since `firstRowZero` and `firstColZero` are `false`, no changes.

---

### ✅ Final Output:

```txt
[
  [1, 0, 1],
  [0, 0, 0],
  [1, 0, 1]
]
```

---

## 📦 Time and Space Complexity

- **Time:** `O(m * n)` → You visit each element a few times.
- **Space:** `O(1)` → You used the first row and column as markers (no extra matrix/array).
