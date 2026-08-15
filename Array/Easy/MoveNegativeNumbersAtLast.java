/**
 * Given an unsorted array arr[ ] having both negative and positive integers. Place all negative elements at the end of the array without changing the order of positive elements and negative elements.
 *
 * Note: Don't return any array, just in-place on the array.
 *
 * Examples:
 *
 * Input : arr[] = [1, -1, 3, 2, -7, -5, 11, 6 ]
 * Output : [1, 3, 2, 11, 6, -1, -7, -5]
 * Explanation: By doing operations we separated the integers without changing the order.
 *
 * Input : arr[] = [-5, 7, -3, -4, 9, 10, -1, 11]
 * Output : [7, 9, 10, 11, -5, -3, -4, -1]
 *
 * Constraints:
 * 1 ≤ arr.size ≤ 10^6
 * -10^9 ≤ arr[i] ≤ 10^9
 */
/**
 * Solution: 
 * 1. use two arraylist to store positive and negative numbers and then combine them in the original array.
 * 2. use a two-pointer approach to rearrange the elements in-place.
 * 
 */
import java.util.ArrayList;
class MoveNegativeNumbersAtLast {
	public void segregateElements(int[] arr) {
		// code here
		int n = arr.length;
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		for (int i = 0; i<n; i++) {
			if (arr[i] >= 0) {
				temp1.add(arr[i]);
			} else {
				temp2.add(arr[i]);
			}
		}
		
		for (int i = 0; i<temp1.size(); i++) {
			arr[i] = temp1.get(i);
		}
		
		int m = temp1.size();
		for (int i = 0; i<temp2.size(); i++) {
			arr[m] = temp2.get(i);
			m++;
		}
		
	}
}
