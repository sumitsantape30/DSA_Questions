Given a n x n matrix. The problem is to sort the given matrix in strict order. Here strict order means that matrix is sorted in a way such that
all elements in a row are sorted in increasing order and for row ‘i’, where 1 <= i <= n-1, first element of row 'i' is greater than or equal to the last element of row 'i-1'.

Examples:
Input : mat[][] = { {5, 4, 7},
                    {1, 3, 8},
                    {2, 9, 6} }
Output : 1 2 3
         4 5 6
         7 8 9

Code:

package DSA_Cracker;

import java.util.Scanner;
import java.util.Arrays;

public class SortTheMatrix {
	

	public static void sort(int arr[][], int n){
		
		int temp[]= new int[n*n];
		int k=0;
		
		for( int i=0 ;i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				temp[k]= arr[i][j];
				k++;
			}
		}
		
		Arrays.sort(temp);
		
		k=0;
		for( int i=0; i< arr.length ; i++) {
			for( int j=0; j< arr[0].length; j++) {
				arr[i][j]= temp[k];
				k++;
			}
		}
	}
	
	public static void print( int arr[][]) {
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int arr[][]={ { 5, 4, 7 }, { 1, 3, 8 }, { 2, 9, 6 } };
		int n= arr.length;
		sort(arr, n);
		print(arr);
	}

}

Time Complexity= O(n^2logn)
Auxiliary Space: O(n2).

