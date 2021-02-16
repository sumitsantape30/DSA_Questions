You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

 //=====================================================Approach 1==============================================
 package ArraysCracker;

import java.util.Scanner;

public class buyAndsellStocks {
	
	public static int[] takeInput() {
		Scanner s=new Scanner(System.in);
		int n= s.nextInt();
		
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int profit(int prices[]) {
		
		int maxProfit= 0;
		
		for( int i=0; i< prices.length - 1; i++) {
			for( int j = i+ 1; j< prices.length; j++) {
				int profit= prices[j] - prices[i];
				if( profit > maxProfit) {
					maxProfit= profit;
				}
			}
		}
		return maxProfit;
	}
	public static void main(String[] args) {

		int arr[]= takeInput();
		int maxProfit= profit(arr);
		System.out.println(maxProfit);
		}
}

 //================================================== Approach 2=============================================================
 package ArraysCracker;

import java.util.Scanner;

public class buyAndsellStocks {
	
	public static int[] takeInput() {
		Scanner s=new Scanner(System.in);
		int n= s.nextInt();
		
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int maxProfit( int prices[]) {
		
		int minPrice= Integer.MAX_VALUE; //we store minimal as integer.max value
		int maxprofit= 0; //we set the max profit as zero
		
		for( int i=0; i< prices.length; i++) { //we traverse for the entire prices of stocks and we keep updating the minimal prize if it is minimum
			if( prices[i] < minPrice) {
				minPrice= prices[i];
				
				//after that if you see profit made is greater than the max profit you stored, you simply update the max profit
			}else if( prices[i] - minPrice > maxprofit) {
				maxprofit= prices[i] - minPrice;
			}
		}
		return maxprofit;
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int profit= maxProfit(arr);
		System.out.println(profit);
		}
}
