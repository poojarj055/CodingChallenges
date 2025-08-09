// A string is good if there are no repeated characters.
// Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.
// Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
// A substring is a contiguous sequence of characters in a string.
// Example 1:

// Input: s = "xyzzaz"
// Output: 1
// Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
// The only good substring of length 3 is "xyz".
// Example 2:

// Input: s = "aababcabc"
// Output: 4
// Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
// The good substrings are "abc", "bca", "cab", and "abc".
// Constraints:

// 1 <= s.length <= 100
// s​​​​​​ consists of lowercase English letters.
// Seen this question in a real interview before?
// 1/5
// Yes

class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        int left=0;
        int count=0;
        for(int right=0;right<s.length();right++){
             char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if(right-left+1>3){
              char leftChar = s.charAt(left);
              map.put(leftChar, map.get(leftChar) - 1);
              if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
              left++;
            }
            if(right-left+1==3 && map.size()==3)
            {
                count++;
            }
        }
        return count;
    }
}

---------------------------O(n) solution:

class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            if (a != b && b != c && a != c) {
                count++;
            }
        }
        return count;
    }
}

