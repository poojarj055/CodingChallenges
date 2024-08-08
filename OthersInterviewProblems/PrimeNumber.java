// Problem statement
// Write a Program to check whether the given number N is prime or not.
// For a given number N check if it is prime or not. A prime number is a number that is only divisible by 1 and itself.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 0 <= N <= 10,000
// Sample Input 1 :
// 5
// Sample Output 1 :
// true

import java.util.* ;
import java.io.*; 
class Solution {
	
	public static void main(String args[]) {
		
		// Write code here
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		boolean result=checkPrime(n);
		System.out.print(result);
		
	}
	public static boolean checkPrime(int num){
		if(num==1 || num==0) return false;
		
		for(int i=2;i<num;i++){
			if(num%i==0){
			return false;
			}
		}
		return true;
	}
}


