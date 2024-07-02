//https://www.naukri.com/code360/problems/duplicate-in-array_893397?interviewProblemRedirection=true&leftPanelTabValue=SUBMISSION
//with hashset


import java.util.ArrayList;
import java.util.HashSet;

public class Solution {

	public static int findDuplicate(ArrayList<Integer> arr) {

		//    Write your code here.
		int duplicate=0;
		HashSet<Integer> set=new HashSet<>();
		for(int num:arr)
		{
			if(!set.add(num))
			duplicate=num;
		}
		return duplicate;

	}
}
