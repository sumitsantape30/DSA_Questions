Kadane's Algorithm 
Medium Accuracy: 51.0% Submissions: 45863 Points: 4
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

 

Example 1:

Input:
N = 5
arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which 
is a contiguous subarray.
Example 2:

Input:
N = 4
arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation:
Max subarray sum is -1 
of element (-1)
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Code:

package ArraysCracker;

import java.util.Scanner;

public class KadanesAlgo {

	public static int[] takeInput() {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static int maxSubarraySum( int arr[]) {
		
		int csum= arr[0]; //current sum mai array of 0 dal denge
		int osum= arr[0]; //overall sum bhi initially arr[0] rahega.
		
		//ab loop chalayenge
		for( int i=0; i< arr.length; i++) { //arr[i] yeh decide krta hai ki mai pichli train mai shamil hou yeh decide krta hai. kaise decide krta hai? agar piche se sum positive aaa rha hai to woh usime shamil ho leta hai ki usne sath hi rehne mai fayda hai so usme add ho lete hai
			
			if( csum > 0) {
				csum += arr[i];
				//pichese positive ara tha to usime shamil ho liye
			}else {
				//but agar piche se sum negative arra hai to hum usme nhi shamil honge hum jaha pe hai wahise shuru karenge
				csum= arr[i]; //upae wale mai humne csum += arr[i] kiya means hum usme shamil ho rhe and isme hum keh rhe ki humse new shuruwat hogi 
				
			}
			
			//aur har bar jo current sum bana woh overall sum ko challenge krke dekhta hai agar usse better hai to overall sum update ho jati hai
	
			if( csum > osum) {
				osum= csum;
			}
			
		}
		return osum;
		
	}

	public static void main(String[] args) {

		int arr[] = takeInput();
		int sum= maxSubarraySum(arr);
		System.out.println(sum);
		
	}

}
