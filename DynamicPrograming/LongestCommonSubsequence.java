// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing 
//the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

// Example 1:

// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.
// Example 2:

// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc" and its length is 3.
// Example 3:

// Input: text1 = "abc", text2 = "def"
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.
 

// Constraints:

// 1 <= text1.length, text2.length <= 1000
// text1 and text2 consist of only lowercase English characters.
 
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
      Integer cache[][]=new Integer[text1.length()][text2.length()];
      return longestCommonSubsequenceRecur(text1,text2,0,0,cache);
    }
    int longestCommonSubsequenceRecur(String s1,String s2,int i1, int i2, Integer cache[][]){
        if(i1>s1.length()-1 || i2>s2.length()-1) return 0;

        if(cache[i1][i2]!=null){
            return cache[i1][i2];
        }

        int mov1=0, mov2=0;
        if(s1.charAt(i1)==s2.charAt(i2))
        {
            return 1+longestCommonSubsequenceRecur(s1, s2, i1+1, i2+1,cache);
        }
        else{
            mov1=longestCommonSubsequenceRecur(s1, s2, i1+1, i2, cache);
            mov2=longestCommonSubsequenceRecur(s1, s2, i1, i2+1, cache);
        }
        cache[i1][i2]= Math.max(mov1,mov2);
        return cache[i1][i2];
    }
}
