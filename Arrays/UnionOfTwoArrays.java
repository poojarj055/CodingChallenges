// Given two sorted arrays of size n and m respectively, find their union. The Union of two arrays can be defined as the common and distinct elements in the two arrays. 
//   Return the elements in sorted order.

// Example 1:

// Input: 
// n = 5, arr1[] = {1, 2, 3, 4, 5}  
// m = 5, arr2 [] = {1, 2, 3, 6, 7}
// Output: 
// 1 2 3 4 5 6 7
// Explanation: 
// Distinct elements including both the arrays are: 1 2 3 4 5 6 7.

class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        Set<Integer> set=new TreeSet<>();
        for(int num:arr1){
            set.add(num);
        }
        for(int num:arr2){
            set.add(num);
        }
        ArrayList<Integer> result=new ArrayList<>(set);
        return result;
    }
}

`````````````````
NOTE:

Set<String> set1 = new HashSet<>();       // Unordered, no duplicates
Set<String> set2 = new LinkedHashSet<>(); // Ordered by insertion, no duplicates
Set<String> set3 = new TreeSet<>();       // Sorted order, no duplicates
`````````````````

