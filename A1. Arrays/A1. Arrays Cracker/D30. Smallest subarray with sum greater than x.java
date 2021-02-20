Given an array of integers (A[])  and a number x, find the smallest subarray with sum greater than the given value.

Note: The answer always exists. It is guaranteed that x doesn't exceed the summation of a[i] (from 1 to N).

Example 1:
Input:
A[] = {1, 4, 45, 6, 0, 19}
x  =  51
Output: 3
Explanation:
Minimum length subarray is 
{4, 45, 6}

Example 2:
Input:
A[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Explanation:
Minimum length subarray is {10}

Code:

A simple solution is to use two nested loops. The outer loop picks a starting element, the inner loop considers all elements (on right side of current start) as ending element. 
   Whenever sum of elements between current start and end becomes more than the given number, update the result if current length is smaller than the smallest length so far. 
 
Code:

package ArraysCracker;
import java.util.Scanner;

public class SmallestSubarraywithsumgreaterthanagivenvalue {
	
	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]=s.nextInt();
		}
		return arr;
	}

	public static int smallestSubWithSum(int arr[], int gsum) {
		
		int n= arr.length;
		//smallest subarray ki length aisehi assume karenge
		int minLen= Integer.MAX_VALUE;
		
		for( int i=0; i< arr.length; i++) {
			
				int currSum= arr[i]; //subarray ki sum ko initially current wale start ko assume karre
				
				//agar first wala element hi givren sum se jada hoga to uski length return karenge
				if( currSum > gsum) {
					return 1;
				}
				
			for (int j = i + 1; j < n; j++) {
				
				//currrent sum mai har element dalte jayenge
				currSum += arr[j];
				
				if( (currSum > gsum) && (j-i+1 > minLen) ) { //j-i+1, it is the length of the subarray
					minLen= j-i+1;
				}
			}
		}
		return minLen;
	}
	
	public static void main(String[] args) {

		int arr[]= takeInput();
		int length= smallestSubWithSum(arr, 20);
		System.out.println(length);
	}

}


   
