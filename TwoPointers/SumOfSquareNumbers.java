Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:

Input: c = 3
Output: false

---

### ✅ **Two-Pointer Approach:**

We start with two pointers:

* `a = 0` (start)
* `b = sqrt(c)` (end)

Then:

* If `a² + b² == c`: ✅ return `true`
* If the sum is **less than** `c`: move `a` forward to increase the sum.
* If the sum is **more than** `c`: move `b` backward to decrease the sum.

---

### ✅ Java Code (Two Pointers):

```java
class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long)Math.sqrt(c);

        while (a <= b) {
            long sum = a * a + b * b;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                a++;
            } else {
                b--;
            }
        }

        return false;
    }
}
```

---

### ⏱️ Time Complexity:

* **O(√c)** — We only check up to √c combinations, much faster than nested loops.

---

### 🔍 Example:

For `c = 5`:

* `a = 0`, `b = 2` → `0 + 4 = 4` → too small → `a++`
* `a = 1`, `b = 2` → `1 + 4 = 5` → ✅

---
