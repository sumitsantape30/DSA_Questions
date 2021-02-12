Program to cyclically rotate an array by one

Given an array, cyclically rotate the array clockwise by one.

Examples:

Input:  arr[] = {1, 2, 3, 4, 5}
Output: arr[] = {5, 1, 2, 3, 4}

Code:

package ArraysCracker;

import java.util.Scanner;

public class RotateAnArray {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int[] rightrotate(int arr[]) {
		
		int n= arr.length  ;
		
		int temp= arr[n-1]; //jo last index pe element hai usko temp mai dal diye 
		
		for( int i= n-1 ; i>0 ; i--) { 
			arr[i]= arr[i-1];
		}
		arr[0]= temp;

		return arr;
	}
	
	public static int[] leftrotate(int arr[]) {
		
		int n= arr.length;
		
		int temp= arr[0];
		
		for( int i= 0; i< n-1 ; i++) { //n-1 isliye karre coz jo sabse last wala index hai woh khali rehna chahiye taki n-1 th index hum temp ki value dal ske
			arr[i]= arr[i+1];
		}
		arr[n- 1]= temp;

		return arr;
	}
	
	public static void print(int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int result1[]= rightrotate(arr);
		//int result2[]= leftrotate(arr);
		print(result1);
		System.out.println();
		//print(result2);
	}
}

Output:
5
1 2 3 4 5
51234

Time Complexity: O(n) As we need to iterate through all the elements
Auxiliary Space: O(1)
