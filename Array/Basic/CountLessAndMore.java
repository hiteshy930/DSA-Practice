/**
 * Given a sorted array arr[] and a value target, return an array of size 2. The
 * first value is the number of elements less than or equal to the target, and
 * the second value is the number of elements greater than or equal to the
 * target.
 * 
 * Examples:
 * 
 * Input: arr[] = [1, 2, 8, 10, 11, 12, 19], target = 0
 * Output: [0, 7]
 * Explanation: There are no elements less or equal to 0 and 7 elements greater
 * to 0.
 * Input: arr[] = [1, 5, 8, 12, 12, 12, 19], target = 12
 * Output: [6, 4]
 * Explanation: There are 6 elements less or equal to 12 and 4 elements greater
 * or equal to 12.
 * Constraints:
 * 1 ≤ arr.size ≤ 105
 * 0 ≤ arr[i], target ≤ 106
 */

/**
 * Solution:
 * 1. Create two counters, countLess and countMore, initialized to 0.
 * 2. Iterate through the array and for each element, check if it is less than
 * or equal to the target. If it is, increment countLess. If it is greater than
 * or equal to the target, increment countMore.
 * 3. Create an array of size 2 and store countLess at index 0 and countMore at
 * index 1.
 * 4. Return the array containing the counts.
 */
class CountLessAndMore {
	int[] getMoreAndLess(int[] arr, int target) {
		// code here
		int n = arr.length;
		
		int countMore = 0;
		int countLess = 0;
		
		for (int num : arr) {
			if (num <= target)
				countLess++;
			if (num >= target)
				countMore++;
		}
		
		int temp[] = new int[2];
		temp[0] = countLess;
		temp[1] = countMore;
		
		return temp;
		
	}
}
