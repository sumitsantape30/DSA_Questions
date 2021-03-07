package DSA_Cracker;

import java.util.Scanner;

public class ValidShuffleOf2Strings {
	
	
	public static boolean checkShuffle( String str1, String str2, String res) {
		
		// teeno strings ke length nikaenge
		int l1= str1.length();
		int l2= str2.length();
		int lr= res.length();
		
		//length of the result string should be equal to the summation of length of s1 and s2
		if( l1 + l2 != lr) {
			return false;
		}
		
		//ab  teen poinyers lengt i s1 ka pointer hai j s2 ka pointer hai and k reseultant ka pointer hai
		int i=0;
		int j=0;
		int k=0;
		
		//jabtak resultant ke last tak nhi pohoch jata tabtak kam karenge
		while( k < lr) {
			// mera i bhi s1 length ke tak hi jana chahiye na 
			if( i < l1 && str1.charAt(i)== res.charAt(k)) { //agar first string ka character same hai resultant string ke first character se to i ko aage badhayenge
				i++;
			}// agar first string ka first character match nhi hua to second string ka first character check karenge
			else if( j < l2 && str2.charAt(j) == res.charAt(k)) {
				j++;
			}else { // agar result string ka ek character match hi nhi hua dono strings se matlab woh hai hi nhi isme so return false
				return false;
			}
			//maine resultant string ka first character check karliya ab usko second character check karenge so increase k
			k++;
		}
		
		//agar dono string ke saare characters check karne ke bad bhi kuch elements bache hai haai koi string mai to return false karenge coz woh character resultant mai tha hi nhi isliye bach gya
		if( i < str1.length() || j< str2.length()) {
			return false;
		}
	    return true; //agar milgya tabhi yaha pahuchenge so return kardenge
	}
	

	public static void main(String[] args) {

		String str1="XY";
		String str2= "12";
		String res= "1XY2";
		boolean ans= checkShuffle(str1, str2, res);
		System.out.println(ans);
	}
}
