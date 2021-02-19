Chocolate Distribution Problem 

Given an array A of positive integers of size N, where each value represents number of chocolates in a packet. Each packet can have variable number of chocolates. There are M students, the task is to distribute chocolate packets such that :
1. Each student gets one packet.
2. The difference between the number of chocolates given to the students having packet with maximum chocolates and student having packet with minimum chocolates is minimum.

Code:

package ArraysCracker;

import java.util.Arrays;
import java.util.Scanner;

public class ChocolateDistributionProblem {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int chocolateDistrbution(int arr[], int k) {
		
		Arrays.sort(arr);// sabse pehle array ko sort karenge
		int min= Integer.MAX_VALUE;
		int n= arr.length;
		
		for( int i=0; i< n- k; i++) {
			if((arr[k-1 +i]- arr[i]) < min) { //jo maximum and minimum hai unka difference agar piche wala min se chota hai to update karenge
				min= arr[k-1+i]- arr[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int min= chocolateDistrbution(arr, 3);
		System.out.println(min);
	}

}
