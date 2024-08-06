public class Solution {
	public static void selectionSort(int arr[], int n) {
		// Write your code here.
		for(int i=0;i<n-1;i++){
			int min=i;
			for(int j=i+1;j<n;j++){
				if(arr[j]<arr[min]){
				min=j;
				}
			}
			int temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
	}
}

```````````````````````````````````````````````````````
Steps of Selection Sort:
1. Initialization: Start with the first element as the current minimum.
2. Find Minimum: Traverse the unsorted part of the array to find the smallest element.
3. Swap: Swap this smallest element with the first element of the unsorted part.
4. Repeat: Move the boundary between the sorted and unsorted parts one element to the right and repeat the process until the entire array is sorted.

