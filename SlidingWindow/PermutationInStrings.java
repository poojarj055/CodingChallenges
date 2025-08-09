// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
// In other words, return true if one of s1's permutations is the substring of s2.
// Example 1:
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").
// Example 2:
// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false
// Constraints:
// 1 <= s1.length, s2.length <= 104
// s1 and s2 consist of lowercase English letters.


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> s1map = new HashMap<>();
        HashMap<Character, Integer> s2map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            s1map.put(c, s1map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            s2map.put(c, s2map.getOrDefault(c, 0) + 1);
        }

        if (s1map.equals(s2map)) return true;

        int left=0;
        for(int right=s1.length();right<s2.length();right++){
            s2map.put(s2.charAt(right),s2map.getOrDefault(s2.charAt(right),0)+1);
            char oldChar = s2.charAt(left);
            if (s2map.get(oldChar) == 1) {
                s2map.remove(oldChar);
            } else {
                s2map.put(oldChar, s2map.get(oldChar) - 1);
            }
            left++;
            if(s1map.equals(s2map)){
                return true;
            }
        }
        return false;
    }
}












--------------------------------------------

Great question! Let's break down the **time and space complexity** of the corrected `checkInclusion` solution using **HashMaps**.

---

### ⏱️ Time Complexity: **O(n)**

Where:
- \( n = \text{s2.length()} \)
- \( m = \text{s1.length()} \)

#### Breakdown:
- Building `s1map`: O(m)
- Building initial `s2map`: O(m)
- Sliding the window across `s2`: O(n - m)
  - Each step involves:
    - Adding one character: O(1)
    - Removing one character: O(1)
    - Comparing two maps: O(1) on average (since only 26 lowercase letters)

> **Total**: O(n), assuming constant-time map operations and fixed alphabet size.

---

### 🧠 Space Complexity: **O(1)**

Even though you're using two `HashMap<Character, Integer>`, the number of keys is limited to **26 lowercase English letters**.

So:
- `s1map` stores up to 26 entries
- `s2map` stores up to 26 entries

> **Total space**: O(1) — constant space for fixed alphabet

---

### ⚡ Summary

| Complexity Type | Value      | Notes                                  |
|-----------------|------------|----------------------------------------|
| Time            | O(n)       | Efficient sliding window               |
| Space           | O(1)       | Fixed-size maps for lowercase letters  |

---

Would you like to see how this compares to an array-based version using `int[26]` instead of HashMaps? It's even faster and cleaner!
