/**
 * Given an array arr1. The contents of arr are copied into another array arr2
 * and numbers are shuffled. Also, one element is removed from arr2. The task is
 * to find the missing element.
 * 
 * Examples:
 * Input: arr1[] = [4, 8, 1, 3, 7] and arr2[] = [7, 4, 3, 1]
 * Output: 8
 * Explanation: 8 is the only element missing from arr2.
 * Input: arr1[] = [12, 10, 15, 23, 11, 30] and arr2[] = [15, 12, 23, 11, 30]
 * Output: 10
 * Explanation: 10 is the only element missing from arr2.
 * Constraints:
 * 2 <= arr1.size() <= 106
 * arr2.size() = arr1.size() - 1
 * 1 <= arr1[i] <= 106
 */

/**
 * Solution explanation: using sorting
 * 1. Sort both arrays in ascending order.
 * 2. Iterate through both arrays and compare the elements at the same index.
 * 3. If xor of the elements is 0, continue to the next index. If not, return the element from arr1.
 * 4. If all elements are the same, return the last element of arr1 as
 * the missing element.
 * 
 * Time Complexity: O(n log n) where n is the size of arr1 due to sorting.
 * Space Complexity: O(1) if we sort in place, otherwise O(n) for storing the sorted arrays.
 */
import java.util.Arrays;
class MissingElement {
	public int findMissing(int[] arr1, int[] arr2) {
		// code here
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for (int i = 0; i<arr1.length - 1; i++) {
			int xor = arr1[i] ^ arr2[i];
			if (xor == 0) {
				continue;
			} else {
				return arr1[i];
			}
		}
		return arr1[arr1.length - 1];
	}
}
