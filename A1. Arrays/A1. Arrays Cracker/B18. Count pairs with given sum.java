Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.


Example 1:
Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output: 2
Explanation: 
arr[0] + arr[1] = 1 + 5 = 6 
and arr[1] + arr[3] = 5 + 1 = 6.

Example 2:
Input:
N = 4, X = 2
arr[] = {1, 1, 1, 1}
Output: 6
Explanation: 
Each 1 will produce sum 2 with any 1.

Code:

//============================================== Approach 1==============================================
A simple solution is to traverse each element and check if there’s another number in the array which can be added to it to give sum. 

Code:
package ArraysCracker;

import java.util.Scanner;

public class CountPairswithgivensum {
	
	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int countPair( int arr[], int sum) {
		
		int count=0;
		for( int i=0; i< arr.length -1; i++) {
			for( int j= i+1; j< arr.length; j++) {
				if( arr[i]+ arr[j] == sum) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int count= countPair(arr, 6);
		System.out.println(count);
	}

}

Time Complexity: O(n2) 
Auxiliary Space: O(1)
	
//======================================================= Aprroach 2=====================================================================
package ArraysCracker;

import java.util.Scanner;
import java.util.HashMap;

public class CountPairswithgivensum {
	
	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int countPair( int arr[], int sum) {
		
		int count=0;
		for( int i=0; i< arr.length -1; i++) {
			for( int j= i+1; j< arr.length; j++) {
				if( arr[i]+ arr[j] == sum) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static int count(int arr[], int sum) {
		
		HashMap<Integer, Integer> hm= new HashMap<Integer,Integer>(); //ek ma lenge
		int count=0; // humara count initially zero rahega
		
		for( int i : arr) {
			hm.put(arr[i], i); // ek ek karke saari values map mai dal denge
		}
		
		//ab check karenge ki kya sum- arr[i] exist krta hai agar exist krta hai to count++ karenge;
		
		for( int i=0; i< arr.length; i++) {
			
			int target=  sum- arr[i];
			if( hm.containsKey(target)) {
				count++;
			}
			
		}
		return count/2; //sab do bar count ho rhe hai isliye divide by two kiye
	}
	
	public static void main(String[] args) {

		int arr[]= takeInput();
		int count= countPair(arr, 9);
		System.out.println(count);
	}
}

Video Solution : https://youtu.be/Tqa9pilFrhY
