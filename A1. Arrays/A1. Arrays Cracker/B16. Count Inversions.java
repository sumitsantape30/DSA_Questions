Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:
Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).

Example 2:
Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.

Example 3:
Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.
 
 Code:

//============================================================= Approach 1========================================

//===========================================================Approach 2===========================================
package ArraysCracker;

public class CountInversions {
	
	public static int merge(int arr[], int sI, int eI) {
		
		int mid= (sI + eI)/2;
		int ans[]= new int[ eI - sI +1];
		int i= sI;
		int j= mid+1;
		int k=0;
		int invCount=0;
		
		while( i <=  mid && j <= eI) {
			
			if( arr[i] <= arr[j]) {
				ans[k]= arr[i];
				i++;
				k++;
			}else {
				ans[k]= arr[j];
				j++;
				k++;
				//the addition will be the count of elements to right of the mid so I know that second array starts at mid+1 so from i I need to count the elements on the right
				invCount += invCount + (mid -i);
			}
		}
		
		while( i <= mid) {
			arr[k]= arr[i];
			i++;
			k++;
		}
		
		while( j <= eI) {
			arr[k]= arr[j];
			k++;
			j++;
		}
		
		for( int index=0; index < ans.length; index++) {
			arr[ sI+ index]= ans[index];
		}
		return invCount;
		
	}
	
	//here, low has been called left and high has been called right
	public static int mergeSort(int arr[], int sI, int eI) {
		
		 int invCount=0; //initially count will be zero
		
		 //after that we know we're gonna split them only if right is greater than left 
		if( sI > eI) {
			
			int mid= (sI + eI)/2;
			
			//splitting
			invCount += mergeSort(arr, sI, mid);
			invCount += mergeSort(arr, mid+1, eI);
			
			//after splitting the recusrsion is over we simply call the merge function
			invCount += merge(arr, sI, eI);
		}
		return invCount;
	}

	public static void main(String[] args) {

		int arr[]= {5,3,2,4,1};
		int n= arr.length;
		int ans= mergeSort(arr, 0, arr.length-1); //here, low is 0 and high will always be arr.length-1
		System.out.println("Number of inversions"+ ans);
		
	}

}

Video: https://youtu.be/kQ1mJlwW-c0
