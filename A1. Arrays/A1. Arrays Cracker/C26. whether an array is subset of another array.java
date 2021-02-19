Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not. Both the arrays are not in sorted order. It may be assumed that elements in both array are distinct.

Examples: 

Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1} 
Output: arr2[] is a subset of arr1[]

Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4} 
Output: arr2[] is a subset of arr1[]

Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3} 
Output: arr2[] is not a subset of arr1[] 

Code:

//==================================================Approach 1=========================================================
//================================================== Approach 2=======================================================
//===================================================Approach 3=======================================================

package ArraysCracker;

import java.util.Scanner;
import java.util.HashSet;

public class whetheranArrayisSubsetofAnotherArray {

	public static int[] takeInput() {

		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static boolean checkSubset(int arr1[], int arr2[]) {
		
		HashSet<Integer> set= new HashSet<>();
		
		for( int i=0; i< arr1.length; i++) {
			set.add(arr1[i]);
		}
		
		for(int i=0; i< arr2.length; i++) {
			if( !set.contains(arr2[i])) {
				return false;
			}
		}
		return true;	
	}
	

	public static void main(String[] args) {

		int arr1[]= takeInput();
		int arr2[]= takeInput();
		boolean result= checkSubset(arr1, arr2);
		System.out.println(result);
	}

}
