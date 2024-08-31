// Problem statement
// Reverse the given string word-wise. The last word in the given string should come at 1st place, the last-second word at 2nd place, and so on. Individual words should remain as it is.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 0 <= |S| <= 10^5
// where |S| represents the length of string, S.
// Sample Input 1:
// Welcome to Coding Ninjas
// Sample Output 1:
// Ninjas Coding to Welcome


import java.util.Scanner;

class Solution {

    static String reverseStringWordWise(String input) {
        // Write your code here
        String[] words = input.split(" ");
        String finaloutput="";
        // Print each word
       for(int s=words.length-1;s>=0;s--){
            finaloutput=finaloutput+words[s]+" ";
       }
       return finaloutput;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String ans = reverseStringWordWise(input);
        System.out.println(ans);
    }
}
