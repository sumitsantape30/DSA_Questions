Maximum consecutive one’s (or zeros) in a binary array
Difficulty Level : Easy
 Last Updated : 22 May, 2018
Given binary array, find count of maximum number of consecutive 1’s present in the array.

Examples :

Input  : arr[] = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1}
Output : 4

Input  : arr[] = {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}
Output : 1
  
Code:
public static int findMaxConsecutives( int nums[]) {
		
		//we initialise count and max to 0
		int cnt=0;
		int maxi=0;
		
		//after that we have to iterate over the array
		for( int i=0; i< nums.length; i++) {
			
			//whenever the number is 1 we'll increse the counter
			if( nums[i] == 1) {
				cnt++;
			}else { // when it is pointing to zero we'll make count to zero
				
				cnt=0;
			}
			
			//then we check if computed count is grater than maxi or not if it is then we relace it by maximum
			maxi = Math.max(maxi, cnt);
		}
		return maxi;
		
	}
