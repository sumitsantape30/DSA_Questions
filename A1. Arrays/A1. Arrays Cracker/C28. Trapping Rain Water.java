Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
 

Example 1:

Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10

 Code:
package ArraysCracker;

import java.util.Scanner;

public class TrappingRainWater {
	
	public static int[] takeInput() {
		
		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int findWater(int arr[]) { //input mai array ayega
		int n= arr.length;
		//hume ek array mila hai input mai ab muje do array banana hai mxl jo left ka max lake dega and mxr jo right ka max lake dega and inn dono kabhi size wahi hoga jo input array ka size hai
		
		int mxl[]=  new int[n];
		int mxr[]= new int[n];
		
		//ab hume mxl calculate karna hai so pehle mxl ko initialise karenge input array ke 0th element se
		 mxl[0]= arr[0];
		
		//ab input array ke 0th index wale ko and 1th index wale ko compare karenge
		for( int i=1 ; i< arr.length; i++) { //mxl[0] ko 0th se initialise kardiya tha
			//hum max nikalenge out of jo humne initialse kiya and uske next wale se means mxl[0] and mxl[1] ko
			mxl[i]= Math.max(mxl[i-1], arr[i]);
		}
		
		//similarly mxr nikalna hai to usko initialize karenge array ke last element se 
		 mxr[ arr.length-1]= arr[arr.length-1];
		for( int i= n-2; i>=0 ; i--) {
			mxr[i] = Math.max(mxr[i+1], arr[i]);
		}
		
		//ab ek aur array banayenge water[], water array mai store hoga minimum of of maxl and mxr
		int water[]= new int[n];
		
		for( int i=0; i<arr.length; i++) {
			water[i]= Math.min(mxl[i], mxr[i]) - arr[i];
		}
		
		int sum=0; // yeh humara actual result hai
		for( int i=0; i< arr.length; i++) {
			sum += water[i];
		}
		return sum;
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int result= findWater(arr);
	}
}
