Maximum Product Subarray 
Given an array Arr that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.

Example 1:
Input:
N = 5
Arr[] = {6, -3, -10, 0, 2}
Output: 180
Explanation: Subarray with maximum product
is  6, -3, -10 which gives product as 180.

Example 2:
Input:
N = 6
Arr[] = {2, 3, 4, 5, -1, 0}
Output: 120
Explanation: Subarray with maximum product
is 2, 3, 4, 5 which gives product as 120.

Code:

package ArraysCracker;

import java.util.Scanner;

public class MaxProductSubarray {
	
	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static long maxProduct(int arr[], int n) {
		
		if( n ==0) { //agar array mai elements hi nhi hai to return 0 coz koi product hum generate nhi kr skte
			return 0;
		}
		
		//res min and max ko 1 se initially initialse kar denge
		long res=1;  //result will be my final answer
		long max= 1;
		long min=1;
		
		//ab mai iterate karunga 0 se leke n tak
		for( int i=0; i< n; i++) {
			if( arr[i] >0) { //agar element positive hai to multiply with my max value
				max *=arr[i];
				//aur min mai jo bhi minimum hai ya to 1 or jo current element hai usko min se muliply karete jo bhi minimum hoga usko rakhenge
				min= Math.min(arr[i]*min , 1);	
			
			}else if( arr[i] == 0) { //agar 0 milta hai to we'll reset all the values, result ko reset mat karna result ko reset kiya to dikkat hojayegi
				min= max= 1;
				
			}else { //agar negative element milta hai to I'll swap those minimum and maximum
				min += max - (max - min);
				
				//swap ke bad minimum mai multiply kardeni hai simply
				min *= arr[i];
				max = Math.max(1, arr[i]*max); // aur maximum mai 1 aur , undono ka multply krta hu to undono mai jobhi bada hai usko maximum mai rakhna hai	
			}
			//aur last mai result ko update karte chalna hai ki res aur maximum mai jobhi maximum hai usko hi res mai store rakho
			res= Math.max(max, res);
		}
		return res ;// end mai result return kar denge
		
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int n= arr.length;
		long result= maxProduct(arr,n);
		System.out.println(result);
		
	}

}

