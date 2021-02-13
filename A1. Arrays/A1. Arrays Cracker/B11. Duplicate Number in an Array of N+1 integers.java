Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
 
Example 2:
Input: nums = [3,1,3,4,2]
Output: 3
 
Example 3:
Input: nums = [1,1]
Output: 1
 
Example 4:
Input: nums = [1,1,2]
Output: 1

 //==============================================Approach 1=====================================
 we can sort the array, after sorting aray we can linearly traverse the array, and there will be a index where you can see the value at index i will be equal to the value at index i=1, duplicate elements will be together in the sorted array.
 
 Code:
package ArraysCracker;

import java.util.Scanner;
import java.util.Arrays;

public class DuplicateNumber {

	public static int[] takeInput() {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static int getDuplicate(int arr[]) {

		Arrays.sort(arr);

		for (int i = 1; i < arr.length; i++) { //i=1 se start karna padega taki hum uske piche wale elements ke sath compare kr ske

			if (arr[i] == arr[i - 1]) {
				return arr[i];
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int arr[] = takeInput();
		int duplicate = getDuplicate(arr);
		System.out.println(duplicate);
	}

}

Time complexity : O(nlgn)
The sort invocation costs O(nlgn) time in Java, so it dominates the subsequent linear scan. 
 Space complexity : O(1) 
Here, we sort nums in place, so the memory footprint is constant. If we cannot modify the input array, then we must allocate linear space for a copy of nums and sort that instead.
 
