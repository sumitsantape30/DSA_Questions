Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. If there is such a triplet present in array, then print the triplet and return true. Else return false. 
Example: 

Input: array = {12, 3, 4, 1, 6, 9}, sum = 24;
Output: 12, 3, 9
Explanation: There is a triplet (12, 3 and 9) present
in the array whose sum is 24. 

Input: array = {1, 2, 3, 4, 5}, sum = 9
Output: 5, 3, 1
Explanation: There is a triplet (5, 3 and 1) present 
in the array whose sum is 9. 

Code:

package ArraysCracker;

import java.util.Scanner;
import java.util.Arrays;

public class TripletThatSumsToGivenValue {
	
	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n =s.nextInt();
		
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length ; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void findNumbers(int arr[], int sum){
		
		int n= arr.length;
		
		for( int i=0; i< n-2; i++) {
			
			for( int j= i +1; j< n-1; j++) {
				
				for( int k= j+1; k < n; k++) {
					
					if( arr[i]+ arr[j]+ arr[k] == sum) {
						System.out.println("The triplet is"+ arr[i]+" "+arr[j]+" "+arr[k]);

					}
				}
			}
		}
	}
	
	public static boolean find3Numbers(int arr[], int sum) {
		
		for( int i=0; i< arr.length-2; i++) {
			
			int j= i+1;
			int k= arr.length-1;
			
			while(j < k) {
				
				if(arr[i]+ arr[j]+ arr[k]== sum) {
					System.out.println("Triplet is "+ arr[i]+" "+arr[j]+" "+arr[k]);
					return true;
				}
				
				if( arr[i]+ arr[j]+ arr[k] < sum) {
					j++;
				}else {
					k--;
				}
			}
		}
		return false;
		
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int n= arr.length;
		findNumbers(arr, 24);
		boolean num= find3Numbers(arr, 24);
		System.out.println(num);
		
	}

}

