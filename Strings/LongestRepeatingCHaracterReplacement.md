You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


```
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // Frequency of each character
        int left = 0, maxFreq = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--; // Shrink window
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

```

 Let's break down the **Sliding Window** approach used in your Java code for **Longest Repeating Character Replacement** and do a **dry run** with an example.

---

## **💡 Key Concept of Sliding Window Approach**
- We maintain a **window (substring)** that contains at most `k` replacements.
- We track the **most frequent character** in the window (`maxFreq`).
- If the number of characters that need to be replaced in the window (`window_length - maxFreq`) exceeds `k`, **shrink the window** from the left.
- Keep updating the **maximum valid window size**.

---

## **📌 Dry Run with Example**
### **Example Input:**
```java
s = "AABABBA", k = 1
```

---

### **Initial State**
| Variable | Value | Description |
|----------|--------|-------------|
| `count`  | `[0, 0, ..., 0]` (size 26) | Array to track character frequency |
| `left`   | `0` | Left pointer of sliding window |
| `maxFreq` | `0` | Maximum frequency of a single character in the window |
| `maxLength` | `0` | Maximum valid window size found |

---

### **Step-by-Step Execution**
#### **Expanding the Window (Right Pointer Moves Right)**
#### **1️⃣ Right = 0 (Character: 'A')**
```java
count['A' - 'A']++; // count[0]++
maxFreq = max(0, count['A' - 'A']) = 1
window_size = right - left + 1 = 1
```
✅ Condition `(window_size - maxFreq) <= k` holds → **valid substring**.

| Left | Right | Window | maxFreq | window_size | maxLength |
|------|------|---------|---------|------------|-----------|
| 0    | 0    | `"A"`  | 1       | 1          | 1 |

---
#### **2️⃣ Right = 1 (Character: 'A')**
```java
count['A' - 'A']++; // count[0]++
maxFreq = max(1, count['A' - 'A']) = 2
window_size = 2
```
✅ Condition holds → **valid substring**.

| Left | Right | Window | maxFreq | window_size | maxLength |
|------|------|---------|---------|------------|-----------|
| 0    | 1    | `"AA"` | 2       | 2          | 2 |

---
#### **3️⃣ Right = 2 (Character: 'B')**
```java
count['B' - 'A']++; // count[1]++
maxFreq = max(2, count['B' - 'A']) = 2
window_size = 3
```
✅ Condition holds → **valid substring**.

| Left | Right | Window | maxFreq | window_size | maxLength |
|------|------|---------|---------|------------|-----------|
| 0    | 2    | `"AAB"` | 2       | 3          | 3 |

---
#### **4️⃣ Right = 3 (Character: 'A')**
```java
count['A' - 'A']++; // count[0]++
maxFreq = max(2, count['A' - 'A']) = 3
window_size = 4
```
✅ Condition holds → **valid substring**.

| Left | Right | Window | maxFreq | window_size | maxLength |
|------|------|---------|---------|------------|-----------|
| 0    | 3    | `"AABA"` | 3       | 4          | 4 |

---
#### **5️⃣ Right = 4 (Character: 'B')**
```java
count['B' - 'A']++; // count[1]++
maxFreq = max(3, count['B' - 'A']) = 3
window_size = 5
```
✅ Condition holds → **valid substring**.

| Left | Right | Window | maxFreq | window_size | maxLength |
|------|------|---------|---------|------------|-----------|
| 0    | 4    | `"AABAB"` | 3       | 5          | 5 |

---
#### **6️⃣ Right = 5 (Character: 'B')**
```java
count['B' - 'A']++; // count[1]++
maxFreq = max(3, count['B' - 'A']) = 3
window_size = 6
(window_size - maxFreq) = 6 - 3 = 3 > k
```
❌ **Condition fails** → **Shrink window** (move `left` pointer).
```java
count['A' - 'A']--; // count[0]--
left++;
```
✅ **Valid substring after shrinking**.

| Left | Right | Window | maxFreq | window_size | maxLength |
|------|------|---------|---------|------------|-----------|
| 1    | 5    | `"ABABB"` | 3       | 5          | 5 |

---
#### **7️⃣ Right = 6 (Character: 'A')**
```java
count['A' - 'A']++; // count[0]++
maxFreq = max(3, count['A' - 'A']) = 3
window_size = 6
(window_size - maxFreq) = 6 - 3 = 3 > k
```
❌ **Condition fails** → **Shrink window** again.

```java
count['A' - 'A']--; // count[0]--
left++;
```
✅ **Valid substring after shrinking**.

| Left | Right | Window | maxFreq | window_size | maxLength |
|------|------|---------|---------|------------|-----------|
| 2    | 6    | `"BABBA"` | 3       | 5          | 5 |

---
### **Final Answer:**
📌 **The longest substring after k replacements is of length `4`**.

---

## **🔍 Key Takeaways**
1. **Expanding the window:**  
   - Keep adding characters to the window.
   - Update the frequency of characters.
   - Track `maxFreq` (the most frequent character in the window).

2. **Checking Validity:**  
   - If `(window_size - maxFreq) > k`, then **shrink the window** by moving `left` forward.

3. **Updating Result:**  
   - Keep track of the **maximum window size** found.

---

## **⏳ Time Complexity Analysis**
- We traverse the string **once** with `right` pointer **O(n)**.
- The `left` pointer also moves at most **O(n)** times.
- Since each character is processed at most twice, the **overall time complexity is O(n)**.

## **💾 Space Complexity**
- We use an array `count[26]` of **fixed size**, so **O(1) space**.

---

### **🚀 Final Thoughts**
✅ **Why is this efficient?**
- This uses **Sliding Window** to process each character at most twice, making it **O(n) optimal**.
- The **greedy approach** ensures we always check the best possible answer at each step.

Let me know if anything is unclear! 😊 🚀
