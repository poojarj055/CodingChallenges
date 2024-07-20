Explanation
1. Initialization: nonZeroIndex keeps track of the position where the next non-zero element should be placed.
2. Move Non-Zero Elements: The first loop iterates through the array, moving non-zero elements to the front. 
The nonZeroIndex is incremented each time a non-zero element is encountered.
3. Fill with Zeros: The second loop fills the remaining positions in the array with zeros.
4. Print the Array: After processing, the modified array is printed.


import java.util.ArrayList;

public class Solution {
	public static void pushZerosAtEnd(ArrayList<Integer> arr)
	{
		int nonZeroIndex = 0;

        // Move non-zero elements to the front
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != 0) {
                arr.set(nonZeroIndex++, arr.get(i));
            }
        }

        // Fill the remaining elements with zero
        for (int i = nonZeroIndex; i < arr.size(); i++) {
            arr.set(i, 0);
        }
//	System.out.print(arr+ " ");
	}
}
