/**
 * Given an array arr[]. Find the elements whose value is equal to the position
 * where they appear.
 * 
 * Note: There can be more than one element in the array which have the same
 * value as its position. You need to include the position of every such
 * element.
 * 
 * Examples:
 * 
 * Input: arr[] = [15, 2, 45, 4, 7]
 * Output: [2, 4]
 * Explanation: Here, arr[2] = 2 exists here and arr[4] = 4 exists.
 * Input: arr[] = [1]
 * Output: [1]
 * Explanation: Here arr[1] = 1 exists.
 * Constraints:
 * 1 ≤ arr.size ≤ 105
 * 1 ≤ arr[i] ≤ 106
 */

/**
 * Solution:
 * 1. Create an empty ArrayList to store the elements whose value is equal to their position.
 * 2. Iterate through the array and for each element, check if its value is equal
 * to its position (i.e., arr[i] == i + 1).
 * 3. If the condition is true, add the element to the ArrayList.
 * 4. Return the ArrayList containing the elements whose value is equal to their position.
 * 
 */
import java.util.ArrayList;
class valueEqualToPosition {
	public static ArrayList<Integer> valEqualToPos(int[] arr) {
		// code here
		int n = arr.length;
		
		ArrayList<Integer> temp = new ArrayList<>();
		
		for (int i = 0; i<n; i++) {
			if (arr[i] == i + 1) {
				temp.add(arr[i]);
			}
		}
		
		return temp;
	}
}
