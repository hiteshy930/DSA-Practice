/**
 * Given two arrays a[] and b[], your task is to determine whether b[] is a subset of a[].

Examples:

Input: a[] = [11, 7, 1, 13, 21, 3, 7, 3], b[] = [11, 3, 7, 1, 7]
Output: true
Explanation: b[] is a subset of a[]
Input: a[] = [1, 2, 3, 4, 4, 5, 6], b[] = [1, 2, 4]
Output: true
Explanation: b[] is a subset of a[]
Input: a[] = [10, 5, 2, 23, 19], b[] = [19, 5, 3]
Output: false
Explanation: b[] is not a subset of a[]
Constraints:
1 <= a.size(), b.size() <= 105
1 <= a[i], b[j] <= 106
 */

/**
 * Solution: 1. Create a HashMap to store the elements of array a[] as keys and their counts as values.
 * 2. Iterate through array b[] and check if each element exists in the HashMap
 * 3. If an element from b[] does not exist in the HashMap, return false.
 * 4. If all elements of b[] exist in the HashMap, return true
 */
class Solution {
	public boolean isSubset(int a[], int b[]) {
		// Create a hash set and insert all elements of a
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (Integer num : a) {
			if (hashMap.containsKey(num)) {
				hashMap.put(num, hashMap.get(num) + 1);
			} else {
				hashMap.put(num, 1);
			}
		}
		
		// Check each element of b in the hash set
		for (Integer num : b) {
			if (!hashMap.containsKey(num)) {
				return false;
			} else {
				if (hashMap.get(num) <= 0) {
					return false;
				}
				hashMap.put(num, hashMap.get(num) - 1);
			}
		}
		
		// If all elements of b are found in the hash set
		return true;
		
	}
}
