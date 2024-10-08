// Given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

// Return a string of the words in reverse order concatenated by a single space.

// Note that s may contain leading or trailing spaces or multiple spaces between two words. 
//The returned string should only have a single space separating the words. Do not include any extra spaces.

 

// Example 1:

// Input: s = "the sky is blue"
// Output: "blue is sky the"


Brute Force:
var reverseWords = function(s) {
    const strArray = s.split(/\s+/);
    let str="";
    for(let j=strArray.length -1;j>=0;j--){
         str=str+" "+strArray[j];
    }
    return str.trim();
};

Optimized Approach:
var reverseWords = function(s) {
     // Split the string by one or more spaces and filter out any empty strings
    const strArray = s.trim().split(/\s+/);
    // Reverse the array of words
    strArray.reverse();
    // Join the words with a single space and return the result
    return strArray.join(' ');
}
