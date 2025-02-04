// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"

// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.


class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        char [] word1=strs[0].toCharArray();
        char [] word2=strs[strs.length-1].toCharArray();
        String ans="";
        for(int i=0;i<word1.length;i++)
        {
            if(word1[i]!=word2[i]){
                break;
            }
            ans=ans+word1[i];
        }
        return ans;
    }
}


explanation:
first sort the given string array elements, this will give the longest word at last and shortest word in begining 
now just comparae these 2 words character one by one, once you find the element is non-matching break the loop and store the ans to return
  

