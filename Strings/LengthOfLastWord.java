// Given a string s consisting of words and spaces, return the length of the last word in the string. 
// A word is a maximal substring consisting of non-space characters only.
// Example 1:

// Input: s = "Hello World"
// Output: 5
// Explanation: The last word is "World" with length 5.
// Example 2:

// Input: s = "   fly me   to   the moon  "
// Output: 4
// Explanation: The last word is "moon" with length 4.
// Example 3:

// Input: s = "luffy is still joyboy"
// Output: 6
// Explanation: The last word is "joyboy" with length 6.

Java 8 solution
------------------
class Solution {
    public int lengthOfLastWord(String s) {
        int lastwordLength=Arrays.stream(s.split("\\s+")).reduce((a,b)-> b ).map(String::length).orElse(0);
        return lastwordLength;
    }
}

More efficient alternative approach
------------------------------------
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();  // Remove leading & trailing spaces
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }
}



  
