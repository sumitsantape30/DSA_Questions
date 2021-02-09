Given an array A[] consisting 0s, 1s and 2s. The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.
(Without using extra space or sorting algorithm)
Examples:

Input: {0, 1, 2, 0, 1, 2}
Output: {0, 0, 1, 1, 2, 2}

Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

Code:

//======================================Aprroach 1 =============================
We can simply sort the array using a sorting algorithm. It will take O(logn) time for sorting and O(nlogn) time for sorting n elements, and O(1) space.


//===================================== Approach 2 =============================
package ArraysCracker;

import java.util.Scanner;

public class SortAnArrayOf012s {
	
	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int arr[]= new int[n];
		
		for( int i=0; i< n; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int[] SortAnArray(int arr[]) { //input will be an array
		
		int lo= 0; //low pointer will be at 0th position
		int hi= arr.length-1; //high pointer will be at last;
		int mid= 0; //mid pointer bhi initially start mai hi rahega
		int temp; //temp swap krte waqt kam yega isliye lere
		
		while( mid <= hi) { //we will iterate till mid doesn't crosses high
			
			switch(arr[mid]) { //now we will check if the number at mid is 0,1 or 2
			
			case 0: { //if it is 0, since java doesnt have inbuilt swap function so we'll swap and move the low pointer and mid pointer aur break kar denge
				temp= arr[lo];
				arr[lo]= arr[mid];
				arr[mid]= temp;
				lo++;
				mid++;
				break;
			}
			
			case 1: //when my mid is 1, we just move the mid pointer and break
				mid++;
				break;
			
			case 2:{ //when my mid is 2, i'll swap it with high pointer and we will only move the hight pointer backwords
				temp= arr[mid];
				arr[mid]= arr[hi];
				arr[hi]= temp;
				hi--;
				break;
			}
		}
			
	}
		return arr;
}
	
	public static void print(int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int result[] = SortAnArray(arr);
		print(arr);
	}
}

Time Complexity= O(n)
Space Complexity= O(1)..constant time
