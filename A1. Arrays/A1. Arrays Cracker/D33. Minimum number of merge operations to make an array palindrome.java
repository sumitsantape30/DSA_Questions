Find minimum number of merge operations to make an array palindrome

Given an array of positive integers. We need to make the given array a ‘Palindrome’. The only allowed operation is”merging” (of two adjacent elements). Merging two adjacent elements means replacing them with their sum. The task is to find the minimum number of merge operations required to make the given array a ‘Palindrome’.
To make any array a palindrome, we can simply apply merge operation n-1 times where n is the size of the array (because a single-element array is always palindromic, similar to single-character string). In that case, the size of array will be reduced to 1. But in this problem, we are asked to do it in the minimum number of operations.

Example : 
Input : arr[] = {15, 4, 15}
Output : 0
Array is already a palindrome. So we
do not need any merge operation.

Input : arr[] = {1, 4, 5, 1}
Output : 1
We can make given array palindrome with
minimum one merging (merging 4 and 5 to
make 9)

Input : arr[] = {11, 14, 15, 99}
Output : 3
We need to merge all elements to make
a palindrome.
The expected time complexity is O(n)
  
 Code:
package ArraysCracker;

import java.util.Scanner;

public class minimumMergeOperations {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< n; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}

	public static int minimumOperations(int arr[]) {
		
		int n= arr.length;
		int ans=0; //initially ans 0 rahega
		
		for( int i=0, j= n-1; i<=j;) {
			
			if( arr[i] == arr[j]) { // agar mere i and j same hai to merge karne ki jarurat nhi hai mai i and j ko aage badha dunga
				i++;
				j--;
				
			} else if( arr[i] > arr[j]) { //agar left element grater hai to hum right mai 2 elements merge krte hai, current and uske aage wale ko merge krte hai
				j--;
				arr[j] +=  arr[j+1];
				ans++; //ans ko badhayenge as humne merge kiya
				
			}else { //agar right element greater hai to left mai 2 elements merge krte hai, current and uske aage wale ko merge krte hai
				i++;
				arr[i] += arr[i+1];
				ans++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {

		int arr[]= takeInput();
		int result= minimumOperations(arr);
		System.out.println(result);
	}

}
