import java.util.Scanner;
import java.util.*;
public class Main {

	public static int[] sumOfEvenNodd(int num){
		int evenSum=0, oddSum=0;
		while(num!=0){
			int r=num%10;
			if(r%2==0){
				evenSum=evenSum+r;
			}
			else{
				oddSum=oddSum+r;
			}
			num=num/10;
		}
		return new int[]{evenSum, oddSum};
	}
	
	public static void main(String[] args) {
		// Write your code here
		Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
		int [] result=Main.sumOfEvenNodd(input);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}

	}
}
