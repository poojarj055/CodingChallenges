import java.util.* ;
import java.io.*; 
public class Solution {
	public static int[] anagramMapping(int n, int[] a, int[] b) {
		// Brute-force
		// int []storeIndex=new int[n];
		// for(int i=0;i<n;i++){
		// 	for(int j=0;j<n;j++){
		// 		if(a[i]==b[j]){
		// 			storeIndex[i]=j;
		// 		}
		// 	}
		// }
		// return storeIndex;

    //optimized approach

		 // Create a HashMap to store the value-to-index mapping of elements in array b
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(b[i], i);
        }
		// {
  		// 46: 0,
 	    // 12: 1,
 	    // 32: 2,
 	    // 28: 3
		// }

        // Create an array to store the result indices
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = indexMap.get(a[i]);
        }
      // a[0] = 12 -> indexMap.get(12) = 1 -> result[0] = 1
      // a[1] = 28 -> indexMap.get(28) = 3 -> result[1] = 3
      // a[2] = 46 -> indexMap.get(46) = 0 -> result[2] = 0
      // a[3] = 32 -> indexMap.get(32) = 2 -> result[3] = 2

        return result;
	}
}
