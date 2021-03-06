//===================== For Reversing Character Array======================================
Write a function that reverses a string. The input string is given as an array of characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Code:
package DSA_Cracker;

import java.util.Scanner;

public class ReverseString {
	
	public static char[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		char arr[]= new char[n];
		
		for( int i=0; i< n; i++) {
			String str= s.next();
			arr[i]= str.charAt(0);
		}
		return arr;
	}
	
	public static void reverse( char[] arr) {
		
		int left= 0;
		int right= arr.length-1;
		
		while( left < right) {
			
			char temp = arr[left];
			arr[left]= arr[right];
			arr[right]= temp;
			left++;
			right--;
		}
	}
	
	public static String reverse2( String str) {
		
		int i= str.length()- 1;
		String rev= "";
		
		for( i =0; i>=0; i--) {
			rev= rev + str.charAt(i);
		}
		return rev;
	}
	
	public static void print( char arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		
		char arr[]= takeInput();
		reverse(arr);
		print(arr);
	}
}

Time Complexity: O(n)
Space Complexity: O(1)
