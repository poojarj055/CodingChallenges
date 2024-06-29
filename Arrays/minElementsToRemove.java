//https://www.naukri.com/code360/problems/make-unique-array_920329?interviewProblemRedirection=true&search=uniq&leftPanelTabValue=SUBMISSION

import java.util.* ;
import java.io.*; 
public class Solution {

	public static int minElementsToRemove(ArrayList<Integer> arr) {

		// Write your code here
		int length=arr.size();
		 HashSet<Integer> set = new HashSet<>();
        
        // Add elements from ArrayList to HashSet to ensure uniqueness
        for (int num : arr) {
            set.add(num);
        }
		int setSize=set.size();
		int removeElements=length-setSize;
		return removeElements;
	}
}
