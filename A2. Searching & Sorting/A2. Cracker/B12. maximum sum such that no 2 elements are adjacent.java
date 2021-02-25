Stickler Thief 
Stickler the thief wants to loot money from a society having n houses in a single line. He is a weird person and follows a certain rule when looting the houses. According to the rule, he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy. He asks for your help to find the maximum money he can get if he strictly follows the rule. Each house has a[i] amount of money present in it.

Example 1:
Input:
n = 6
a[] = {5,5,10,100,10,5}
Output: 110
Explanation: 5+100+5=110

Example 2:
Input:
n = 3
a[] = {1,2,3}
Output: 4

Code:
package CrackerSandS;

public class Sumsuchthatno2eleareAdjacent {
	
	public static int solve( int arr[], int i) {
		
		if( i <= -1) {
			return 0; //agar hum array ke bahar ho chuke hai to wahase kuch mila nhi hume so return 0
		}
		
		if( dp[i] != -1) {
			
		}
		
		//option 1
		int op1= arr[i]+ solve(arr, i-1); //first option mai woh element include kiye and do bar jum karwaye coz next element lena nhi hai isliye iske aage bhejdo
		int op2= solve(arr, i-1); // hum current element include nhi karre to usko aage shift kar denge matlab piche bhejdo coz maine piche se start kiya
		
		//in dono mese jo max hoga woh answer hai
		return Math.max(op1,  op2);
		
		
		
	}

	public static void main(String[] args) {

		int dp[]= {5,5,10,100,10,5};
		int n= dp.length;
		solve(n-1, dp); //hum pichese dekhte aare
		
	}

}
