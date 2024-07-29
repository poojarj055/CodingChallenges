// Given an array of N integers and Q queries of indices. Return a list NGEs[] where NGEs[i] stores the count of elements strictly greater than
//   the current element (arr[indices[i]]) to the right of indices[i].
// Examples :

// Input:  arr[]     = [3, 4, 2, 7, 5, 8, 10, 6]
//         queries = 2
//         indices[] = [0, 5]
// Output:  6, 1
// Explanation: The next greater elements to the right of 3(index 0) are 4,7,5,8,10,6. The next greater elements to the right of 8(index 5) is only 10.


BRUTE-FORCE Approach

class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
     int[] results = new int[queries];
       for (int i = 0; i < queries; i++) {
            int count = 0;
            int index = indices[i];
            for (int j = index + 1; j < N; j++) {
                if (arr[j] > arr[index]) {
                    count++;
                }
            }
            results[i] = count;
        }
        
        return results;
  }
}


``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````

//OPTIMIZED APPROACH

class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
      // Array to store counts of next greater elements for each element
        int[] results = new int[queries];
        
        for (int q = 0; q < queries; q++) {
            int index = indices[q];
            int count = 0;
            Stack<Integer> stack = new Stack<>();
            
            for (int i = index + 1; i < N; i++) {
                while (!stack.isEmpty() && stack.peek() <= arr[index]) {
                    stack.pop();
                }
                if (arr[i] > arr[index]) {
                    stack.push(arr[i]);
                }
            }
            
            count = stack.size();
            results[q] = count;
        }
        
        return results;
  }
     
    public static void main(String[] args) {
        // Example test case
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] indices = {0, 5};
        int[] result = count_NGEs(arr.length, arr, indices.length, indices);
        System.out.println(Arrays.toString(result));  // Expected Output: [6, 1]
    }
}


````````````````````


Array: [3, 4, 2, 7, 5, 8, 10, 6]

Index 0 (Element 3)
Elements to the Right: [4, 2, 7, 5, 8, 10, 6]
Greater Elements: [4, 7, 5, 8, 10, 6]
Count: 6
Stack Progression: [] -> [4] -> [4] -> [4, 7] -> [4, 7, 5] -> [4, 7, 5, 8] -> [4, 7, 5, 8, 10] -> [4, 7, 5, 8, 10, 6]
Index 5 (Element 8)
Elements to the Right: [10, 6]
Greater Elements: [10]
Count: 1
Stack Progression: [] -> [10] -> [10]
Final Results: [6, 1]

``````````````````````````````````````````````````````````


Explanation
1. Initialize the ngeCount array and the stack: The ngeCount array will store the count of next greater elements for each index, and the stack will be used to find the next greater elements.
2. Traverse the array from right to left: This ensures that for each element, we only consider elements to its right.
3. Use the stack to find the next greater elements: For each element, we pop all elements from the stack that are less than or equal to the current element (since they cannot be the next greater element for any future elements). The size of the stack after this operation gives the count of elements greater than the current element.
4. After processing all elements to the right of arr[index], the size of the stack gives the number of elements greater than arr[index].
Store this count in the results array.
5. Handle the queries: For each query, use the precomputed ngeCount array to get the result.
6. This approach ensures that the counts are correctly computed, and it handles the elements' 
