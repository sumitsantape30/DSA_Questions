Count triplets with sum smaller than X 
Count triplets with sum smaller than a given value
Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n2).

Examples:

Input : arr[] = {-2, 0, 1, 3}
        sum = 2.
Output : 2
Explanation :  Below are triplets with sum less than 2
               (-2, 0, 1) and (-2, 0, 3) 

Input : arr[] = {5, 1, 3, 4, 7}
        sum = 12.
Output : 4
Explanation :  Below are triplets with sum less than 12
               (1, 3, 4), (1, 3, 5), (1, 3, 7) and 
               (1, 4, 5)
  
Code:

//=================================Approach 1====================================================================================
package CrackerSandS;

import java.util.Arrays;

public class CountTripletswithSumSmallerThanX {
	
	public static int tripletSum(int arr[], int sum) {
		int n= arr.length;
		int count=0;
		
		for( int i=0; i< n- 2; i++) {
			for( int j= i+1; j< n-1; j++) {
				for( int k= j+1; k< n; k++) {
					if( arr[i] + arr[j]+ arr[k] < sum) {
						count++;
					}
				}
			}
		}
		return count;
	}
  
//========================================= Approach 2=======================================================================
  
  public static int tripletSum2(int arr[], int sum) {
		int n= arr.length;
		
		Arrays.sort(arr);
		
		int ans=0;
		
		for( int i=0; i< arr.length; i++) {
			 int j= i+1, k= n-1;
			 
			 while( j < k) {
				 
				 if( arr[i] + arr[j] + arr[k] < sum) {
					 k--;
				 }else {
					 ans += (k-j);
					 i++;
				 }
			 }
		}
		return ans;
	}

	public static void main(String[] args) {

		int arr[]= {-2, 0, 1, 3};
		int ans= tripletSum2(arr, 2);
		System.out.println(ans);
	}

}

