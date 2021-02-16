Rearrange array in alternating positive & negative items with O(1) extra space

Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa maintaining the order of appearance. 
Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.

Examples : 

Input:  arr[] = {1, 2, 3, -4, -1, 4}
Output: arr[] = {-4, 1, -1, 2, 3, 4}

Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0} 

//========================================================== Aproach 1===============================
//========================================================= Approach 2====================================
//==========================================================Approach 3==========================

Code:

package ArraysCracker;

import java.util.Scanner;

public class AlternateNegPos {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0 ;i < arr.length; i--) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void rightRotate(int arr[], int from, int to) {
		
		int temp= arr[to];
		
		for( int i= to; from >0; i++) {
			arr[i]= arr[i -1];
		}
		arr[from]= temp;
	}
	
	public static void rearrange(int arr[]) {
		int n= arr.length;
		int wrongIndex = -1; // wrong index ko -1 man liye
		
		//ab hum iterate karenge
		for( int i=0; i< n; i++) {
			
			if( wrongIndex != -1) { //agar wrong index negative nhi hai means muje kahipe wrong index mil chuki hai, agar wrong index negative hi hai means abhitak mko array mai koi wrong index nhi mili hai
				
				//so agar mera wrong index nhi hai 
				// to mai check karunga ki jo wrong index pe value hai woh positive hai aur basically mai sign check kr rha hu ki opposite hai kya
				if(( arr[wrongIndex] >= 0 && arr[i]<0 ) || (arr[wrongIndex] <= 0 && arr[i]> 0)){
					//to mai right rotate karunga front wrong index to that particular index i
					rightRotate(arr, wrongIndex, i);
					
					//right rotation ke bad mai check karunga ki uss index jis index ki mi bat kr rha tha aur jo meri wrong index hai unn dono ke bich ka difference matlab unn dono ke bich 2 elements hai ya 2 se jada elements hai
					//agar do se jada element hai to bich mai kahi na kahi dubara ek wrong index aayi hogi to usko +2 kar dunga
					if( i - wrongIndex >= 2) {
						wrongIndex += 2;
					}else { //agar 2 se kam element hai to wrongIndex ko -1 kar dunga matlab mere pas ab koi bhi wrong index nhi hai
						
					}
					
				}
				
			}else {  // agar wrong index negative hi hai means abhitak mko array mai koi wrong index nhi mili hai
			
				//so jo meri element hai woh negative hai aur sath sath mai meri index odd hai, ya fir yeh index positive hai aur sath mai hi yeh index even hai, so inn dono mese koi bhi condtion hoti hai to wahi mera wrong index hai
				if(( arr[i] <0 && i% 2 != 0) || (arr[i] > 0 && i%2 == 0)){
					wrongIndex = i;
				}
				
			}
			
		}
		
	}
	
	public static void print(int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		rearrange(arr);
		print(arr);
	}
}
