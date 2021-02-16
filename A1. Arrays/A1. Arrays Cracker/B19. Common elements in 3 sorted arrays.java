Find common elements in three sorted arrays
Given three arrays sorted in non-decreasing order, print all common elements in these arrays.

Examples: 

Input: 
ar1[] = {1, 5, 10, 20, 40, 80} 
ar2[] = {6, 7, 20, 80, 100} 
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120} 
Output: 20, 80

Input: 
ar1[] = {1, 5, 5} 
ar2[] = {3, 4, 5, 5, 10} 
ar3[] = {5, 5, 10, 20} 
Output: 5, 5

Code:

//====================================================Approach 1==================================================


//=================================================== Approach 2===================================================

//=================================================== Approach 3====================================================

package ArraysCracker;

import java.util.Scanner;
import java.util.ArrayList;

public class CommonIn3Arrays {

	public static int[] takeInput() {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static ArrayList<Integer> commonElements(int arr1[], int arr2[], int arr3[]){
		
		ArrayList<Integer> ans= new ArrayList<Integer>();
		int n1= arr1.length;
		int n2= arr2.length;
		int n3= arr3.length;
		int i=0, j=0, k=0; //teen pointers rakh rhe and teeno pointers ko zero se initialise kar lenge
		
		while( i < n1 && j< n2 && k< n3) { //jabtak teeno array mai elements hai tabtak loop run karenge
			
			if( arr1[i] == arr2[j] && arr2[j] == arr3[k]) { //agar muje teeno elements barabar mil jate hai to mai usko apne arraylist mai store karlunga
				ans.add(arr1[i]);
				//jobhi element hai usko ek variable mai store karenge
				int ele= arr1[i];
				
				//aur jabtak yeh element muje milta rehta hai arr1 or arr2 or arr3 mai mai pointer ko aage badha dunga coz ho skta hai ki duplicate element bhi exist krte ho
				while( i < n1 && arr1[i] == ele) {
					i++;
				}
				
				while( j < n2 && arr2[j] == ele) {
					j++;
				}
				
				while( k < n3 && arr3[k] == ele) {
					k++;
				}
					
			}else if( arr1[i] < arr2[j]) { //agar mera pehle chota hai dusre wale se to i ko aage badhaunga
				i++;
			}else if( arr2[j] < arr3[k]) { //agar dusra wala chota hai pehle wale se to j ko aage badhayenge
				j++;
			}else {
				k++; //agar teesre array ka pointer chota hai to teesre wale pointer ko aage badhaunga
			}
		}
		return ans;
	}

	public static void main(String[] args) {

		int arr1[]= takeInput();
		int arr2[]= takeInput();
		int arr3[]= takeInput();
		ArrayList<Integer> ans= commonElements(arr1, arr2, arr3);
		System.out.println(ans);
	}

}

