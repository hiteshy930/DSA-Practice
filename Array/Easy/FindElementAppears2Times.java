/**
 * Given an array arr[] of size n, containing elements from the range 1 to n,
 * and each element appears at most twice, return an array of all the integers
 * that appears twice.
 * 
 * Note: You can return the elements in any order but the driver code will print
 * them in sorted order.
 * 
 * Examples:
 * 
 * Input: arr[] = [2, 3, 1, 2, 3]
 * Output: [2, 3]
 * Explanation: 2 and 3 occur more than once in the given array.
 * Input: arr[] = [3, 1, 2]
 * Output: []
 * Explanation: There is no repeating element in the array, so the output is
 * empty.
 * Constraints:
 * 1 ≤ n ≤ 106
 * 1 ≤ arr[i] ≤ n
 */

/**
 * Solution:
 * Using hashmap to store the frequency of each element and then return the
 * elements with frequency 2.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class Solution {
	public ArrayList<Integer> findDuplicates(int[] arr) {
		// code here
		Map<Integer, Integer> hashMap = new HashMap();
		ArrayList<Integer> temp = new ArrayList();
		for (int num : arr) {
			if (hashMap.containsKey(num)) {
				hashMap.put(num, hashMap.get(num) + 1);
				//add the number to the result list if it appears twice
				if (hashMap.get(num) == 2) {
					temp.add(num);
				}
			} else {
				hashMap.put(num, 1);
			}
			
		}
		
		return temp;
	}
}
