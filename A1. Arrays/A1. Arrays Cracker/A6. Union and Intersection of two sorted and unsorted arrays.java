=======================For sorted arrays================================================================================================================
Union and Intersection of two sorted arrays

Given two sorted arrays, find their union and intersection.
Example:

Input : arr1[] = {1, 3, 4, 5, 7}
        arr2[] = {2, 3, 5, 6} 
Output : Union : {1, 2, 3, 4, 5, 6, 7} 
         Intersection : {3, 5}

Input : arr1[] = {2, 5, 6}
        arr2[] = {4, 6, 8, 10} 
Output : Union : {2, 4, 5, 6, 8, 10} 
         Intersection : {6}

//==========================Approach 1 (Using Map)=============================
Code:
package ArraysCracker;

import java.util.Scanner;
import java.util.HashSet;

public class UnionandIntersection {

	public static int[] takeInput() {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void Union(int arr1[], int arr2[]) {

		HashSet<Integer> hs1 = new HashSet<>();

		for (int i = 0; i < arr1.length; i++) {
			hs1.add(arr1[i]);
		}

		for (int i = 0; i < arr2.length; i++) {
			hs1.add(arr2[i]);
		}
		System.out.println(hs1);
	}

	public static void intersection(int arr1[], int arr2[]) {

		HashSet<Integer> hs1 = new HashSet<Integer>();
		HashSet<Integer> hs2 = new HashSet<Integer>();

		for (int i = 0; i < arr1.length; i++) {
			hs1.add(arr1[i]);
		}

		for (int i = 0; i < arr2.length; i++) {
			if (hs1.contains(arr2[i])) {
				hs2.add(arr2[i]);
			}
		}
		System.out.println(hs2);
	}

	public static void main(String[] args) {

		int arr1[] = takeInput();
		int arr2[] = takeInput();
		Union(arr1, arr2);
		intersection(arr1, arr2);
	}

}

Output:
5
1 3 5 7 9
4
2 3 5 6
[1, 2, 3, 5, 6, 7, 9]
[3, 5]

//=============================================Approach 2 (Using merge operation)=============================
package ArraysCracker;

import java.util.Scanner;
import java.util.HashSet;

public class UnionandIntersection {

	public static int[] takeInput() {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void Union(int arr1[], int arr2[]) {

		HashSet<Integer> hs1 = new HashSet<>();

		for (int i = 0; i < arr1.length; i++) {
			hs1.add(arr1[i]);
		}

		for (int i = 0; i < arr2.length; i++) {
			hs1.add(arr2[i]);
		}
		System.out.println(hs1);
	}
	
	public static void intersectionbymerge(int arr1[], int arr2[]) {
		
		int i=0;
		int j=0;
		int n = arr1.length;
		int m= arr2.length;
		
		HashSet<Integer> intersect = new HashSet<Integer>();
		
		while( i < n && j < m) { //jabtak array ke size rane mai hai tabtak karenge
			
			if( arr1[i] > arr2[j]) { //ith element chota hai to usko aage badhayenge
				i++;
			}else if( arr2[j] > arr1[i]) { //jth element chota hai to usko aage badhayenge
				j++;
			}else { //agar dono same hai to usko add kar denge and dono ko aage badhayenge
				
				intersect.add(arr1[i]);
				i++;
				j++;
			}
		}
		for( int ele: intersect) {
			System.out.println(ele);
		}
	}
	
	public static void main(String[] args) {

		int arr1[] = takeInput();
		int arr2[] = takeInput();
		intersectionbymerge(arr1, arr2);
	}
}


================================ For unsorted Arrays===================================================================
Given two arrays A and B of size N and M respectively. The task is to find union between these two arrays.

Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in union.

Example 1:
Input:
5 3
1 2 3 4 5
1 2 3

Output: 
5
Explanation: 
1, 2, 3, 4 and 5 are the
elements which comes in the union set
of both arrays. So count is 5.

Example 2:
Input:
6 2 
85 25 1 32 54 6
85 2 
Output: 
7
Explanation: 
85, 25, 1, 32, 54, 6, and
2 are the elements which comes in the
union set of both arrays. So count is 7.

//=======================================Approach 1  (Using map data structure)==========================================
Code:

