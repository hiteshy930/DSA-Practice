
/**
 * Given an array arr[], find the first repeating element index. The element
 * should occur more than once and the index of its first occurrence should be
 * the smallest.
 * 
 * Note:- The position you return should be according to 1-based indexing.
 * 
 * Examples:
 * 
 * Input: arr[] = [1, 5, 3, 4, 3, 5, 6]
 * Output: 2
 * Explanation: 5 appears twice and its first appearance is at index 2 which is
 * less than 3 whose first the occurring index is 3.
 * Input: arr[] = [1, 2, 3, 4]
 * Output: -1
 * Explanation: All elements appear only once so answer is -1.
 * 
 * Constraints:
 * 
 * 1 ≤ arr.size() ≤ 106
 * 0 ≤ arr[i] ≤ 106
 * 
 */

/**
 * Solution: Use a hashmap to store the elements of the array and their first occurrence 
 * index. Iterate through the array and check if the element is already present in the 
 * hashmap. If it is, update the minimum index of the first occurrence. If it is not, add
 * it to the hashmap with its index. Finally, 
 * return the minimum index found or -1 if no repeating element was found.
 * 
 */
import java.util.HashMap;

class FirstRepeatingElementIndex {
    public int firstRepeated(int[] arr) {
        int n = arr.length;
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int min_index = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (map.containsKey(arr[i])) {
                // check if current element index is less than min_index
                min_index = Math.min(min_index, map.get(arr[i]));
            } else {
                map.put(arr[i], i + 1);
            }
        }
        // If min_index never changes then it will be equal to MAX_VALUE
        return (min_index == Integer.MAX_VALUE) ? -1 : min_index;
    }
}
