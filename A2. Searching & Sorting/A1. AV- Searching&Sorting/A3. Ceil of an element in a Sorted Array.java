Ceiling in a sorted array

Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x.

Examples :
For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8
For x = 20:   floor  = 19,  ceil doesn't exist in array

Code:

package CrackerSandS;

public class CeilOfTheElementInSortedArray {

	public static int ceilOfAnEle(int arr[], int ele) {

		int start = 0;
		int end = arr.length - 1;
		int ans = 0;

		while (start <= end) {

			int mid = start + ((end - start) / 2);

			if (arr[mid] == ele) { // agar element muje array mai mil gye to wahi uska floor and wahi ceil hai
				return arr[mid];
			}

			else if (arr[mid] < ele) { // aisa hua to muje right side mai jana hai aur mai result ko store nhi karunga
				start = mid + 1;
			} else if (arr[mid] > ele) { // aisa hua to ele mera candidate rahega so usko ans mai store karenge
				ans = arr[mid]; // isliye store karre coz possibility hai ki yahi ceil hoga
				end = mid - 1;
			}

		}
		return ans;

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
		int n = 8;
		int ans = ceilOfAnEle(arr, n);
	}
}
