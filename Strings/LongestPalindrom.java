// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
// Letters are case sensitive, for example, "Aa" is not considered a palindrome.
// Example 1:

// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
// Example 2:

// Input: s = "a"
// Output: 1
// Explanation: The longest palindrome that can be built is "a", whose length is 1.

class Solution {
    public int longestPalindrome(String s) {
     HashMap<Character, Integer> map=new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
     int ans=0;
     int count=0;
    for(int freq:map.values()){
            if(freq%2==0){
                ans=ans+freq;
            }
            else{
                ans=ans+freq-1;
                count=1;
            }
    }
    return ans + count;
    

    }
}


Explanation:
// Count character frequencies using a HashMap.
// Iterate through the HashMap values:
// If a frequency is even, add it completely to ans.
// If a frequency is odd, add (freq - 1) to ans (to make it even) and keep track of count = 1 (indicating we can use one odd character in the center).
// Return ans + count to account for a central odd character if available.
// This solution runs in O(N) time complexity, where N is the length of the string.
