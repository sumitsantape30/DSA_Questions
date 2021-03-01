Search in a row wise and column wise sorted matrix

Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order. The designed algorithm should have linear time complexity. 

Example: 

Input: mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 29
Output: Found at (2, 1)
Explanation: Element at (2,1) is 29

Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 100
Output : Element not found
Explanation: Element 100 is not found

Code:

package DSA_Cracker;

import java.util.Scanner;

class Pair{
	int first;
	int second;
}

public class searchin2DMatrix {
	
	public static int[][] takeInput(){
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int row= s.nextInt();
		
		System.out.println("Enter the number of column");
		int column= s.nextInt();
		int arr[][]= new int[row][column];
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		return arr;
	}
	
	public static boolean search( int arr[][], int target) {
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				
				if( arr[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static Pair search2( int arr[][], int key) {
		
		Pair ans= new Pair();
		int n= arr.length;
		int m= arr[0].length;
		int i=0; //row 0 pe 
		int j= m -1; // column last wale index pe lere
		
		//yeh kam muje tabtak karna hai ? jabtak mai out of bound na chale jau ya to woh element na mil jaye, agar element mil jaye to wahi return kardenge uske index
		//out of bound chala gya means woh key present nhi hai
		while( i >=0 && i < n && j>= 0 && j<m ) { //jabtak yeh bound ke andar hai
			
			// abhi compare karenge ki apn abhi jaha hai woh key ke equal hai to mai return karunga i and j
			if( arr[i][j] == key) {
				ans.first= i;
				ans.second= j;
				return ans;
			}else if( arr[i][j] > key) { //agar aisa hua to uske pas do direction hai left mai ya to down mai ja skte hai
				//agar current wala greater hai key se matlab current ke niche wale sare usse bada hai means woh useless hai so hum right mai jayenge means j-- karenge
				j--;
			
			}else if( arr[i][j] < key) { //agar current element se badi hai key to muje niche jana chahiye means i++ karna hai
				i++;
				
			}
		}
		ans.first= -1;
		ans.second= -1;
		return ans;
	}

	public static void main(String[] args) {

	}

}
