// Given two strings s and t, determine if they are isomorphic.
// Two strings s and t are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

// Example 1:

// Input: s = "egg", t = "add"

// Output: true

// Explanation:

// The strings s and t can be made identical by:

// Mapping 'e' to 'a'.
// Mapping 'g' to 'd'.
// Example 2:

// Input: s = "foo", t = "bar"

// Output: false

// Explanation:

// The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.


class Solution {
    public boolean isIsomorphic(String s1, String t1) {

    Map<Character,Character> s1Map=new HashMap<>();
    Map<Character,Character> t1Map=new HashMap<>();
   
    for(int i=0;i<s1.length();i++){
       char s=s1.charAt(i);
       char t=t1.charAt(i);
       if(s1Map.containsKey(s) && s1Map.get(s)!=t){
           return false;
       }
       if(t1Map.containsKey(t) && t1Map.get(t)!=s){
           return false;
       }
       s1Map.put(s,t);
       t1Map.put(t,s);
   }
   return true;
    }
}

