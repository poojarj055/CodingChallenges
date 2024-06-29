//brute-force method
import java.util.*;
public class Solution{  

    public static int findUnique(int[] arr){

  int uniq=0;
 
    for(int i=0;i<arr.length;i++){
      int counter=0;
      for(int j=0;j<arr.length;j++){
        if(arr[i]==arr[j])
        counter++;
      }
      if(counter==1){
      uniq= arr[i];
      }
    }
    return uniq;
    }
}
