Find four elements that sum to a given value | Set 1 (n^3 solution)

Given an array of integers, find all combination of four elements in the array whose sum is equal to a given value X.
For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and X = 23, then your function should print “3 5 7 8” (3 + 5 + 7 + 8 = 23).

Code:

//================================================ Approach 1============================================================================

package CrackerSandS;

public class FourSumNumbers {

	public static void forSumNum(int arr[], int x) {

		int n = arr.length;

		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				for (int k = j + 1; k < n - 1; k++) {
					for (int l = k + 1; l < n; l++) {
						if (arr[i] + arr[j] + arr[k] + arr[l] == x) {
							System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[l]);
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		int arr[] = { 10, 20, 30, 40, 1, 2 };
		int x = 91;
		forSumNum(arr, x);
	}
}

Time Complexity: O(n^4)
	
//======================================================================== Approach  2===================================================
Four Sum

package CrackerSandS;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class fourSum {
	
	//we are returning a list of list which contains all the unique quads
	public static ArrayList fourSum(int num[], int target) {
		int n= num.length;
		
		ArrayList<List<Integer>> res= new ArrayList<List<Integer>>();
		
		//we check for null case as well as for empty array
		if( num == null || num.length ==  0) {
			return res; // we'll return empty list
		}
		
		//after that I sort the array
		Arrays.sort(num);
		
		//as we are using two nested loops 
		for( int i=0; i< num.length ; i++) {
			for( int j= i+1; j< num.length; j++) {
				
				//now I'll calculate the ramaining element
				int target_2= target - num[i] - num[j];
				//now i'll find this target 2 in the ramaining array
				
				//we keep two pointers one at last and one at next to the j pointer
				int front= j+1;
				int back= n-1;
				
				//I'll keep traversing till my front crosses back
				while( front <= back) {
					
					int two_sum= num[front]+ num[back];
					
					if( two_sum < target_2) { //agar yeh target 2 se chota hai to we'll increase the left pointer
						front++;
					}else if( two_sum > target_2) {
						back--;
					}
					//if none of the above condtion satisfies that means our two sum is equal to target 2 means we got out quad
					// now we'll create a list and add all the four elements in the list that are part of out quad and end mai iss list ko result mai dalenge
					List<Integer> quad= new ArrayList<Integer>();
					quad.add(num[i]);
					quad.add(num[j]);
					quad.add(num[front]);
					quad.add(num[back]);
					
					//once we are done with that we need to remove all the duplicates
					while( front < back && num[front] == quad.get(2)) { //my loop runs till front doesnt crosses back and if element at front is equal to element that we got at the initial front so we'll move just front++ 
					    front++; //as long as they are duplicate we keep moving front. why quad.get(2)? coz maine list mai 2nd index pe front store kiya hai isliye uske sath compare karre
					}
					
					//list mai back 4th index pe store kiya tha isliye quad.get(3) kiya hai
					while( front < back && num[back] == quad.get(3)) {
						back--;
					}
				}
				
				//assume we have 2 2 2 3, now my j is at first 2 and it has to go to 3, as my outer biggest loop is also increasing J so i'll increase my j here by 1 only, so that we come at one step less and our outer loop i will help us to reach at right place
				while(j+1 < n && num[j+1] == num[j]) { //agar j humara dulicate hai to we'll jump over duplicate
					j++;
				}
				
				//same reason for i as well
				while( i+1 < n && num[i+1] == num[i]) {//agar i humara dulicate hai to we'll jump over duplicate
					i++;
				}
			}
		}
		return res; //we'll return our res which will have our quads stored
	}

	public static void main(String[] args) {

		int arr[]= {1,0,-1,0,-2,2};
		int target=0;
		ArrayList<List<Integer>> ans= fourSum(arr, target);
		System.out.println(ans);
	}

}




