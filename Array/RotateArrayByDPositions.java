/**
 * Given an array arr[]. Rotate the array to the left (counter-clockwise
 * direction) by d steps, where d is a positive integer. Do the mentioned change
 * in the array in place.
 * 
 * Note: Consider the array as circular.
 * 
 * Examples :
 * 
 * Input: arr[] = [1, 2, 3, 4, 5], d = 2
 * Output: [3, 4, 5, 1, 2]
 * Explanation: when rotated by 2 elements, it becomes [3, 4, 5, 1, 2].
 * Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3
 * Output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]
 * Explanation: when rotated by 3 elements, it becomes [8, 10, 12, 14, 16, 18,
 * 20, 2, 4, 6].
 * Input: arr[] = [7, 3, 9, 1], d = 9
 * Output: [3, 9, 1, 7]
 * Explanation: when we rotate 9 times, we'll get [3, 9, 1, 7] as resultant
 * array.
 * Constraints:
 * 1 ≤ arr.size(), d ≤ 105
 * 0 ≤ arr[i] ≤ 105
 * 
 * Soutions: 
 * using Reversal Algorithm - O(n) Time and O(1) Space 
 * Using juggling algorithm - O(n) Time and O(1) Space
 * using temporary array - O(n) Time and O(d) Space
 * using one by one rotation - O(n*d) Time and O(1) Space
 */

// Solution: Using Reversal Algorithm - O(n) Time and O(1) Space
class Solution {
	public void rotateArr(int arr[], int d) {
		// code here
		int n = arr.length;
		// To avoid, ArrayIndex Out of bound, if d > n
		d = d%n;
		
		// Reverse the sub-Array of length d
		reverse(arr, 0, d - 1);
		
		//Reverse remaining array
		reverse(arr, d, n - 1);
		
		//Reverse the full array
		reverse(arr, 0, n - 1);
	}
	
	public void reverse(int arr[], int left, int right) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}
