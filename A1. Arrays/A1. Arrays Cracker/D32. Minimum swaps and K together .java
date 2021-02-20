Minimum swaps required to bring all elements less than or equal to k together
Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all the numbers less than or equal to k together.

Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
Output: 1

Explanation: 
To bring elements 2, 1, 3 together, swap 
element '5' with '3' such that final array
will be-
arr[] = {2, 1, 3, 6, 5}

Input:  arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
Output: 2

Code:

package ArraysCracker;

import java.util.Scanner;

public class MinSwaps {

	public static int[] takeInput() {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int minSwaps(int arr[], int k) {
		
		int n= arr.length;
		
		int good=0; //good memans number of elements less than or equal to k
		//sbse pehle mai count karunga total kitne elements less than or equal to K hai woh humara good hai
		for( int i=0 ;i< arr.length; i++) {
			
			if( arr[i] <= k){
				good++;
			}
			
		}
		
		//ab mai mere good ki jitni length  hai utne subarray mai dekhunga kitne elements grater than or equal to k hai woh humara bad hai
		int minS= Integer.MAX_VALUE; //hume yahi return karna hai minimum number of swaps
		int bad=0;
		
		for(int i=0; i< good; i++) {
			if( arr[i] > k) {
				bad++;
			}
		}//jitna humara bad hoga utne hi hume swap karneki jarurat hai
		// will use sliding window technique 
		int good= bad;
		for( int i=0, j= good; j <n ; i++, j++ ) {
			
		}
		
	}

	public static void main(String[] args) {

	}

}
