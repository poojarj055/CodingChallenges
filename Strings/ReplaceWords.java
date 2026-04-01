// In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. 
// For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".

// Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the 
//   root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.

// Return the sentence after the replacement.

 

// Example 1:

// Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
// Output: "the cat was rat by the bat"
// Example 2:

// Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
// Output: "a a b c"


class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> dictionarySet=new HashSet<>(dictionary);
        String word[]=sentence.split(" ");
        for(int i=0;i<word.length;i++){
            word[i]=getRoot(word[i], dictionarySet);
        }
        return String.join(" ", word);
    }
    public String getRoot(String word, HashSet<String> dictionary){
        for(int i=1;i<=word.length();i++){
            String prefix=word.substring(0,i);
                if(dictionary.contains(prefix)){
                        return prefix;
                }
        }
        return word;
    }
}
