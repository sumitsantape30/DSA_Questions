Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.


Example 1:

Input:
nums = {2, 8, 5, 4}
Output:
1
Explaination:
swap 8 with 4.
Example 2:

Input:
nums = {10, 19, 6, 3, 5}
Output:
2
Explaination:
swap 10 with 3 and swap 19 with 5.

//============================================================== Approach 1=====================================================
  
//============================================================== Approach 2 (Using HashMap)======================================
  package CrackerSandS;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Arrays;
import java.util.HashMap;


public class MinimumNumberOfSwaps {
	
	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int minSwaps(int arr[]) {
		
		int n= arr.length;
		
		//arraylist banayenge and will use pairs jisme first integer will be element and second integer will be index of the first integer
		Vector<Pair<Integer,Integer>> v(n);
		
		
	}
	
	public static int minSwaps2(int arr[]) {
		int n= arr.length;
		int ans=0;
		int temp[]= Arrays.copyOfRange(arr,0, n);
		
		HashMap<Integer,Integer> h= new HashMap<Integer,Integer>(); //thid hashmap stores the index of input array
		Arrays.sort(arr);
		
		for( int i=0; i< arr.length; i++) {
			h.put(arr[i], i);
		}
		
		for( int i=0; i< arr.length; i++) {
			
			if( arr[i] != temp[i]) { //checking if current element is at right place or not
				
				ans++;
				int init= arr[i];
				
				swap(arr, i, h.get(temp[i]));
				
				h.put( init , h.get(temp[i]));
				h.put(temp[i], 1);
			}
		}
		return ans;
	}
	
	public static void swap( int arr[], int i, int j) {
		
		int temp= arr[i];
		arr[i]= arr[j];
		arr[j]= temp;
	}
	
	public static void print(int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	

	public static void main(String[] args) {

		int arr[]=  { 101, 758, 315, 730, 47, 619, 460, 479 };
		int ans= minSwaps2(arr);
		System.out.println(ans);
		
	}

}
