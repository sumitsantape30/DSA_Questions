A Program to check if strings are rotations of each other or not.
Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
(eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)

package DSA_Cracker;

import java.util.Scanner;

public class StringIsRotationOfAnotherString {
	
	public static String takeInput() {
		
		Scanner s= new Scanner(System.in);
		String str= s.next();
		return str;
	}
	
	public static boolean checkString( String str1, String str2) {
		
		int l1= str1.length();
		int l2= str2.length();
		
		if( l1 == l2) {
			
			String temp= str1+ str1;
			if( temp.indexOf(str2) != -1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		String str1= takeInput();
		String str2= takeInput();
		boolean ans= checkString(str1, str2);
		System.out.println(ans);
		
	}

}
