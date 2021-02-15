Merge two sorted arrays with O(1) extra space
We are given two sorted arrays. We need to merge these two arrays such that the initial numbers (after complete sorting) are in the first array and the remaining numbers are in the second array. Extra space allowed in O(1).

Example: 
Input: ar1[] = {10};
       ar2[] = {2, 3};
Output: ar1[] = {2}
        ar2[] = {3, 10}  

Input: ar1[] = {1, 5, 9, 10, 15, 20};
       ar2[] = {2, 3, 8, 13};
Output: ar1[] = {1, 2, 3, 5, 8, 9}
        ar2[] = {10, 13, 15, 20}
        
//===========================================Approach 1================================================================================================
we are going to use the third array which will have a sie of addition of both the arrays
Code:
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class Fibonacci {

	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void mergeSorted(int arr1[], int arr2[]) {
		
		int arr3[]= new int[arr1.length+ arr2.length];
		int index=0;
		
		for( int i=0; i< arr1.length; i++) {
			arr3[index]= arr1[i];
			index++;
		}
		
		for( int i=0; i< arr2.length; i++) {
			arr3[index]= arr2[i];
			index++;
		}
		
		Arrays.sort(arr3);
		index=0;
		
		for( int i=0 ; i< arr1.length; i++) {
			arr1[i] = arr3[index];
			index++;
		}
		
		for( int i=0 ; i< arr2.length; i++) {
			arr2[i] = arr3[index];
			index++;
		}
		
		print(arr1);
		print(arr2);
	}
	
	public static void print( int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		int arr1[] = takeInput();
		int arr2[]= takeInput();
		 mergeSorted(arr1, arr2);
	}
}

Time Complexity: O(nlogn) + O(n) + O(n)
Space: O(n)

//============================================Approach 2 (Insertion Sort kind of algorithm)===============================================================
       

//============================================ Approach 3 =============================================================================================

Video: https://youtu.be/hVl2b3bLzBw
