Find four elements that sum to a given value | Set 1 (n^3 solution)

Given an array of integers, find all combination of four elements in the array whose sum is equal to a given value X.
For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and X = 23, then your function should print “3 5 7 8” (3 + 5 + 7 + 8 = 23).

Code:

//================================================ Approach 1============================================================================

package CrackerSandS;

public class FourSumNumbers {

	public static void forSumNum(int arr[], int x) {

		int n = arr.length;

		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				for (int k = j + 1; k < n - 1; k++) {
					for (int l = k + 1; l < n; l++) {
						if (arr[i] + arr[j] + arr[k] + arr[l] == x) {
							System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[l]);
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		int arr[] = { 10, 20, 30, 40, 1, 2 };
		int x = 91;
		forSumNum(arr, x);
	}
}

Time Complexity: O(n^4)
	



