/**
 * You are given a sorted array arr[] that may contain duplicate elements. Your
 * task is to find the index of the last occurrence of any duplicate element and
 * return the index along with the value of that element. If no duplicate
 * element is found, return [-1, -1].
 * 
 * Examples :
 * 
 * Input: arr[] = [1, 5, 5, 6, 6, 7]
 * Output: [4, 6]
 * Explanation: Last duplicate element is 6 having index 4.
 * Input: arr[] = [1, 2, 3, 4, 5]
 * Output: [-1, -1]
 * Explanation: No duplicate elements are present in the array.
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * 1 ≤ arr[i] ≤ 106
 */

/**
 * Solution explanation: using XOR operation
 * 1. Initialize two variables lastDuplicate and lastDuplicateIndex to -1.
 * 2. Iterate through the array from index 0 to n-2 (where n is the length of the array).
 * 3. For each element, check if it is equal to the next element using XOR operation.
 * 4. If they are equal, update lastDuplicate and lastDuplicateIndex with the current element and its index.
 * 5. After the loop, return an array containing lastDuplicateIndex and lastDuplicate.
 */
class LastDuplicateInArray {
	public int[] dupLastIndex(int[] arr) {
		// Complete the function
		int n = arr.length;
		int lastDuplicate = -1;
		int lastDuplicateIndex = -1;
		int temp[] = new int[2];
		
		for (int i = 0; i<n - 1; i++) {
			
			int result = arr[i] ^ arr[i + 1];
			
			if (result == 0) {
				lastDuplicate = arr[i];
				lastDuplicateIndex = i + 1;
			}
		}
		
		temp[0] = lastDuplicateIndex;
		temp[1] = lastDuplicate;
		
		return temp;
	}
}
