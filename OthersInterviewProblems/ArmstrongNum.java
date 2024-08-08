// Problem statement
// You are given an integer ‘NUM’ . Your task is to find out whether this number is an Armstrong number or not.
// A k-digit number ‘NUM’ is an Armstrong number if and only if the k-th power of each digit sums to ‘NUM’.
// Example
// 153 = 1^3 + 5^3 + 3^3.

// Therefore 153 is an Armstrong number.


public class Solution 
{
	public static boolean isArmstrong(int n)
	{
	    // wrtie your code here;
		int temp=n;
		int num=n;
		int pow=Integer.toString(n).length();
		int s=0;
		while(num!=0){
			int r=num%10;
			s=s+(int)Math.pow(r,pow);
			num=num/10;
		}
		if(temp==s){
			return true;
		}
		else{
			return false;
		}
	}
}


