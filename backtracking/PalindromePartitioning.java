// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]
 

// Constraints:

// 1 <= s.length <= 16
// s contains only lowercase English letters.

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        backtrack(s, res, path, 0);
        return res;
    }
    public void backtrack(String s, List<List<String>> res, List<String> path, int index){
        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrom(s, index, i)){
                path.add(s.substring(index, i+1));
                backtrack(s, res, path, i+1);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrom(String s,int start, int end){
            while(start<=end){
                if(s.charAt(start++)!=s.charAt(end--)){
                    return false;
                }
            }
            return true;
    }
}
