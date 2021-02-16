Find if there is a subarray with 0 sum

Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.

Examples : 

Input: {4, 2, -3, 1, 6}
Output: true 
Explanation:
There is a subarray with zero sum from index 1 to 3.

Input: {4, 2, 0, 1, 6}
Output: true 
Explanation:
There is a subarray with zero sum from index 2 to 2.

Input: {-3, 2, 3, 1, 6}
Output: false

Code:

package ArraysCracker;

import java.util.Scanner;
import java.util.HashMap;

public class Subarraywith0Sum {
	
	public static int[] takeInut() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i<arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int SubarraywithZeroSum( int arr[] ) {
		
		//hashmap banaunga integer vs integer ka as hum uski sum and index store karre honge, basically yeh hashmap index ke against sum represent krta hai
		HashMap<Integer,Integer> map= new HashMap<Integer, Integer>();
		
		//mera 0 sum -1 index pe aya tha
		int i= -1; 
		int sum=0;
		int maxlen=0;
		
		//map mai initially mera sum 0 rahega at index -1
		map.put(sum, -1 );
		
		while(i < arr.length-1 ) { //pichle element tak hi loop chalayenge, coz agar hum last element e hai to iss loop mai enter hone ke bad hum i++ kkarre usse i array ke bahar chala jayega isliye arr.length-1 lere
			i++;// harbar mai i ko ek se badhaunga
			//har bar hum naya sum calculate karenge
			sum += arr[i];
			
			//ab mai dekhunga ki kya yeh sum map pehlese pada hua hai ya nhi
			if( map.containsKey(sum) == false){ //matalb agar map ke andar woh sum nhi hai means pehli bar aya hai to i index ke samne yeh sum daldenge
				map.put( sum,i);
			}else { //agar map mai yeh already pada hai to pta karo kaha tha pichli bar, so length ayaegi i minus kaha the yah sum pehle
				int len= i - map.get(sum);
				
				if( len > maxlen) {
					maxlen= len;
				}
				
			}
			
		}
		return maxlen;
	}

	public static void main(String[] args) {

		int arr[]= takeInut();
		SubarraywithZeroSum(arr);
		
	}

}
