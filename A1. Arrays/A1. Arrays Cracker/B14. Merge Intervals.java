Merge Inrervals / Merge Overlapping Subintervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 Code:
package ArraysCracker;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;

class Pair implements Comparable<Pair>{ //hum ek pair class banayenge jisme start time and end time rahega. (about comparator: hume java ko batana padega ki kis object ko chota manna hai and kis object ko bda, so usne bola agar aap kabhi kisi object ke chote bade ka aihsas karna chahte ho uss object ke upar implements Comparable<> likhenge
     //yeh interface hota hai yeh hum implment kar rhe hai, hum pair of comparable nam ka interface implement karenge means hume ek function dalna padega
	int st;
	int et;
	
	public Pair(int st, int et) {
		this.st= st;
		this.et= et;
	}
	
	//yaha pr do object compare ho rhe hai, ek object "this" hai and dusra "other", ek object humasha this hota hai dusra other hai jo parameter mai pass hua hai
	//iss function ka kam kya hota hai? agar hum smjhte hai this bada hai other se ( this > other ) to hum return karenge +ve value 
	// agar apko lagta hai this and other equal hai to hum return karenge zero, this== other return 0
	//agar this> other then we will return negative value
	public int compareTo( Pair other) {
		if( this.st != other.st) { //agar dono ke start time equal nhi hai 
			return this.st - other.st; //isse dono ka starting point barabr hua to 0 return hojayega means equal man liya jayega same with other two options as well
			//jiska start time chota usko array pehle rakh lega sort hone ke bad
		} else { //other wise dono ka start time barabr hai to mai end time pe sort kardunga
			return this.et - other.et;
		}
		
	}
}

public class MergeIntervals {
	
	public static void mergeOverlappigIntervals(int arr[][]) {
		//mai chahta hu yeh sort ho ske, jab aap ek array of pair ko sort karna chahte hai to apko uspe comparable of pair implement karna padta hai
		
		//sabse pehle pairs ka array banayenge
		Pair pairs[]= new Pair[arr.length];
		
		//fir hum apne array pe loop lagayenge
		for( int i=0; i< arr.length; i++) {
			pairs[i]= new Pair(arr[i][0], arr[i][1] ); //iss array ke 0 mai start time diya hai and 1 mai end time diya gya hai
		}
		
		//ab humare pas pairs ka array aa chuka hai ab mai chahta hu pairs ka array sort hojayeg, aur start time pe sort hojaye to woh hume btana padega
		//integers ka array hota to java sort kardeti but yeh objects ka array hai so java sort nhi kr skti coz java ko pta hi nhi konsa object bda konse object chota to hume java ko btana padega ki kis object ko chota manna hai and kis object ko bada manna hai woh btana keliye javane hume comparator diya hai, look at the pair class.
		Arrays.sort(pairs);
		Stack<Pair> st= new Stack<Pair>();
		//array sort ho chuka hai ab hume push karna hai
		for( int i=0; i< pairs.length; i++) {
			if( i ==0) { //agar i zero hai  means pehla banda hai to usko aisehi push kar denge
				st.push(pairs[i]);
				
			}else { //agar i zero nhi hai means dusra banda hai to hum dekhenge top pe kon hai 
				
				Pair top= st.peek();
				
				if( pairs[i].st > top.et) { //jo banda abhi aa rha hai agar uska start time bada hai top pe jo hai uske end time se to yeh push hojayega
					st.push(pairs[i]);
				}else { 
					//otherwise jo top pe pda hai usike end time ko update karenge means merge karre, to merge karre to end time change so jiska maximum end time hoga woh humara end time hoga
					top.et= Math.max(top.et, pairs[i].et);
				}
			}
		}
		
		//humari stoack tayar hogyi hai but hume incresing order mai print karna hai isliye ek aur stack ki jarurat padegi
		Stack<Pair> rs= new Stack<Pair>();
		
		while( !st.isEmpty() ) { //humara pehla stack jabtak khali nhi hota tabtak pop krte rahenge and wahi elements new wale stack mai dal deng
			rs.push(st.pop());
		}
		
		//hum humare new stack mai increasing order mai elements aagye hai
		while( !rs.isEmpty()) {
			Pair p= rs.pop();
			System.out.println(p.st +"-"+p.et);
		}
		
	}
	

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[][]= new int[n][2];
		
		for( int i=0; i<n ; i++) {
			arr[i][0]= s.nextInt();
			arr[i][1]= s.nextInt();
		}
		mergeOverlappigIntervals(arr);
	}

}
