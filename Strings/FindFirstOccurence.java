// 28. Find the Index of the First Occurrence in a String
// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// Example 1:

// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.

Alright! This is a classic problem that can be efficiently solved using Java’s `String` methods.
In Java 8, we can use the `indexOf` method of the `String` class, which is a simple and efficient way to solve this problem! Let me show you how:

```java
class Solution {
    public int strStr(String haystack, String needle) {
        // Using indexOf() to find the first occurrence of needle in haystack
        return haystack.indexOf(needle);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(solution.strStr(haystack1, needle1)); // Output: 0

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(solution.strStr(haystack2, needle2)); // Output: -1
    }
}
```

### **How it Works:**
- **`indexOf(String str)`** method returns the index of the first occurrence of the specified substring, or **-1** if the substring is not found.
- The method handles edge cases like:
  - When `needle` is an empty string (returns 0 by default).
  - When `needle` is longer than `haystack` (returns -1).

### **Why Java 8 is cool here:**
- Java 8 introduced **lambda expressions** and **stream API**, but for this particular problem, the simple `indexOf` method does the trick perfectly!
- It’s clean, readable, and uses built-in optimized search.

**Want to try some edge cases?** Here are a few to think about:
- **Empty `needle`:** `strStr("hello", "")` should return `0`.
- **Needle not in haystack:** `strStr("hello", "world")` should return `-1`.
- **Needle longer than haystack:** `strStr("short", "longer")` should return `-1`.
