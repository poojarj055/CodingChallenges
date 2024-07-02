//https://www.naukri.com/code360/problems/add-one-to-number_13863419?challengeSlug=7-day-beginners-challenge-3&interviewProblemRedirection=true&leftPanelTabValue=SUBMISSION

import java.util.* ;
import java.io.*; 
public class Solution
{
public static ArrayList<Integer> addOneToNumber(ArrayList<Integer> arr)
    {

 // Remove leading zeros
        while (arr.size() > 1 && arr.get(0) == 0) {
            arr.remove(0);
        }
 // initialize an index (digit of units) 
    int index= arr.size() - 1; 

      //Handle Carry
      // This loop iterates from the last digit to the first digit. If a digit is 9,
      // it sets it to 0 and moves to the previous digit, simulating the carry-over effect of addition.
    while (index >= 0 && arr.get(index) == 9){ 
      arr.set(index, 0); 
      index -= 1; 
    } 


 // If all digits were 9, the index becomes negative, indicating an overflow (e.g., 999 + 1 = 1000). The first digit is set to 1, and an extra 0 is added at the end.
    if (index < 0){ 
      // insert an one at the beginning of the array 
      arr.set(0, 1); 
      //Add one extra zero at the end of the array 
      arr.add(arr.size(),0); 
  
    } 
        
    // else increment the value at [index] 
    else
      arr.set(index, arr.get(index) + 1); 

      return arr;
  
    }
}
