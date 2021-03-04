Rotate a matrix by 90 degree in clockwise direction without using any extra space
Given a square matrix, turn it by 90 degrees in clockwise direction without using any extra space.

Examples: 

Input:
1 2 3 
4 5 6
7 8 9  
Output:
7 4 1 
8 5 2
9 6 3

Input:
1 2
3 4
Output:
3 1
4 2 
  
Code:

package DSA_Cracker;

import java.util.Scanner;

public class RotateMatrix {
	
	public static int[][] takeInput(){
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int arr[][]= new int[n][n];
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		return arr;
	}
	
	//ab hum matrix ka transpose lenge, arr[i][j] mai arr[j][i] dalna hota hai
	public static int[][] transpose( int arr[][]){
		
		for( int i=0; i< arr.length; i++) {
			for( int j=i; j< arr[0].length; j++) { //mai bas upper triangle mai move karunga  isliye j=i kiya taki triangularly move ho. j wala first loop 0 start hoga then next time j 1 se start hoga
				int temp= arr[i][j];
				arr[i][j]= arr[j][i];
				arr[j][i]= temp;
			}
		}
		return arr;
	}
	
	//transpose hogya ab row by row saari line ko reverse karenge
	//saari row ko reverse karenge jisse first column last column ban jaye
	public static int[][] rowbyrowRev( int arr[][]){
		
		for( int i=0; i< arr.length; i++) {
			int li=0; //left index
			int ri= arr[i].length-1; //right index
			
			while( li > ri) {
				//values swap karte jayenge
				int temp= arr[i][li];
				arr[i][li]= arr[i][ri];
				arr[i][ri]= temp;
				li++;
				ri--;
			}
		}
		return arr;
	}
	
	public static void print( int arr[][]) {
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}

	public static void main(String[] args) {

		int arr[][]= takeInput();
		int ans[][]= transpose(arr);
		print(ans);
	}

}
