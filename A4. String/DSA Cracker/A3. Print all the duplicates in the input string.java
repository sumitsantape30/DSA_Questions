Print all the duplicates in the input string

Write an efficient program to print all the duplicates and their counts in the input string 

package DSA_Cracker;

import java.util.HashMap;

public class printDuplicate {
	
	static void CharCounts(String str, int[] count) {
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;
	}

	public static void printDups( String str) {
		
		//256 size ka array banayenge and usme har character ka count store karenge
		int count[]= new int[256];
		
		//har characters ka count dhundenge
		CharCounts( str, count);
		
		//ab count array pe traverse karenge aur dekhenge kiska count 1 se jada hai usee print kr denge
		for( int i=0; i< count.length; i++) {
			if( count[i] > 1) {
				System.out.println((char)i+ "count="+count[i]);
			}
		}	
	}
//=========================================================================================

	public static void printDups1( String str) {
		
		//count nam ka hashmap banare jo store karega ki iss character ka count kya hai
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		//apni string pe traverse karenge and jo character nhi hai string mai woh dalenge
		for( int i=0; i< str.length(); i++) {
			if( ! map.containsKey(str.charAt(i))) { //agar woh character nhi hoga map mai to usko dal denge
				map.put(str.charAt(i), 1); //first time dal rhe hai to count 1 rahega
			}else { //agar woh particular character already hai map mai to uska count increse kar denge
				map.put(str.charAt(i), map.get(str.charAt(i)+1));
			}
		}
		
		for( int i = 0; i < map.size(); i++ ) {
			if(map.get(str.charAt(i)) > 1 ) {
				System.out.println(str.charAt(i));
			}
		}
	}
	
  static void main(String[] args) {

	  String str= "GeeksforGeeks";
	  printDups1(str);
		
	}

}
