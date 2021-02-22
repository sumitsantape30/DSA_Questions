Given an integer x, find it’s square root. If x is not a perfect square, then return floor(√x).

Examples :

Input: x = 4
Output: 2
Explanation:  The square root of 4 is 2.

Input: x = 11
Output: 3
Explanation:  The square root of 11 lies in between
3 and 4 so floor of the square root is 3.
 
Code:

package CrackerSandS;

public class SquareRootOfNumber {
	
	//mai 0 se leke n tak ke bich mai numbers hai unko khudse multiply karke dekhunga kya unka multplication means sequare given number se equal hai
	public static int squareRoot(int n) {
		
		if( n == 0 || n== 1) {  //agar given number 0 ya 1 hai to uska square root wahi hai
			return n;
		}
		
		int start=0;
		int end= n;
		int ans=0;
		
		while( start <= end) {
			
			int mid= start + (end- start)/2;
			
			if( mid* mid == n) { //agar jo mid aya uska multiplication n ke equal hai to wahi humara answer hai
				return mid;
			}
			
			if( mid*mid < n) {
				start= start+1;
				ans= mid; //muje aisa number mila hai jiska square root n se kam hai to possibility hai ki yeh bhi mera anser ho skta hai agar iske wale number ka square given number se jada hai
			}else {
				end=  mid-1;
			}
		}
		return ans;	//last mai ans return karenge
	}

	public static void main(String[] args) {

		int n= 10;
		int result= squareRoot(n);
		System.out.println(result);
	}

}
