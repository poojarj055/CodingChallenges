// Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// The matching should cover the entire input string (not partial).

 

// Example 1:

// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".
// Example 2:

// Input: s = "aa", p = "*"
// Output: true
// Explanation: '*' matches any sequence.
// Example 3:

// Input: s = "cb", p = "?a"
// Output: false
// Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

// Constraints:

// 0 <= s.length, p.length <= 2000
// s contains only lowercase English letters.
// p contains only lowercase English letters, '?' or '*'.



class Solution {

    public boolean isMatch(String str1, String str2) {
        Boolean[][] cache=new Boolean[str1.length()+1][str2.length()+1];
        return isMatchRecur(str1, str2, 0, 0, cache);
    }

    private boolean isMatchRecur(String str1, String str2, int index1, int index2, Boolean[][] cache) {
        if (str1.length() == index1 && str2.length() == index2) {
            return true;
        }

        if (str1.length() == index1) {
            while (index2 != str2.length()) {
                if (str2.charAt(index2) != '*') {
                    return false;
                }
                index2++;
            }
            return true;
        }

        if (str2.length() == index2) {
            return false;
        }

        if(cache[index1][index2]!=null){
            return cache[index1][index2];
        }

        if (str1.charAt(index1) == str2.charAt(index2)) {
            cache[index1][index2]= isMatchRecur(str1, str2, index1 + 1, index2 + 1,cache);
            return cache[index1][index2];
        }


        
        // str1: a-z
        // str2: a-z | * | ?

        if (str2.charAt(index2) == '?') {
            cache[index1][index2]= isMatchRecur(str1, str2, index1 + 1, index2 + 1,cache);
            return cache[index1][index2];
        }

        if (str2.charAt(index2) == '*') {
            // * -> 1 char
            // * -> MULTIPLE char

            boolean move1 = isMatchRecur(str1, str2, index1 + 1, index2 + 1,cache);
            boolean move2 = isMatchRecur(str1, str2, index1 + 1, index2,cache);
            boolean move3 = isMatchRecur(str1, str2, index1, index2 + 1,cache);

            cache[index1][index2]= move1 || move2 || move3;
            return cache[index1][index2];
        }

        return false;
    }
}
