Kth smallest element ================================================================================================================================

Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Example 1:
Input:
N = 6
arr[] = 7 10 4 3 20 15
K = 3
Output : 7
Explanation :
3rd smallest element in the given 
array is 7.

Example 2:
Input:
N = 5
arr[] = 7 10 4 20 15
K = 4
Output : 15
Explanation :
4th smallest element in the given 
array is 15.

Code:

//=============================== Approach 1 (Simple Solution) =====================================
//I can sort the array first and then I cn return the value at (k-1)th index. This will take O(nlogn) time. I can also solve it using max heap or min heap approach and that will take O(n+ Klogn)
 
 Code:
package ArraysCracker;

import java.util.Arrays;
import java.util.Scanner;
import java.util.PriorityQueue;

public class KthSmallestElementInAnArray {

	public static int[] takeInput() {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static int kthsmallest(int arr[], int k) {

		Arrays.sort(arr); // sorting the array

		return arr[k - 1]; // k-1 th element return karre coz humari indexing 0th se start hoti hai

	}
	
	public static int kthlargest(int arr[], int k) { //kth largest nikalna hai to sorted array mai humara kth largest pichese dekhna padega that means jitni array ki size hai usme se K minus kar denge.
		//Dry run karke dekh
		Arrays.parallelSort(arr);
		
		return arr[arr.length - k]; 
	}
	
	public static void main(String[] args) {

		int arr[] = takeInput();
		int smallest = kthsmallest(arr, 3);
		int largest= kthlargest(arr, 3);
		System.out.println(smallest);
		System.out.println(largest);
	}

}

Time Complexity: O(nlogn)
Space Complexity= O(1) : humne koi dusra new array nhi liya extra storage ki jarurat nhi padhi
//====================================== Approach 2 ===================================================

//purane approach mai sorting ki wajah se time complexity badh rhi thi so hume aisa kuch karna hai jiski wajah se time complexity improve hojaye

package ArraysCracker;

import java.util.Scanner;
import java.util.PriorityQueue;

public class KthSmallestElementInAnArray {

	public static int[] takeInput() {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
  
  public static int kthLargestUsingHeap( int arr[], int k) {
		
		PriorityQueue<Integer> queue= new PriorityQueue<Integer>(); //ek queue banayenge aur isme array ke saare elements dal denge and saare elements delete kardenge except jitne k elements hai and woh k elements apne aap queue mai arrange hojayenge 
		
		for( int i=0; i< arr.length; i++) {
			queue.add(arr[i]); //ek ek krke array ke saare elements qeueue mai dalenge
			
			if( queue.size() > k) {  // queue ke sare elements delete karenge except K elements
				queue.poll();
			}
		}
		return queue.peek(); //jo queue ke top pe hoga wahi humara answer hoga.
	}
	
	public static void main(String[] args) {

		int arr[] = takeInput();
		int smallest = kthsmallest(arr, 3);
		int largest= kthlargest(arr, 3);
		//System.out.println(smallest);
		//System.out.println(largest);
		int result= kthLargestUsingHeap(arr, 3);
		System.out.println(result);
	}
}

Output:
7
12
3
5
7
4
19
26
12
Time Complexity: O(n + klogn) 

