import java.util.HashMap;

public class Solution {
    public static boolean areIsomorphic(String str1, String str2) {
        // Write your code here.
        if(str1.length()!=str2.length()){
        return false;
        }
        HashMap<Character, Character> mapstr1 = new HashMap<>();
        HashMap<Character, Character> mapstr2 = new HashMap<>();

           for (int i = 0; i < str1.length(); i++) {
            char charstr1 = str1.charAt(i);
            char charstr2 = str2.charAt(i);
           


        if(mapstr1.containsKey(charstr1)){
//             charstr2: This is the current character in str2 that we are checking against.
// !=: This checks if the value retrieved from mapS (i.e., the character from str2 that 
//charstr1 is supposed to map to) is not equal to the current charstr2.
// return false;:
// If mapstr1.get(charstr1) != charstr2, it means the current mapping of charS to charstr2 is 
//inconsistent with the previous mappings. 
//Therefore, the strings cannot be isomorphic, and the function returns false
            if(mapstr1.get(charstr1)!=charstr2)
            return false;

        }
        else{
            mapstr1.put(charstr1,charstr2);
        }

        if(mapstr2.containsKey(charstr2)){
             if(mapstr2.get(charstr2)!=charstr1)
            return false;

        }
        else
        {
            mapstr2.put(charstr2, charstr1);
        }
       
     }
      return true;
    }
}
