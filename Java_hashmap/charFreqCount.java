// Problem statement
// You are given a string 'S' of length 'N', you need to find the frequency of each of the characters from ‘a’ to ‘z’ in the given string.
// Example :
// Given 'S' : abcdg
// Then output will be : 1 1 1 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 

import java.util.*;

public class Solution {
    public static int[] findFrequency(String S) {
        int[] result = new int[26];
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Initialize the map with characters from 'a' to 'z'
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, 0);
        }
        
        // Count the frequency of each character in the string
        for (int j = 0; j < S.length(); j++) {
            char ch = S.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
        }
        
        // Populate the result array with the frequency from the map
        for (int k = 0; k < 26; k++) {
          //This line is used to convert an index k (which ranges from 0 to 25) into the corresponding lowercase alphabet character ('a' to 'z')
            char c = (char) ('a' + k);
            result[k] = map.getOrDefault(c, 0);
        }
        
        return result;
    }
}



Time Complexity: O(n)
O(n), where n
n is the length of the string S.
Space Complexity: O(1)
The result array takes O(1) space because it always has 26 elements.
The map takes O(1) space because it stores at most 26 key-value pairs (for characters 'a' to 'z').
```````````````````````````````````````````````````````````````````
Steps:
1. Initialize Result Array:
Create an array result of size 26 to store the frequencies of each letter.
2. Initialize HashMap:
Create a HashMap called map to store the frequencies of each character in the string S.
3. Fill HashMap with Initial Zero Values:
Initialize the map with each character from 'a' to 'z' mapped to 0.
4. Count Frequencies:
Iterate through each character in the string S.
5. If the character is a lowercase letter, update its count in the map.
6. Transfer Frequencies to Result Array:
Iterate through the indices 0 to 25, corresponding to characters 'a' to 'z'.
For each index k, convert it to the corresponding character c.
Get the frequency of c from the map and store it in the result array.
`````````````````````````````````````````````````````````````````````
Adding k to 'a':
When you add an integer to a character in Java, it first converts the character to its ASCII value.
('a' + k):
For example, if k is 0, it becomes 97 + 0 which is 97 (the ASCII value of 'a').
If k is 1, it becomes 97 + 1 which is 98 (the ASCII value of 'b').
If k is 2, it becomes 97 + 2 which is 99 (the ASCII value of 'c').
This pattern continues up to k = 25, which becomes 97 + 25 which is 122 (the ASCII value of 'z').
Casting to char:
The result of ('a' + k) is an integer. To convert it back to a character, we cast it to char.
(char) ('a' + k):
This converts the resulting integer back into the corresponding character.
