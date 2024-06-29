// modified approach with o(n)
import java.util.*;
public class Solution{  

    public static int findUnique(int[] arr){

  int unique = 0;
        
        for (int num : arr) {
            unique ^= num;
        }
        
        return unique;
    
    }
}
