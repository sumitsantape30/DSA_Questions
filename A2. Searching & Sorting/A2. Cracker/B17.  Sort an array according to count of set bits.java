Sort an array according to count of set bits
Given an array of positive integers, sort the array in decreasing order of count of set bits in binary representations of array elements. 
For integers having the same number of set bits in their binary representation, sort according to their position in the original array i.e., a stable sort. For example, if the input array is {3, 5}, then the output array should also be {3, 5}. Note that both 3 and 5 have the same number set bits.

Examples:

Input: arr[] = {5, 2, 3, 9, 4, 6, 7, 15, 32};
Output: 15 7 5 3 9 6 2 4 32
Explanation:
The integers in their binary representation are:
    15 -1111
    7  -0111
    5  -0101
    3  -0011
    9  -1001
    6  -0110
    2  -0010
    4- -0100
    32 -10000
hence the non-increasing sorted order is:
{15}, {7}, {5, 3, 9, 6}, {2, 4, 32}

Input: arr[] = {1, 2, 3, 4, 5, 6};
Output: 3 5 6 1 2 4
Explanation:
    3  - 0011
    5  - 0101
    6  - 0110
    1  - 0001
    2  - 0010
    4  - 0100
hence the non-increasing sorted order is
{3, 5, 6}, {1, 2, 4}

Code:
//========================================================== Approach 1===============================================
package CrackerSandS;

import java.util.Scanner;

public class SortAnArrayAccordingtoCountofSetBits {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int countBits( int a) {
		
		int count=0;
		
		while( a > 0) {
			
			if( (a & 1) > 0) {
				count ++;
			}
			a= a >> 1;
		}
		return count;
	}
	
	public static void insertionSort( int arr[], int aux[]) {
		
		for( int i=1; i< arr.length; i++) {
			
			/// use 2 keys because we need to sort both arrays simultaneously
			int key1= arr[i];
			int key2= arr[i];
			int j= i-1;
			
			while( j >= 0 && arr[j]> arr[i]) {
				arr[j+1]= arr[j];
				aux[j+1]= arr[j];
				j--;
			}
			
			aux[j+1]= key1;
			arr[j=1]= key2;
		}
		
	}
	
	public static void sortBySetBitCount(int arr[]) {
		
		int n= arr.length;
		//har element ke andar kitne set bits hai iska count store karne keliye auxiliary array banayenge
		int aux[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			aux[i]= countBits(arr[i]);
		}
		
		//aux array mai jaise values hai uske according array ko sort karege using insertion sort
		insertionSort(arr, aux);
	}
	
	public static void print( int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[] = takeInput();
		sortBySetBitCount(arr);
		print(arr);
	}
}

Auxiliary Space: O(n)
Time complexity: O(n2)
Note: Time complexity can be improved to O(nLogn) by using a stable O(nlogn) sorting algorithm.

//================================================================ Approach 2==============================================================
    
	
   public static int countBits1( int a) {
		
		int count=0;
		
		while( a > 0) {
			
			if( (a & 1) > 0) {
				count ++;
			}
			a= a >> 1;
		}
		return count;
	}
	
	public static void sortBySetBitCnt( int arr[]) {
		 int n =arr.length;
		 
		 //ek vector banayenge 32 size ki as koi bhi integer ke pas maximum 32 set bit reh hi skte hai
		 Vector<Integer>  count[]= new Vector[32];
		 
		 // ab bade wale vector ke har integer mai ek aur vector  banayenge. and woh store karega ki utni konse integer ke set bits hai
		 // example, bade wale vector ke 1th index pe woh saare integers store honge jinke pas set bit 1 hai
		 for( int i=0; i< count.length; i++) {
			 count[i]= new Vector<Integer>(); 
		 }
		 
		 //ab ek ek karke sare elements ke bit set count karenge and usko apne count vector mai dalenge
		 int setBitCount=0;
		 
		 for( int i=0; i< n; i++) {
			 
			 
			 setBitCount = countBits(arr[i]);
			 count[setBitCount].add(arr[i]); //jis element ke jitne set bits hai unke count vector mai dal diye
		 }
		 
		// Traverse through all bit counts (Note that we sort array in decreasing order)
		 int j=0;
		 
		 for( int i= 32; i>=0 ;i--) { //yeh bade wale vector ka loop hai
			 
			 Vector<Integer> v1= count[i];
			 
			 for( int p=0; p < v1.size(); p++) {
				 arr[p]= v1.get(p);
			 } 
		 }
		 
	}

Time Complexity: O(n)
Space: O(n)
