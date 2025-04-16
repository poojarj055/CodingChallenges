// you are given two strings s and t.

// String t is generated by random shuffling string s and then add one more letter at a random position.

// Return the letter that was added to t.

 

// Example 1:

// Input: s = "abcd", t = "abcde"
// Output: "e"
// Explanation: 'e' is the letter that was added.
// Example 2:

// Input: s = "", t = "y"
// Output: "y"


class Solution {
    public char findTheDifference(String s, String t) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: t.toCharArray()){
            if(!map.containsKey(c)||map.get(c)==0){
                return c;
            }
             map.put(c, map.get(c) - 1);
        }
        return ' ';

       
        }
}



// Explanation:
// Count frequencies of all characters in s using a HashMap.

// Iterate through t, and:

// If a character is not found in the map or its count is zero, it's the extra character.

// Otherwise, decrement its count.
