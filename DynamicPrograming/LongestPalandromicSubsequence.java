// Given a string s, find the longest palindromic subsequence's length in s.
// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
// Example 1:

// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".
// Example 2:

// Input: s = "cbbd"
// Output: 2
// Explanation: One possible longest palindromic subsequence is "bb".
 

// Constraints:

// 1 <= s.length <= 1000
// s consists only of lowercase English letters.

class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2=new StringBuilder(s).reverse().toString();
        int m=s.length();
        Integer cache[][]=new Integer[m+1][m+1];
        return lcsRecur(s, s2, 0, 0, cache);
    }
    int lcsRecur(String s1, String s2, int index1, int index2, Integer cache[][]){
        if(index1>s1.length()-1 || index2>s2.length()-1){
            return 0;
        }

        if(cache[index1][index2]!=null){
            return cache[index1][index2];
        }

        int mov1=0, mov2=0;
        if(s1.charAt(index1)==s2.charAt(index2)){
            return 1+ lcsRecur(s1, s2, index1+1, index2+1,cache);
        }
        else{
            mov1=lcsRecur(s1, s2, index1+1, index2,cache);
            mov2=lcsRecur(s1, s2, index1, index2+1,cache);
        }
        cache[index1][index2]= Math.max(mov1,mov2);
        return cache[index1][index2];
    }
}

