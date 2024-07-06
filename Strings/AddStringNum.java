// You are given two non-negative integers, ‘NUM1’ and ‘NUM2’, in the form of strings. Return the sum of both strings.

import java.util.* ;
import java.io.*; 
import java.math.BigInteger;

public class Solution {

    public static String stringConcatenation(String num1, String num2) {
        // Write your code here.
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);
        BigInteger sum = n1.add(n2);
        return sum.toString();
    }

}
