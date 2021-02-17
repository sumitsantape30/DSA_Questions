Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers,
the consecutive numbers can be in any order. 

Examples:  
Input: arr[] = {1, 9, 3, 10, 4, 20, 2}

Output: 4
Explanation: 
The subsequence 1, 3, 4, 2 is the longest 
subsequence of consecutive elements


Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
Output: 5
Explanation: 
The subsequence 36, 35, 33, 34, 32 is the longest 
subsequence of consecutive elements.

Code:

package ArraysCracker;

import java.util.Scanner;
import java.util.HashMap;

public class LongestConsecutiveSequeunce {
	
	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void sequence(int arr[]) {
		
		//sabse pehle hum hashmap declare karenge integer vs boolean ka, yeh boolean yeh represent karta hai ki yaha se sequence start hota hai ya nhi aur hum shuruwat mai true dalne wale hai
		HashMap<Integer, Boolean> map= new HashMap<Integer, Boolean>();
		
		//hum initially sabsko true karre ki ha tum bhi seqeunce ki shuruwat ho but yeh sach bta nhi hai
		for( int val: arr) {
			map.put(val, true);
		}
		
		//ab lagayenge dusra loop ab ki agar map mai values se ek chota pda hai to woh value start of sequence nhi hot skta so usko false kardenge, isse sirf woh log true reh jayenge jinse chota element nhi hai to woh start of sequence ban jayenge. Wahi true rahenge baki sare false hojayenge
		for( int val: arr) {
			map.put(val, false);
		}
		
		//ab lagayenge teesra loop isme hum unhi keliye kam karenge jinki value true hai matlab jo start of sequence hai unke liye hi kam karenge baki ke liye kam nhi karenge
		int msp=0;
		int ml=0;
		for( int val: arr) {
			if( map.get(val)) {
				int tl= 1; //temporary length;
				int tsp= val; //temporary start point will be this val only
				//maine do variables banaye ki abhi jo temporary sequence hai woh val se start hoga and uski length 1 hai
				
				while(map.containsKey(tsp+ tl)) { //jabtak yeh milta rahega means jabtak ek val ke next wala jabtak milta rahega to temporary length ko badhate rahenge means sequence ko badhate rahenge
					tl++;	
				} //jis waqt nhi milega us waqt sequence bahar aajayega
				
				//agar meri yeh temporary length max length ko hara deti hai to max start point updata hojayege
				if( tl > ml) {
					msp= tsp; // max start point mai aajyega temporary start point
					ml= tl; // and max length mai ajayega temporary length
					
				}
			}
		}
		
		//loop se bahar aakar ab humare pas max start point aur maximum length wali sequence hai ab usko print kardenge
		for( int i =0; i< ml; i++) {
			System.out.println(msp+ i);
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		sequence(arr);
	}
}
