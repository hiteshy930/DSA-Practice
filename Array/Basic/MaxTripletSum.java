/**
 * Finds the maximum sum of any three elements in an array.
 *
 * Examples:
 *
 * Input: arr[] = [4, 2, 7, 9]
 * Output: 20
 * Explanation: 4 + 7 + 9 = 20
 *
 * Input: arr[] = [1, 0, 8, 6, 4, 2]
 * Output: 18
 * Explanation: 8 + 6 + 4 = 18
 *
 * Input: arr[] = [2, 2, 1, 1]
 * Output: 5
 * Explanation: 2 + 2 + 1 = 5
 *
 * Constraints:
 * - 3 <= arr.length <= 10^6
 * - -10^5 <= arr[i] <= 10^5
 */
/**
 * Solution explanation: using sorting
 * 1. Sort the array in ascending order.
 * 2. The maximum sum of any three elements will be the sum of the last three
 * elements in the sorted array.
 * 3. Return the sum of the last three elements.
 * 
 * Time Complexity: O(n log n) where n is the size of the array due to sorting.
 * Space Complexity: O(1) if we sort in place, otherwise O(n) for storing the sorted array.
 * 
 */
import java.util.Collections;
import java.util.List;
class MaxTripletSum {
    public int maxTripletSum(List<Integer> arr) {
        // Code Here
        int n = arr.size();
        Collections.sort(arr);
        return arr.get(n-1) + arr.get(n-2) + arr.get(n-3);
    }
}
