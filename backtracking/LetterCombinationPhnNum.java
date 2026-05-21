// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
//   Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = "2"
// Output: ["a","b","c"]
 

// Constraints:

// 1 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].


class Solution {
    private static final String[] KEYPAD = {
        "",    "",    "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits==null || digits.length()==0) return result;
        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }
    public void backtrack(List<String> result, String s, int index, StringBuilder current){
        if(index==s.length()){
            result.add(current.toString());
            return;
        }
        String letters=KEYPAD[s.charAt(index)-'0'];
        for(char c:letters.toCharArray()){
            current.append(c);
            backtrack(result, s, index+1, current);
            current.deleteCharAt(current.length()-1);
        }
    }
}
