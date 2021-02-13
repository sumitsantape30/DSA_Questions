Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
The replacement must be in place and use only constant extra memory.

Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]

Example 4:
Input: nums = [1]
Output: [1]

//==============================================Approach 1 (Brute Force) ==============================================================================

//==============================================Approach 2=============================================================================================

package ArraysCracker;

import java.util.Scanner;

public class nextPermutation {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void nextPermutation(int arr[]) {
		
		if( arr== null && arr.length <= 1) { // if my array has length of 1 agar length one hai means the next permutation will be he himself, or it's a null array I don't to any change I just return
			return;
		}
		
		//after that I try to find the break point 
		int i= arr.length- 2;
		
		while( i >= 0 && arr[i] >= arr[i +1] ) { //so the first break point can be at the second last index so i have to start iterating from the second index to check the break points 
			i--;
		}
			if( i >= 0) {
				//if and only if we get the break points then we again linearly iterate back and we try to find someone who is greater than arr[i] and once we did that we swap it
				int j= arr.length- 1;
				while( arr[j] <= arr[j]) {
					j--;
				}
					swap(arr, i, j);
			}//if there's no break point this loop is never performed

		//then we simply reverse the right half
		 reverse(arr, i+1, arr.length-1);
	}
	
	public static void swap(int arr[], int i, int j) {
		
		int temp= arr[i];
		arr[i]= arr[j];
		arr[j]= temp;
	}
	
	public static void reverse(int arr[], int i, int j) {
		
		while( i <= j) {
			swap(arr, i++, j--);
		}
	}
	
	public static void print( int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[] = takeInput();
		nextPermutation(arr);
		print(arr);
	}

}

Time complexity : O(n)O(n). In worst case, only two scans of the whole array are needed.

Space complexity : O(1)O(1). No extra space is used. In place replacements are done.
