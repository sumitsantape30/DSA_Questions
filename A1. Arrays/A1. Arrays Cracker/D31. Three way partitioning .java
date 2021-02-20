Three way partitioning of an array around a given range

Given an array and a range [lowVal, highVal], partition the array around the range such that array is divided in three parts.
1) All elements smaller than lowVal come first.
2) All elements in range lowVal to highVVal come next.
3) All elements greater than highVVal appear in the end.
The individual elements of three sets can appear in any order.

Examples:

Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}  
        lowVal = 14, highVal = 20
Output: arr[] = {1, 5, 4, 2, 1, 3, 14, 20, 20, 98, 87, 32, 54}

Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}  
       lowVal = 20, highVal = 20       
Output: arr[] = {1, 14, 5, 4, 2, 1, 3, 20, 20, 98, 87, 32, 54} 

Code:

//=========================================== Approach 1==========================================================
A simple solution is to sort the array. This solution does a lot of extra rearrangements and requires O(n Log n) time.

//=========================================== Approach 2===========================================================
An efficient solution is based on Dutch National Flag based QuickSort. We traverse given array elements from left. 
We keep track of two pointers, first (called start in below code) to store next position of smaller element (smaller than range) from beginning; 
and second (called end in below code) to store next position of greater element from end.

Code:
package ArraysCracker;

import java.util.Scanner;

public class threeWayPartitioning {
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void partitioning(int arr[], int lowVal, int highVal) {
		
		int n= arr.length;
		int start=0;
		int end= arr.length-1;
		
		
		for( int i=0; i< arr.length;) {
			
			if( arr[i] < lowVal) { //agar meri current value lowVal se choti hai to mai use start ke sath swap kardunga and start ko and i ko ++ kardunga
				
				int temp= arr[start];
				arr[start]= arr[i];
				arr[i]= temp;
				start++;
				i++;
			} else if( arr[i] > highVal) { 
				int temp= arr[end];
				arr[end]= arr[i];
				arr[i]= temp;
				end--;
			}else { //agar current value range mai hai to hume kuch nhi karna bas i pointer aage badhadenge
				i++;
			}
		}
		
	}
	
	public static void print( int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		partitioning(arr, 10, 20);
	}

}
