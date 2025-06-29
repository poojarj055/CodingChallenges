// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
// You have the following three operations permitted on a word:
// Insert a character
// Delete a character
// Replace a character
// Example 1:
// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')
// Example 2:
// Input: word1 = "intention", word2 = "execution"
// Output: 5
// Explanation: 
// intention -> inention (remove 't')
// inention -> enention (replace 'i' with 'e')
// enention -> exention (replace 'n' with 'x')
// exention -> exection (replace 'n' with 'c')
// exection -> execution (insert 'u')
// Constraints:
// 0 <= word1.length, word2.length <= 500
// word1 and word2 consist of lowercase English letters.

class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int ans[][]=new int[m+1][n+1];
        for(int i=1;i<m+1;++i){
            ans[i][0]=i;
        }
        for(int j=1;j<n+1;++j){
            ans[0][j]=j;
        }
        for(int i=1;i<m+1;++i){
            for(int j=1;j<n+1;++j){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    ans[i][j]=ans[i-1][j-1];
                }
                else{
                    int top=ans[i-1][j];
                    int left=ans[i][j-1];
                    int topLeft=ans[i-1][j-1];
                    ans[i][j]=(Math.min(Math.min(top,left),topLeft))+1;
                }
            }
        }
        return ans[m][n];
    }
}

---------------------------------------------------------------------------------------
⏱️ Time Complexity: O(m * n)
You’re iterating over a 2D table of size (m+1) × (n+1), where:

m = word1.length()

n = word2.length()

Every cell ans[i][j] is filled based on constant-time operations (comparisons and Math.min()).

✅ So, total operations = (m + 1) × (n + 1) ⇒ simplified to O(m × n)


🧠 Space Complexity: O(m * n)
You’re storing the entire (m+1) × (n+1) table in memory to keep track of subproblem solutions.  

-----------------------------------------------------------------------------------------
Explanation
----------------
### 🧠 What’s the big idea?

We’re using **dynamic programming** to solve this efficiently by breaking the problem into subproblems and building up a solution using a table (`ans[][]`).

---

### 🧱 Step-by-Step Breakdown

```java
int m = word1.length();
int n = word2.length();
int[][] ans = new int[m + 1][n + 1];
```
- We define `m` and `n` as the lengths of the two input strings.
- `ans[i][j]` will store the minimum edit distance between:
  - The first `i` characters of `word1`
  - The first `j` characters of `word2`

---

### 🧹 Base Case Initialization

```java
for (int i = 0; i <= m; i++) {
    ans[i][0] = i;
}
for (int j = 0; j <= n; j++) {
    ans[0][j] = j;
}
```

- To convert from a string of length `i` to an **empty** string, we need `i` **deletions**.
- To convert an empty string to a string of length `j`, we need `j` **insertions**.

---

### 🔁 Main Dynamic Programming Loop

```java
for (int i = 1; i <= m; i++) {
    for (int j = 1; j <= n; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            ans[i][j] = ans[i - 1][j - 1]; // characters match, no change needed
        } else {
            ans[i][j] = Math.min(
                Math.min(ans[i - 1][j], ans[i][j - 1]), // delete or insert
                ans[i - 1][j - 1] // replace
            ) + 1;
        }
    }
}
```

- If characters match, no operation is needed.
- If they don’t:
  - `ans[i - 1][j]` → delete a character from `word1`
  - `ans[i][j - 1]` → insert a character into `word1`
  - `ans[i - 1][j - 1]` → replace a character

We pick the **minimum** of these and add 1 (for the operation just performed).

---

### ✅ Final Answer

```java
return ans[m][n];
```

The cell `ans[m][n]` contains the final result: **the minimum number of edits to transform `word1` into `word2`.**

---

### 🔍 Example

If `word1 = "horse"` and `word2 = "ros"`, the output would be `3`, since we can:

1. Replace 'h' with 'r'
2. Remove 'e'
3. Remove 's'

---
