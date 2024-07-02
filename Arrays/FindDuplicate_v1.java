import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
        Collections.sort(arr);
        int duplicate =0;
         for (int i = 0; i < arr.size() - 1; i++) {
           if (arr.get(i).equals(arr.get(i + 1))) {
                duplicate= arr.get(i); 
                break;
             }
        }

        return duplicate;

    }
}
