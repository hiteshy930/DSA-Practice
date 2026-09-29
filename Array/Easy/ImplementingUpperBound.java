/**
 * Given a sorted array arr[] and a number target, the task is to find the upper bound of the target in this given array.
 * The upper bound of a number is defined as the smallest index in the sorted array where the element is greater than the given number.
 * 
 * Note: If all the elements in the given array are smaller than or equal to the target, the upper bound will be the length of the array.
 * 
 * Examples :
 * 
 * Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
 * Output: 3
 * Explanation: 3 is the smallest index in arr[], at which element (arr[3] = 10) is larger than 9.
 * Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 11
 * Output: 6
 * Explanation: 6 is the smallest index in arr[], at which element (arr[6] = 25) is larger than 11.
 * Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 100
 * Output: 7
 * Explanation: As no element in arr[] is greater than 100, return the length of array.
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * 1 ≤ arr[i] ≤ 106
 * 1 ≤ target ≤ 106
 */

/**
 * Solution: Using a linear search approach to find the upper bound of the target 
 *    in the given sorted array.
 * 1. Initialize a variable upperBound to Integer.MIN_VALUE and index to 0.
 * 2. Iterate through the array arr[] using a for loop.
 * 3. For each element arr[i], check if it is greater than the target and
 *    greater than the current upperBound.
 * 4. If the condition is satisfied, update upperBound to arr[i] and index to i, 
 *    and break the loop as we found the upper bound.
 * 5. After the loop, check if upperBound is still Integer.MIN_VALUE.
 *    If it is, return the length of the array as no element is greater than the target
 * 6. Otherwise, return the index of the upper bound.
 * 
 * Time Complexity: O(n), where n is the size of the array arr[].
 * Space Complexity: O(1), as we are using only a constant amount of extra space
 * 
 */
class ImplementingUpperBound {
    int upperBound(int[] arr, int target) {
        // code here
        int n = arr.length;
			int index = 0;
			int upperBound = Integer.MIN_VALUE;
			boolean isFound = false;
			for (int i = 0; i<n; i++) {
				if (arr[i] > target && arr[i] > upperBound) {
					index = i;
					isFound = true;
					break;
				}
			}

			if (!isFound)
				return n;

			return index;
    }
}


