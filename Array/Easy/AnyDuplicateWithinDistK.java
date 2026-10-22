
/**
 * Given an unsorted array arr[] and an integer k, check if there is any duplicate within k distance.
 *
 * Examples:
 *
 * Input: arr[] = [1, 5, 4, 5, 1], k = 3
 * Output: true
 * Explanation: 5 is at distance 2 which is less than or equal to k.
 * Input: arr[] = [10, 2, 3, 4, 10, 5], k = 3
 * Output: false
 * Explanation: Only one duplicate 10 at distance 4 which is more than 3.
 * Input: arr[] = [6, 8, 4, 1, 8, 5, 7], k = 3
 * Output: true
 * Explanation: 8 is repeated at distance 3.
 * Constraints:
 *
 * arr.size() ≤ 106
 * 1 ≤ arr[i] ≤ 105
 * 1 ≤ k < arr.size()
 */

/**
 * Solution: Using a HashMap to store the elements of the array and their corresponding
 * indices. For each element in the array, we check if it is already present in the HashMap.
 * If it is, we check if the distance between the current index and the stored index is
 * less than or equal to k. If it is, we return true. Otherwise, we update the index of
 * the current element in the HashMap. If the element is not present in the HashMap,
 * we add it along with its index.
 *
 * Time Complexity: O(n), where n is the length of the array. We are iterating through
 * the array once and performing constant time operations for each element.
 * Space Complexity: O(n), as we are using a HashMap to store the elements of the array
 * and their corresponding indices.
 *
 */
import java.util.HashMap;

class AnyDuplicateWithinDistK {

    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            // check if the current element is already present in the map
            if (map.containsKey(arr[i])) {
                if ((i - map.get(arr[i])) <= k) {
                    return true;
                } else {
                    // update the index of the current element in the map
                    map.put(arr[i], i);
                }
            } else {
                // add the current element and its index to the map
                map.put(arr[i], i);
            }
        }

        return false;
    }
}
