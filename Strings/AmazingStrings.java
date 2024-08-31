// Problem statement
// Given 3 Strings, check whether the 3rd string contains all the characters of string 1 and 2 in any order. If all the characters are present, print "YES" otherwise print "NO".
// There should not be any extra character and any missing character.
// The string s contains uppercase Latin letters only.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 1 <= n (Length of 1st & 2nd Strings) <= 100
// Sample Input 1 :
// SANTACLAUS
// DEDMOROZ
// SANTAMOROZDEDCLAUS
// Sample Output 1 :
// YES
// Sample Input 2 :
// PAPAINOEL
// JOULUPUKKI
// JOULNAPAOILELUPUKKI
// Sample Output 2 :
// NO

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the three strings
        String str1 = scanner.next();
        String str2 = scanner.next();
        String str3 = scanner.next();

        // Concatenate the first and second strings
        String combined = str1 + str2;

        // Convert the strings to character arrays and sort them
        char[] combinedArray = combined.toCharArray();
        char[] str3Array = str3.toCharArray();

        Arrays.sort(combinedArray);
        Arrays.sort(str3Array);

        // Compare the sorted arrays
        if (Arrays.equals(combinedArray, str3Array)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        // Close the scanner
        scanner.close();
    }
}
