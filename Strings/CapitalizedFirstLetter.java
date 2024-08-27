// Problem statement
// You are given a string 'STR'. You have to convert the first alphabet of each word in a string to UPPER CASE.
// For example:
// If the given string 'STR' = ”I am a student of the third year” so you have to transform this string to ”I Am A Student Of The Third Year"
// Note:
// 'STR' will contains only space and alphabets both uppercase and lowercase. The words will be separated by space.


import java.util.* ;
import java.io.*; 
public class Solution{
	public static String convertString(String str) {
            // Write your code here
            String[] words = str.split(" ");
            String final_str="";
            for(String eachWord:words){
            final_str+=eachWord.substring(0, 1).toUpperCase() + eachWord.substring(1)+" ";
            }
            return final_str;
        }

}
