// Given two strings s1 and s2, find the length of the smallest string which has both s1 and s2 as its sub-sequences.
// Note: s1 and s2 can have both uppercase and lowercase English letters.

// Examples:

// Input: s1 = "geek", s2 = "eke"
// Output: 5
// Explanation: String "geeke" has both string "geek" and "eke" as subsequences.
// Input: s1 = "AGGTAB", s2 = "GXTXAYB"
// Output: 9
// Explanation: String "AGXGTXAYB" has both string "AGGTAB" and "GXTXAYB" as subsequences.
// Input: s1 = "geek", s2 = "ek"
// Output: 4
// Explanation: String "geek" has both string "geek" and "ek" as subsequences.
// Constraints:
// 1 ≤ s1.size(), s2.size() ≤ 500


class Solution {
    public static int minSuperSeq(String s1, String s2) {
        // code here
        int m=s1.length();
        int n=s2.length();
        Integer cache[][]=new Integer[m+1][n+1];
        int len=minSuperSeqRecur(s1, s2, 0, 0, cache);
        return (m+n) -len;
    }
    static int minSuperSeqRecur(String s1, String s2,int index1, int index2,Integer cache[][]){
        if(index1>s1.length()-1 || index2>s2.length()-1){
            return 0;
        }
        
        if(cache[index1][index2]!=null){
            return cache[index1][index2];
        }
        
        int mov1=0, mov2=0;
        if(s1.charAt(index1)==s2.charAt(index2)){
            return 1+ minSuperSeqRecur(s1, s2, index1+1, index2+1, cache);
        }
        else{
            mov1=minSuperSeqRecur(s1, s2, index1+1, index2, cache);
            mov2=minSuperSeqRecur(s1, s2, index1, index2+1, cache);
        }
        cache[index1][index2]= Math.max(mov1,mov2);
        return cache[index1][index2];
    }
}
