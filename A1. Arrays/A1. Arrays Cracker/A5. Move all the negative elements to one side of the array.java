Move all negative numbers to beginning and positive to end with constant extra space
Difficulty Level : Easy
 Last Updated : 22 Dec, 2020
An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.
Examples : 

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5
Note: Order of elements is not important here.

//==============================Approach 1 (simply apply the partition process of quicksort)===========================
Time complexity: O(N) 
Auxiliary Space: O(1)

//==============================Approach 2 (Two Pointer Approach) ====================================================
package ArraysCracker;

import java.util.Scanner;

public class MoveAllNegToOneSide {
	
	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void shiftAll(int arr[], int left, int right) {
		
		while( left <= right) { //jabtak left right chota hai or bada hai tabtak loop ke execute karne wale hai
			
			//agar left and right dono elments negative hai to we are going to increse left pointer only. Left agar negative hai aur right bhi negative hai to woh positive ko bolega ki ruk mai aage badhke dekhta hu ki age positive number hai kya agar positive number hoga hum swap karenge coz right mai mere pas negative value hai isliye sirf left aage bada right wahipe rahega.
			if( arr[left] < 0 && arr[right] < 0) {
				left++;
				
			} else if( arr[left] > 0 && arr[right]< 0) { //left wala pointer positive hai aur right wala pointer negative hai to we are going to swap these values kyuki hume left mai negative mai sirf negative values chahiye
				int temp= arr[left];
				arr[left]= arr[right];
				arr[right]= temp;
				left++;
				right--;
				
			} else if( arr[left] > 0 && arr[right]> 0) {//agar dono positive hai to right ko piche leke ayenge kyuki left right bolega ki tu piche aaja agar terko negative element miljaye to we'll swap 
				right--;
				
			}else { //agar saari conditions false hojati hai to hum left ko aage bada denge aur right ko piche le aayenge. Yeh condition kab ayegi? jab humare left mai negative hoga aur right mai positive hoga joki humare condition ko violet nhi kar rha to hum simply iterate kar jayenge
				left++;
				right--;
			}
		}
		
	}
	
	public static void print(int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		shiftAll(arr, 0, arr.length-1);
		print(arr);
	}
}

Time Complexity: O(N)
Auxiliary Space: O(1)
