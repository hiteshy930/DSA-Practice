/**
 * Given an array arr. Return the element that occurs at least k number of
 * times.
 * 
 * Note:
 * 
 * If there are multiple answers, please return the first one.
 * If there is no element found, return -1.
 * Examples
 * 
 * Input: arr[] = [1, 7, 4, 3, 4, 8, 7], k = 2
 * Output: 4
 * Explanation: Both 7 and 4 occur 2 times. But 4 is first that occurs twice. As
 * the index = 4, is the first element.
 * Input: arr[] = [3, 1, 3, 4, 5, 1, 3, 3, 5, 4], k = 3
 * Output: 3
 * Explanation: Here, 3 is the only number that appeared atleast 3 times in the
 * array.
 * Input: arr[] = [10, 8, 2], k = 10
 * Output: -1
 * Explanation: Here no element is returning atleast 10 number of times, so -1.
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * 1 ≤ k ≤ 103
 * 0 ≤ arr[i] ≤ 106
 */

/**
 * Solution: 
 * 1. Create a HashMap to store the count of each element in the array.
 * 2. Iterate through the array and for each element, check if it is already in
 * the HashMap. If it is, increment its count by 1. If it is not, add it to the
 * HashMap with a count of 1.
 * 3. After that, check if the count of the current element is greater than or equal
 * to k. If it is, return the current element as the answer.
 * 4. If no element is found that occurs at least k times, return -1.
 * 5. The time complexity of this solution is O(n) and the space complexity is O(n)
 * as we are using a HashMap to store the count of each element in the array.
 */
import java.util.HashMap;
class AtLeastKOcuurence {
	public int firstElementKTime(int[] arr, int k) {
		// write code
		int n = arr.length;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		if (k>n)
			return - 1;
		
		int first_occurence = -1;
		boolean isFirstOccurenceFounded = false;
		
		for (int num : arr) {
			int count = 1;
			if (map.containsKey(num)) {
				count += map.get(num);
				map.put(num, count);
			} else {
				map.put(num, count);
			}
			
			//Set first element which meet the condition 
			if (map.get(num) >= k && isFirstOccurenceFounded == false) {
				first_occurence = num;
				isFirstOccurenceFounded = true;
			}
		}
		
		return first_occurence;
	}
}
