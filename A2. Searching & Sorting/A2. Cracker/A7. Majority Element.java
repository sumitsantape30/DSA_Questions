Write a function which takes an array and prints the majority element (if it exists), otherwise prints "No Majority Element". A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element). 




Examples : 
Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
Output : 4
Explanation: The frequency of 4 is 5 which is greater
than the half of the size of the array size. 

Input : {3, 3, 4, 2, 4, 4, 2, 4}
Output : No Majority Element
Explanation: There is no element whose frequency is
greater than the half of the size of the array size.
  
Code:

//=========================================================== Approach 1 ===========================================================

//=========================================================== Approach 2=============================================================

//========================================================== Approach 3===============================================================
package CrackerSandS;

public class MajorityElement {
	
	public static int majorityEl(int nums[]) {
		int count=0;
		int candidate= 0;
		
		//now i'll iterate over the whole array
		for( int num: nums) {
			if( count == 0) {
				candidate= num;
			}
			
			if( num == candidate) {
				count += 1;
			}else {
				count -= 1;
			}
		}
		//we'll return candidate as our majority element will be stored in it
		return candidate;
	}

	public static void main(String[] args) {

		int arr[]= {3, 3, 4, 2, 4, 4, 2, 4, 4};
		int ele= majorityEl(arr);
		System.out.println(ele);
	}
}
