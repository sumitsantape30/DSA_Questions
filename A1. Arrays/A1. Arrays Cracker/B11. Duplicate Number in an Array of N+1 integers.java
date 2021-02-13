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
 
//==================================================================== Approach 2 =========================================
If we store each element as we iterate over the array, we can simply check each element as we iterate over the array

Code:
package ArraysCracker;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

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
		
	public static int getDuplicateUsingSet(int arr[]) {
		
		HashSet<Integer> set= new HashSet<Integer>();
		
		for( int ele: arr) {
			
			if( set.contains(ele)) {
				return ele;
			}
			
			set.add(ele);
		}
		return -1;
	}

	public static void main(String[] args) {

		int arr[] = takeInput();
		int duplicate = getDuplicateUsingSet(arr);
		System.out.println(duplicate);
	}

}

Time Complexity: O(n)
Space : O(n) 
	
// ========================================Approach 3=======================================================
Floyd's Tortoise and Hare (Cycle Detection)

Code:

package ArraysCracker;

import java.util.Scanner;

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
	public static int deplicateusingTortoise(int arr[]) {
		
		// we are initially pointing our fast and slow pointer to the first element, and the we'll move the slow pointer by one and fast pointer by two
		int slow= arr[0];
		int fast= arr[0];
		
		while( slow != fast) { //we'll keep moving until they meet at one point as we know they'll meet
			slow= arr[slow]; //moving slow pointer by one
			fast= arr[arr[fast]]; // moving fast pointer by two
		}
		
		//after loop they must have met at one point and now after they meet we keep the slow pointer where it was and move fast pointer to the first position and after that I start moving the slow and fast pointer unless and until they meet
		fast= arr[0];
		while( slow != fast) {
			//we'll move slow pointer by one and fast pointer by one
			slow= arr[slow];
			fast= arr[fast];
			//whenever they meet either of slow or fast will be my answer so we can return one of them
		}
		return slow;
	}

	public static void main(String[] args) {

		int arr[] = takeInput();
		int duplicate = deplicateusingTortoise(arr);
		System.out.println(duplicate);
	}

}

Video: https://youtu.be/32Ll35mhWg0
