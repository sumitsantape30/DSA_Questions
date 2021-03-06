Palindrome String 

Given a string S, check if it is palindrome or not.

Example 1:

Input: S = "abba"
Output: 1
Explanation: S is a palindrome
Example 2:

Input: S = "abc" 
Output: 0
Explanation: S is not a palindrome

package DSA_Cracker;

import java.util.Scanner;

public class CheckPalindrome {
	
	public static String takeInput() {
		
		Scanner s= new Scanner(System.in);
		String str= s.next();
		
		return str;
	}
	
	//string ke reverse krke reversed string ko original string ke sath compare karenge
	public static boolean checkPalin( String str) {
		
		int i= 0;
		String rev="";
		
		for( i= str.length()-1; i>= 0; i--) {
			rev= rev +str.charAt(i);
		}
		
		if( rev.equals(str)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//agar charcter array input rha to aise kr skte hai
	public static boolean checkPalindrom( char[] str) {
		
		int start=0;
		int end= str.length-1;
		
		while( start <= end) {
			
			if(str[start] != str[end] ) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		String str= takeInput();
		boolean ans= checkPalin(str);
		System.out.println(ans);
	}

}
