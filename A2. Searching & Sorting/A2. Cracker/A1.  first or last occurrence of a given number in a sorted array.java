Find first or last occurrence of a given number in a sorted array


Input:
arr = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
target = 5
 
Output:
The first occurrence of element 5 is located at index 1
The last occurrence of element 5 is located at index 3
 
 
Input:
arr = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
target = 4
 
Output:
Element not found in the array

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class Fibonacci {

	public static int[] takeInput() {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static int FirstbinarySearch(int arr[], int ele) {

		int start = 0;
		int end = arr.length - 1;
		int res= -1; //result ko -1 se initialise krenge coz agar nhi mila means element hai hi nhi to -1 return kar denge

		while (start <= end) {

			int mid = start + ((end- start)/2);

			if (ele == arr[mid]) { //mid nikalne ke bad agar woh element ke equal bhi ata hai uske bad bhi apn search continue rakhte hai aur iss mid ko result mai store rakhte hai coz yeh possibility hai ki yahi answer bhi ho skta hai
				res= mid; //coz possibility hai ki yeh humara answer ho skta hai and iske bad hume search continue rakhnhi hai so end ko update karenge 
				end= mid-1; //agar woh mid pe mil gya to hume uske left mai hi dekhna padega na ki aur koi occurence aya hai kya isliye end update kiye
			}//isse mere pas first occurence aajyega

			if (ele > arr[mid]) {
				start = mid + 1;
			} else if (ele < arr[mid]) {
				end = mid - 1;
			}
		}
		return res;
	}
	
	public static int lastBinarySearch(int arr[], int ele) {
		
		int start=0;
		int end= arr.length-1;
		int res= -1;
		
		while( start <= end ) {
			
			int mid= start + ((end - start)/2);
			
			if( ele == arr[mid]) {
				res= mid;
				start= mid+1; 
			} //yeh muje second occurence lake dega
			
			if( ele > arr[mid]) {
				start= mid+1;
			}else if( ele < arr[mid]) {
				end= mid-1;
			}
		}
		return res;
	}

	public static void print(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[] = takeInput();
		int firstOcc= FirstbinarySearch(arr, 10);
		System.out.println(firstOcc);
		

	}
}

Time Complexity : O(log)
Space: O(1)


