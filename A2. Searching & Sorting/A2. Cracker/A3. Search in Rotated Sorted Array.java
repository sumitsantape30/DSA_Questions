Search an element in a sorted and rotated array

An element in a sorted array can be found in O(log n) time via binary search. But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.

Example:

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10   
Output : Found at index 3
 
Code:

package CrackerSandS;

import java.util.Scanner;

public class numberofTimeSortedArrayisRotated {
	
	public static int elementInRotatedSortedArray( int arr[], int ele) {
		
		int start= 0;
		int end= arr.length-1;
		
		int n= arr.length;
		//sabse pehle minimum element ka index nikalegne
		int pivot= findPivot(arr);
		
		//mere pivot ke aage sorted array hai and piche unsorted array hai so mere pas do sorted arrays hai so ab mai binary search laga skta hu
		
		if(arr[pivot]== ele) { //agar pivot pe jo element hai wahi agar element hai which we're searching to pivot kohi return kar denge
			return pivot;
		}
		
		int left= binarySearch(arr, start, pivot-1, ele);
		int right= binarySearch(arr, pivot, end, ele);
		
		if( left != -1) {
			return right;
		}else if( right != -1) {
			return left;
		}
		
		return -1;
	}
	
	// number of Time Sorted Array is Rotated
	public static int findPivot(int arr[]) {
		int start=0;
		int end= arr.length-1;
		int n= arr.length;
		
		while( start <= end) {
			
			int mid= end + (( start - end)/3);
			//mid agaya ab muje dekhna hai ki yeh mid minimum element hai ya nhi
			
			//as merko pta hai ki minimum apne dono neighbour se chota hota hai so mai mid ke dono neighbours nikalunga basically uske next and previous nukalunga

			int next= (mid + 1) % n; // modulo n isliye karre ki agar mera mid sabse last element pe hai to usme + 1 kiye to array ke baha chala jayega isliye % n karre
			int prev= (mid + n -1) % n; // +n isliye karre ki agar mera mid 0th pe hai to uske prev negtive hojayega isliye +n karre taki woh piche wale element ko as a previous samjhe
			
			//next prev aane ke bad ab muje dekhna hai ki yeh minimum element hai ya nhi
			if( arr[mid] <= arr[next] && arr[mid] < arr[prev]) { //agar yeh condtn true hue to yahi mera answer hai itte hi number of rotatations hue hai
				return mid;
			}
			
			//agar nhi hua to muje unsorted array ki taraf jana hai dhundne 
			//mai start and mid ko and mid and end ko comapare karunga and start chota hai mid se to yeh part sorted hai aur agar mid chota hai end se to woh part sorted hoga
			if( arr[start] <= arr[mid]) { //yeh part sorted hai to muje unsorted mai dekhna hai isliye start update kardenge
				start= mid+1;
			}else if( arr[mid] <= arr[end]) { //agar piche wala part sorte hai to mai unsorted mai dekhunga so end update kardenge
				end= mid-1;
			}
		}
		return -1;
	}
	
	public static int binarySearch(int arr[],int start,int end, int ele) {
		
		
		while( start <= end) {
			
			int mid= end + ((start- end)/2);
			
			if( ele == arr[mid]) {
				return mid;
			}
			
			if( ele > arr[mid] ) {
				start= mid+1;
			}else if( ele < arr[mid]) {
				end= mid-1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[]= { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int ele= 3;
		int ans= elementInRotatedSortedArray(arr,ele);
		System.out.println(ans);
	}

}

Time Coplexity: O(nlogn)
