// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

// Example 1:

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
// Example 2:

// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
 

// Constraints:

// 1 <= s.length, p.length <= 3 * 104
// s and p consist of lowercase English letters.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        if (s.length() < p.length()) return indices;

        HashMap<Character, Integer> pmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();

        for (char c : p.toCharArray()) {
            pmap.put(c, pmap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < p.length(); i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (pmap.equals(smap)) {
            indices.add(0);
        }

        int left = 0;
        for (int right = p.length(); right < s.length(); right++) {
            char newChar = s.charAt(right);
            smap.put(newChar, smap.getOrDefault(newChar, 0) + 1);

            char toRemove = s.charAt(left);
            if (smap.get(toRemove) == 1) {
                smap.remove(toRemove);
            } else {
                smap.put(toRemove, smap.get(toRemove) - 1);
            }
            left++;

            if (pmap.equals(smap)) {
                indices.add(left);
            }
        }

        return indices;
    }
}
