import java.util.* ;
import java.io.*; 
public class Solution
{
	public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
	{
		// Write Your Code Here.
		ArrayList<Integer> intersectedArr=new ArrayList<>();
		
		int pointer1=0,pointer2=0;
		while(pointer1<n && pointer2<m){
			if(arr1.get(pointer1).equals(arr2.get(pointer2))){
				intersectedArr.add(arr1.get(pointer1));
				pointer2++;
				pointer1++;
			}
			else if(arr1.get(pointer1)<arr2.get(pointer2)){
				pointer1++;
			}
			else{
				pointer2++;
			}
		}
		return intersectedArr;
	}
}
