// Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
// In one step, you can delete exactly one character in either string.
// Example 1:

// Input: word1 = "sea", word2 = "eat"
// Output: 2
// Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
// Example 2:

// Input: word1 = "leetcode", word2 = "etco"
// Output: 4
// Constraints:

// 1 <= word1.length, word2.length <= 500
// word1 and word2 consist of only lowercase English letters.


class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        Integer cache[][]=new Integer[m+1][n+1];
        int lcsLength= minDistanceRecur(word1, word2, 0, 0, cache);
        return (m + n) - (2 * lcsLength);
    }
    int minDistanceRecur(String word1, String word2, int index1, int index2, Integer[][]cache){
        if(index1>word1.length()-1 || index2>word2.length()-1){
            return 0;
        }
        
        if(cache[index1][index2]!=null){
            return cache[index1][index2];
        }
        int mov1=0, mov2=0;
        if(word1.charAt(index1)==word2.charAt(index2)){
            return 1+minDistanceRecur(word1, word2, index1+1, index2+1,cache);
        }
        else{
           mov1=minDistanceRecur(word1, word2, index1+1, index2,cache);
           mov2=minDistanceRecur(word1, word2, index1, index2+1,cache);
       }
        cache[index1][index2]= Math.max(mov1,mov2);
        return cache[index1][index2];
    }
}
