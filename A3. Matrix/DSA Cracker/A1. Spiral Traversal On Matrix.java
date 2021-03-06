Given a 2D array, print it in spiral form. See the following examples.

Examples: 

Input:  1    2   3   4

        5    6   7   8

        9   10  11  12

        13  14  15  16

Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
Explanation: The output is matrix in spiral format. 

Input:  1   2   3   4  5   6

        7   8   9  10  11  12

        13  14  15 16  17  18

Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
Explanation :The output is matrix in spiral format.
  
Code:

package DSA_Cracker;

import java.util.Scanner;

public class SpiralTraversal {
	
	public static int[][] takeInput(){
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the number of row");
		int row= s.nextInt();
		System.out.println("Enter the number of column");
		int column =s.nextInt();
		int arr[][]= new int[row][column];
		for( int i=0; i< arr.length; i++) {
			for( int j= 0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		return arr;
	}
	
	public static void spiralMatrix( int arr[][]) {
		
		//4 variable define karenge, minimum row and column aur maximum row and column
		int minr= 0;
		int minc= 0;
		int maxr= arr.length;
		int maxc= arr[0].length;
		// inn char variable se mai box define kar rha hu sabse outer box
		
		//jitne total elements hai utna hi chalenge
		int tne= arr.length* arr[0].length;
		int cnt=0; //harbar print karte hi mai count ko bdhaunga
		
		while( cnt < tne) { //while the boxes are there, mai har box print hone ke bad cnt badha rha hu so woh jatab less rahega total elements se.
			//ab mai ek ek wall print karenge
			
			//left wall
			//left wall keliye column humara min column hi rahegalekin hum min row se max row ke taraf travel kar rhe hai tabhi humara print hoga
			for( int i= minr, j= minc; i< maxr && cnt < tne; i++) { //min row se max row tak gya, and J min column hi rahega isliye woh bhi loop mai dal diye
				System.out.println(arr[i][j]); //mera bas row vary ho rha tha and column wahi tha
				cnt++;
			}
			//left wall hote hi hum min column ko ++ kar denge
			minc++; //isliye ++ kiye taki agla box aage se start ho so that corner repeat hone se bache
			
			//bottom wall
			//left wall print hone ke bad hume bottom wall print karni hai but agar bottom wall puri print kardi from min column to max column to corner wala element do br hojayega
			for( int j= minc, i= maxr; j<= maxc && cnt < tne; j++) { //bottom mai row max row pe fix rehti hai
				System.out.println(arr[i][minr]);
				cnt++;
			}
			maxr--;
			
			// right wall, yahape i bhi max row pe hoga and j bhi max column pe hoga, i vary karega from max row se min row ke taraf
			for( int i= maxr, j= maxc ; i >= minr && cnt< tne; i--) { 
				System.out.println(arr[i][j]);
				cnt++;
			}
			maxc--;
			
			
			// top wall, isme column vary kr rhe hai max column se min column ke taraf aur i min row pe fixed hai 
			for( int i= minr, j= maxc; j>= minc && cnt < tne; j--) {
				System.out.println(arr[i][j]);
				cnt++;
			}
			minr++; //isliye ++ kiye taki agla box aage se start ho so that corner repeat hone se bache
			
		}
		
		
	}

	public static void main(String[] args) {

		int arr[][]= takeInput();
		spiralMatrix(arr);
	}
}

