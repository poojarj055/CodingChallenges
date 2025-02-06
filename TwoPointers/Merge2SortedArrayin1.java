class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;        // Last valid element in arr1
        int j = n - 1;        // Last element in arr2
        int k = m + n - 1;    // Merge position (last index of arr1)

       while(k >=0)
       {
         if(i>=0 && j>=0)  {
                arr1[k--]=arr1[i]>arr2[j] ? arr1[i--] : arr2[j--];
         }          
        else if(i>=0){
            arr1[k--]=arr1[i--];
        }
        else
        {
            arr1[k--]=arr2[j--];
        }
       }
    }
    
}

--------------------------------------------------
Pointers Initialization:

i = m - 1 → Points to the last valid element in arr1
j = n - 1 → Points to the last element in arr2
k = m + n - 1 → Points to the last index in arr1 (where merging happens)
Merging in Reverse Order (from the end of arr1):

If arr1[i] > arr2[j], place arr1[i] at arr1[k] and decrement i & k.
Otherwise, place arr2[j] at arr1[k] and decrement j & k.
Handling Remaining Elements:

If elements remain in arr1, copy them directly.
If elements remain in arr2, copy them into arr1 (this ensures all elements are merged).
