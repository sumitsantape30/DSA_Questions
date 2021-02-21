Given an array of n distinct integers sorted in ascending order, write a function that returns a Fixed Point in the array, if there is any Fixed Point present in array, else returns -1. Fixed Point in an array is an index i such that arr[i] is equal to i. Note that integers in array can be negative.

Examples:

  Input: arr[] = {-10, -5, 0, 3, 7}
  Output: 3  // arr[3] == 3 

  Input: arr[] = {0, 2, 5, 8, 17}
  Output: 0  // arr[0] == 0 

  Input: arr[] = {-10, -5, 3, 4, 7, 9}
  Output: -1  // No Fixed Point
  
  //=======================================Approach 1 (LinearSearch)==================================
  inearly search for an index i such that arr[i] == i. Return the first such index found. Thanks to pm for suggesting this solution.
  package CrackerSandS;

import java.util.Scanner;

public class fixedPoint {
	
	public static int[] takeInput(){
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int fixedPoint( int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			
			if( arr[i]== i) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {

		int arr[]= takeInput();
		int fixedPoint= fixedPoint(arr);
		System.out.println(fixedPoint);
	}

}

TC= O(n)
SC= O(1)

//================================================ Approach 2 (Binary Search)================================

