Maximum and minimum of an array using minimum number of comparisons

Write a function to return minimum and maximum in an array. Your program should make the minimum number of comparisons. 
Approach 1: We'll sort the array, and our first element will be min and last element will be max, but it'll will take O(nlogn) so below we have approaches that uses O(n) time

//============================= Approach 2 (Simple Linear Search by using Pair class) ================================

package ArraysCracker;
import java.util.Scanner;

class Pair {
	int min;
	int max;
}

public class minAndmaxOfArray {

	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int arr[]= new int[n];
		for( int i=0; i< n; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	//humara iss Pair mai dono minimum and maximum hai and yeh dono values return karega
	public static Pair getMinMax(int arr[]) {
		
		Pair minmax= new Pair(); //sabse pehle ek pair banayenge, iss pair mai mere min and max dono hai, 
		
		//agar humare array ki size agar 1 hai to wahi humara min and wahi max hai to hum woh values pair ke min and max mai dalkar apni pair return kar denge
		int n= arr.length;
		if( n == 1) {
			minmax.max= arr[0];
			minmax.min= arr[0];
			return minmax;
		}
		
		//but agar humare array mai 1 se jada elements hai to hum first two elements ko compare krke min and max initialise karna hai
		if( arr[0] > arr[1]) {
			minmax.min= arr[1];
			minmax.max= arr[0];
		}else {
			minmax.max= arr[1];
			minmax.min= arr[0];
		}
		
		//iske bad hum apna loop run karenge fron 2th index to end and will compare al the elements with out min and max agar woh first two elements se minimim or maximum hai to hum apne min and max ko updata kar denge
		for( int i=2; i< n; i++) { //loop is running for n-2, and for every interation we have two operations there so in this problem total comparisons are 2*(n-2) + 1
			
			if( arr[i] > minmax.max) {
				minmax.max= arr[i];
			}else if( arr[i] < minmax.min ) {
				minmax.min= arr[i];	
			}
		}
		return minmax; //last mai hum apni pair return kar denge
	}
	
	
	public static void main(String[] args) {

		int arr[]= takeInput();
		Pair minmax= getMinMax(arr);
		System.out.println(minmax.min);
		System.out.println(minmax.max);
	}

}

Output:
6
1000 11 445 1 330 3000
1
3000

Time Complexity: O(n)

//================================= Approach 3=================================================
// agar even number of elements hai to first two elements ke min and max ko as minimum and maximum initialise karenge.
//agar odd number of elements hai to initialse min and max as first element, and baki elements ko pick them in pairs and compare their maximum and minimum with max and min respectively. 
// even number of elements hai aur hum pair mai pick karke compare karre isliye first two ko min max assume kiya taki last mai koi element bach na jaye. Aur odd number of elements hai to sirf first element ko min max assume karre taki bache hue elements mai pair wise compare ho ske.
	
	package ArraysCracker;
import java.util.Scanner;

class Pair{
	int min;
	int max;
}

public class minAndmaxOfArray2 {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static Pair getminmax( int arr[]) {
		
		Pair minmax= new Pair();
		
		int i = 0; //i rakh rhe, agar mere array mai even elements hai to mai array ko do elements chhodke start karunga else odd hai to mai array ko ek element chhodke start karunga
		int n= arr.length;
		
		if( n % 2 ==0) { //agar mere array mai even number of elements hai to mai first two elements ko min max se initialize karunga aur mera i 2 se increment hoga coz mera array even hai aur hum niche pair wise compare karre to puri tarah se compare hona chahiye isliye
			if( arr[0] < arr[1]) {
				minmax.min= arr[0];
				minmax.max= arr[1];
			}else {
				minmax.min= arr[1];
				minmax.max= arr[0];
			}
			 i +=2; //setting the starting index for the loop
		}else { //agar mere array mai odd elements hai to mai first element kohi min and max manunga
			
			minmax.min= arr[0];
			minmax.max= arr[0];
			
			i=1; //setting the starting index for the loop
		}
		
		//ab loop mai do do elements ki pair pick karnge aur min and max ke sath compare karenge
		while( i < n-1) {
			
			if( arr[i]> arr[i+1]) {
				
				if( arr[i]> minmax.max) {
					minmax.max= arr[i];
				}
				
				if( arr[i+1] < minmax.min) {
					minmax.min= arr[i+1];
				}
			}else {
				
				if( arr[i+1] > minmax.max) {
					minmax.max= arr[i+1];
				}
				
				if(arr[i] < minmax.min) {
					minmax.min= arr[i];
				}
				
			}
			i +=2; //i ko 2 se increment karenge as hum do do elements ko compare karre	
		}
		return minmax;
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		Pair minmax= getminmax(arr);
		
		System.out.println(minmax.min);
		System.out.println(minmax.max);
	}

}
