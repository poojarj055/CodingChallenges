// You are given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
// If there are no such elements return an empty array. In this case, the output will be -1.

// Input: 
// arr1 = [1, 5, 10, 20, 40, 80] ,
// arr2 = [6, 7, 20, 80, 100] , 
// arr3 = [3, 4, 15, 20, 30, 70, 80, 120]
// Output: 
// [20, 80]



class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
         HashSet<Integer> set = new HashSet<>();
         ArrayList<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0, k = 0;
        
        while (i < arr1.size() && j < arr2.size() && k < arr3.size()) {
            int num1 = arr1.get(i);
            int num2 = arr2.get(j);
            int num3 = arr3.get(k);
            
            if (num1 == num2 && num2 == num3) {
               if (set.add(num1)) {
                    result.add(num1);
                i++;
                j++;
                k++;
            }
            }else {
                // Advance the pointer of the list with the minimum element
                int min = Math.min(Math.min(num1, num2), num3);
                if (num1 == min) {
                    i++;
                } else if (num2 == min) {
                    j++;
                } else if (num3 == min) {
                    k++;
                }
            }
        }
        
        return result;
    }
}
