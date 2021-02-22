Given a sorted array and a value x, the floor of x is the largest element in array smaller than or equal to x. Write efficient functions to find floor of x.

Examples:
Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 5
Output : 2
2 is the largest element in 
arr[] smaller than 5.

Code:

package CrackerSandS;

public class FloorOfAnElementInSortedArray {
	
	public static int floorSearch( int arr[], int ele) {
		
		int start=0;
		int end= arr.length-1;
		int res=0;
		
		while( start <= end) {
			
			int mid= start + ((end - start)/2);
			
			if( arr[mid] == ele) { //agar middle wala element hi floor hai to woh return karenge
				return mid;
			}
			
			if( arr[mid]< ele) {
				
				res= arr[mid]; //yeh element chota hai ele se to yah element answer hoga yeh bhi possibility hai so usko store karke rakhenge
				start= mid+1;
			}else if( arr[mid]> ele) { //agar mid pe raha element bada hai to yeh candidate nhi rahega so result update nhi karenge
				end= mid-1;
			}
		}
		return res;
	}

	public static void main(String[] args) {

		int arr[]=  { 1, 2, 4, 6, 10, 12, 14 };
		int x= 7;
		int result= floorSearch(arr, x);
		System.out.println(result);
		
	}

}
