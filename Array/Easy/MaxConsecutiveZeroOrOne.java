/**
 * Given an array arr[] consisting of only 0’s and 1’s, return count of the
 * maximum number of consecutive 1’s or 0’s present in the array.
 * 
 * Examples:
 * 
 * Input: arr[] = [0, 1, 0, 1, 1, 1, 1]
 * Output: 4
 * Explanation: The maximum number of consecutive 1’s in the array is 4 from
 * index 3-6.
 * Input: arr[] = [0, 0, 1, 0, 1, 0]
 * Output: 2
 * Explanation: The maximum number of consecutive 0’s in the array is 2 from
 * index 0-1.
 * Input: arr[] = [0, 0, 0, 0]
 * Output: 4
 * Explanation: The maximum number of consecutive 0’s in the array is 4.
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 0 ≤ arr[i] ≤ 1
 */

/**
 * Solution:
 * 1. Simple traversal of the array and keep track of the maximum count of consecutive 0's or 1's.
 * 2. Bit manipulation can be used to optimize the solution, but a simple linear scan is sufficient for this problem.
 */

class Solution {
	public int maxConsecBits(int[] arr) {
		// code here
		//IMPORTANT: A single element itself forms a consecutive sequence of length 1.
		int counter = 1;
		int maxCount = 1;
		if (arr.length == 0)
			return 0;
		
		for (int i = 0; i<arr.length - 1; i++) {
			
			if ((arr[i] ^ arr[i + 1]) == 0) {
				counter += 1;
			} else {
				maxCount = Math.max(maxCount, counter);
				counter = 1;
			}
			
		}
		return Math.max(maxCount, counter);
	}
}
