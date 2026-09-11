/**
 * Given an array arr[] of non-negative integers, determine whether the array is
 * perfect. An array is considered perfect if it first strictly increases, then
 * remains constant, and finally strictly decreases. Any of these three parts
 * can be empty.
 * 
 * Examples:
 * Input: arr[] = [1, 8, 8, 8, 3, 2]
 * Output: true
 * Explanation: The array [1, 8, 8, 8, 3, 2] first increases in the range [0,
 * 1], stays constant in the range [1, 3], and then decreases in the range [3,
 * 4]. Thus, the array is perfect.
 * Input: arr[] = [1, 1, 2, 2, 1]
 * Output: false
 * Explanation: The array does not follow the required pattern of strictly
 * increasing, constant, and then strictly decreasing.
 * Constraints
 * 1 ≤ arr.size() ≤ 106
 * 1 ≤ arr[i] ≤ 108
 * 
 * 
 */

/**
 * Solution: Using while loop
 * 1. Use a while loop to traverse the array and check for strictly increasing elements.
 * 2. Use another while loop to check for constant elements.
 * 3. Use a final while loop to check for strictly decreasing elements.
 * 4. If all elements have been processed, return true; otherwise, return false.
 * 
 * Time Complexity: O(n), where n is the size of the array.
 * Space Complexity: O(1), as we are using a constant amount of space.
 * 
 */
class CheckForBitnoicNumbers {
    public boolean isPerfect(int[] arr) {
        // code here
        int n = arr.length; 
		int i = 0;
		// Strictly increasing
		while (i < n - 1 && arr[i] < arr[i + 1]) { i++; }
		// Constant 
		while (i < n - 1 && arr[i] == arr[i + 1]) { i++; }
		// Strictly decreasing
		while (i < n - 1 && arr[i] > arr[i + 1]) { i++; }
		// All elements must have been processed
		return i == n - 1;
    }
}
