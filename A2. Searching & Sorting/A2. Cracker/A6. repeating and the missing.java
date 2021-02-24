Given an unsorted array of size n. Array elements are in the range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.

Examples: 

 Input: arr[] = {3, 1, 3}
Output: Missing = 2, Repeating = 3
Explanation: In the array, 
2 is missing and 3 occurs twice 

Input: arr[] = {4, 3, 6, 2, 1, 1}
Output: Missing = 5, Repeating = 1

Code:

//=============================================Approach 1 (Using Maps)============================================
package CrackerSandS;

import java.util.HashMap;

public class MissingAndDuplicate {
	
	public static void mAndd(int arr[]) {
		
		HashMap<Integer, Boolean> map= new HashMap<Integer, Boolean>();
		
		for( int ele : arr) {
			if( map.get(ele) == null) { //jo elements mai nhi hai means null hai wahi elements hum map mai dalenge and jo no null hai means already present hai map mai wahi humara duplicate element hai
				map.put(ele, true);
			}else {
				System.out.println("Duplicate Element: "+ele);
			}
		}
		
		//ab mai 1 se leke n tak traverse karunga
		for( int i=1; i< arr.length; i++) {
			
			if( map.get(i) == null) { // humne map mai sare elements dal diye the ab hum array pe traverse krke check karre ki koi element hai jo null hai to wahi missing hai  
				System.out.println("Missing Element: "+ i);
			}
		}
	}

	public static void main(String[] args) {

		int arr[] ={ 4, 3, 6, 2, 1, 6, 7 };
		mAndd(arr);
	}
}

Output: 
Duplicate Element: 6
Missing Element: 5

Time Complexity: O(n) coz hum new map use karre to store elements of old array

//============================================================ Approach 2 (Sorting)=============================================================


