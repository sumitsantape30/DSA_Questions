Given an array of size n and a number k, find all elements that appear more than n/k times
Given an array of size n, find all elements in array that appear more than n/k times. 
For example, if the input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4, then the output should be [2, 3]. Note that size of array is 8 (or n = 8), 
so we need to find all elements that appear more than 2 (or 8/4) times. There are two elements that appear more than two times, 2 and 3. 

 Code:
package ArraysCracker;

import java.util.Scanner;



public class ElementThatApprearsMore {
	
	static class eleCount{
		int element;
		int count;
	}
	
	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]=new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void moreThanNdK( int arr[],int n, int k) {
		
		if(k <2) { //agar K ki value 2 se kam hai means 1 hai yah 0 hai t obviously koi bhi element nhi hoga jo n times aaye ( if k==0 rha to invalid case hai and k==1 to n/k ==n meant to say sare elements n times hi nhi aa skte)
			return;
		}
		
		//hum k-1 ka ek array banayenge
		eleCount temp[]= new eleCount[k-1];
		
		for( int i=0; i< k-1 ; i++) {
			//we'll intialise these values and unke count ko zero kar denge means ahitak koi bhi value nhi hai
			temp[i]= new eleCount();
			temp[i].count=0; 
		}
		
		//fir hum zero se leke n tak loop chalayenge aur jth loop ke help se check karenge ki agar kahipe bhi hume element milta hai uss array(container) ke andar koi bhi aise value milti hai jiska element current array ke element se barabr hai to 
		for( int i=0; i<n ; i++) {
			
			int j;
			for( j=0; j< k-1; j++) {
				
				if(temp[j].element == arr[i]) { // uss array(container) ke andar koi bhi aise value milti hai jiska element current array ke element se barabr hai to uski count ko ek se badha denge aur break kardenge loop
					temp[j].count +=1;
					break;
				}
			}
			
			//agar humara j loop last tak chala gya hume koi bhi element nhi mila hai waisa to ho skta hai ya to array khali ho or saare bhare hue ho
			if( j == k-1) {
				int l;
				
				//so hum ab check karenge ki kahi count khali milti hai that means
				for(l =0; i< k-1; l++) {
					if( temp[l].count == 0) { //check karenge ki kahi count khali milti hai that means first vacant space jaha bhi milta hai waha hum uss element ko rakh denge aur uski count ko 1 kar denge
						temp[l].element= arr[i];
						temp[l].count=1;
						break;
					}
				}
			
				
				//agar humara l bhi last tak chala jata hai that means hume koi bhi vacant soace nhi mila humara array puri tarah se filled hai to hum loop chalayenge l=0 se l= k-1 tak
			if( l == k-1) {
				for( l=0; l <k-1; l++) { //loop chalayenge and jitne bhi elements hai array ke andar uski count ko ek ek krke reduce krte jayenge
					temp[l].count -= 1;
					}
				}
			}
		}
		
		for( int i=0; i<k-1 ; i++) { 
			int actual=0; //ab k-1 tak loop chlalayenge aur dekhana hai uski actual index kitni hai
			
			//so hum jth loop se dekhenge pure loop mai, woh jitni bar bhi ayi hai actual ko ++ karenge
			for( int j=0; j<n; j++) {
				if( arr[j] == temp[i].element) {
					actual++;
				}
			}
			
			if( actual >= n/k) { //agar actual value n/k se jada ya barabr hai to hum usko print kara denge
				System.out.println(temp[i].element);
			}
		}
			
	}
	

	public static void main(String[] args) {

		int arr[]= takeInput();
		int n=arr.length;
		moreThanNdK(arr, n, 3);
	}

}

  
