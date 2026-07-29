/**
 * Given an array arr[], check whether it is sorted in non-decreasing order.
 * Return true if it is sorted otherwise false.
 * 
 * Examples:
 * 
 * Input: arr[] = [10, 20, 30, 40, 50]
 * Output: true
 * Explanation: The given array is sorted.
 * Input: arr[] = [90, 80, 100, 70, 40, 30]
 * Output: false
 * Explanation: The given array is not sorted.
 * Constraints:
 * 1 ≤ arr.size ≤ 106
 * - 109 ≤ arr[i] ≤ 109
 */
/**
 * Solution: 1. iterate through the array and check if the current element is
 * greater than the next element. If it is, return false. If the loop completes
 * without finding any such pair, return true.
 * 2. We can also use the built-in function Arrays.sort() to sort the array and
 * then compare it with the original array. If they are equal, return true,
 * otherwise return false.
 */

class Solution {
	public boolean isSorted(int[] arr) {
		// code here
		int n = arr.length;
		
		for (int i = n - 1; i>0; i--) {
			if (arr[i] >= arr[i - 1]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
