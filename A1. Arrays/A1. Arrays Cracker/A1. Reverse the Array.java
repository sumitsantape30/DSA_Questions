Write a program to reverse an array or string

Given an array (or string), the task is to reverse the array/string.
Examples : 
 
Input  : arr[] = {1, 2, 3}
Output : arr[] = {3, 2, 1}

Input :  arr[] = {4, 5, 1, 2}
Output : arr[] = {2, 1, 5, 4}

Code:

//========================================= Approach 1 ==========================
package ArraysCracker;

import java.util.Scanner;

public class ReversetheArray {

	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static int[] reverse(int arr[]) {

		// hum do pointers rakhenge i and j, i ko array ke shuruwat mai rakhgenge and aur j ko rakhenge array ke last mai means j= arr.length-1 pe (humari indexing 0 se n-1 tak rehti hai)
		int i = 0; // i ko rakha array ki shuruwat mai
		int j = arr.length - 1; // and j ko rakha uske last mai
        // ab hum inko swap karneka kam karenge
		
		while (i <= j) { // jabtak i and j milte nhi tabtak mai unpe kam krta rahunga

			 int temp= arr[i];
			 arr[i]= arr[j];
			 arr[j]= temp;
			 i++;
			 j--;
		}
		return arr;
	}
	
	public static void print(int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[] = takeInput();
		reverse(arr);
		print(arr);
	}
}

Output:
5
1 2 3 4 5
5
4
3
2
1

 Time Complexity: O(n)
  
 //========================================== Approach 2 (Recursive)===================================
  
  package ArraysCracker;

import java.util.Scanner;

public class ReversetheArray {

	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void reverseRec(int arr[], int start, int end) {
		
		if( start >= end) {
			return;
		}
		
		int temp= arr[start];
		arr[start]= arr[end];
		arr[end]= temp;
		
		reverseRec(arr, start+1, end-1);
	}
	
	public static void print(int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[] = takeInput();
		reverseRec(arr, 0, arr.length-1);
		print(arr);
	}
}

Output:
5
1 2 3 4 5
5
4
3
2
1

Time Complexity: O(n)
