Find a pair with the given difference

Given an unsorted array and a number n, find if there exists a pair of elements in the array whose difference is n.
Examples:

Input: arr[] = {5, 20, 3, 2, 50, 80}, n = 78
Output: Pair Found: (2, 80)

Input: arr[] = {90, 70, 20, 80, 50}, n = 45
Output: No Such Pair

Code:

//==========================================Approach 2==========================================
package CrackerSandS;
import java.util.HashSet;

public class PairwithaGivenDifference {
	
	public static int Pair(int arr[], int x) {
		
		HashSet<Integer> map= new HashSet<Integer>();
		
		for( int i=0; i< arr.length; i++) {
			map.add(arr[i]);
		}
		
		for( int i=0; i< arr.length ;i++) {
			int y= arr[i]+ x;
			
			if( map.contains(y)) {
				return 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int arr[]= {5, 20, 3, 2, 50, 80};
		int n= 78;
		int pair= Pair(arr,n);
		System.out.println(pair);
	}

}

//========================================================= Approach 3===============================================================
package CrackerSandS;
import java.util.Arrays;

public class PairwithaGivenDifference {
public static int checkPairWithDiff( int arr[], int x) {
		
		Arrays.sort(arr);
		
		for( int i=0; i< arr.length; i++) {
			
			int y= arr[i]+ x;
			boolean isPresent= binarySearch(arr, y);
			if( isPresent) {
				return 1;
			}
		}
		return -1;
	}

	public static boolean binarySearch(int arr[], int n) {
		
		int start=0;
		int end= arr.length-1;
		
		while( start <= end) {
			
			int mid= start + ((end- start)/2);
			
			if( arr[mid]== n) {
				return true;
			}
			
			if( arr[mid] > n) {
				end= mid-1;
			}else {
				start= mid+1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		int arr[]= {5, 20, 3, 2, 50, 80};
		int n= 78;
		int result= checkPairWithDiff(arr, n);
		System.out.println(result);
	}

}

