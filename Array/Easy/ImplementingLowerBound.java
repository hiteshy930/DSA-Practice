/**
 * Given a sorted array arr[] (following 0-based indexing) and a number target, find the lower bound of the target in this given array. The lower bound of a number is defined as the smallest index in the sorted array where the element is greater than or equal to the given number.

 * Note: If all the elements in the given array are smaller than the target, the lower bound will be the length of the array. 

 * Examples :

 * Input:  arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
 * Output: 3
 * Explanation: 3 is the smallest index in arr[] where element (arr[3] = 10) is greater than or equal to 9.
 * Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 11
 * Output: 4
 * Explanation: 4 is the smallest index in arr[] where element (arr[4] = 11) is greater than or equal to 11.
 * Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 100
 * Output: 7
 * Explanation: As no element in arr[] is greater than 100, return the length of array.
 *
 *  Constraints:
 * 1 ≤ arr.size() ≤ 106
 * 1 ≤ arr[i] ≤ 106
 * 1 ≤ target ≤ 106
 */

/**
 * Solution Approach:
 * 1. Initialize a variable lowerBound to Integer.MAX_VALUE and index to 0.
 * 2. Iterate through the array arr[] using a for loop.
 * 3. For each element arr[i], check if it is greater than or equal to
 * the target and less than the current lowerBound.
 * 4. If the condition is satisfied, update lowerBound to arr[i] and index
 * to i.
 * 5. After the loop, check if lowerBound is still Integer.MAX_VALUE.
 * If it is, return the length of the array as no element is greater than or equal
 *  to the target.
 * 6. Otherwise, return the index of the lower bound.
 * 
 * Time Complexity: O(n), where n is the size of the array arr[].
 * Space Complexity: O(1), as we are using only a constant amount of extra space.
 */

class ImplementingLowerBound {
	int lowerBound(int[] arr, int target) {
		// code here
		int n = arr.length;
		int index = 0;
		int lowerBound = Integer.MAX_VALUE;
		boolean isFound = false;
		for (int i = 0; i<n; i++) {
			if (arr[i] >= target && arr[i] < lowerBound) {
				lowerBound = arr[i];
				index = i;
				isFound = true;
			}
		}
		
		if (!isFound)
			return n;
		
		return index;
	}
}
