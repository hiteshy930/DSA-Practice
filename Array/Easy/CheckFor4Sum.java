
/**
 * Given an integer array arr[] and an integer x, determine whether there exist four distinct elements in the array whose sum is equal to x.
 *
 * Return true if such four elements exist. Otherwise, return false.
 *
 * Examples:
 *
 * Input: arr[] = [1, 5, 1, 0, 6, 0], x = 7
 * Output: true
 * Explanation: The four elements 1, 5, 1, 0 have a sum equal to 7.
 * Input: arr[] = [1, 2, 3, 4, 5], x = 50
 * Output: false
 * Explanation: No combination of four distinct elements has a sum equal to 50.
 * Constraints:
 *
 * 0 ≤ x ≤ 109
 * 4 ≤ arr.size() ≤ 103
 * 0 ≤ arr[i] ≤ 106
 */

/**
 * Solution: Using a HashSet to store the sums of pairs of elements in the array.
 * For each pair of elements, we check if the complement (x - sum of the pair) exists
 * in the HashSet. If it does, we return true. Otherwise, we add the sum of the current
 * pair to the HashSet and continue checking for other pairs.
 *
 * Time Complexity: O(n^2), where n is the length of the array. We are iterating through
 * the array twice to check for pairs and store their sums in the HashSet.
 * Space Complexity: O(n^2), as we are using a HashSet to store the sums of pairs of
 * elements in the array.
 */
import java.util.HashSet;

class CheckFor4Sum {

    public boolean fourSum(int[] arr, int x) {
        int n = arr.length;
        HashSet<Long> pairSums = new HashSet<>();

        for (int i = 1; i < n - 1; i++) {

            // Check pairs using arr[i] as the third element.
            for (int j = i + 1; j < n; j++) {
                long required = (long) x - arr[i] - arr[j];

                if (pairSums.contains(required)) {
                    return true;
                }
            }

            // Add pairs ending at i only after checking.
            // This ensures all four indices are distinct.
            for (int k = 0; k < i; k++) {
                pairSums.add((long) arr[k] + arr[i]);
            }
        }

        return false;
    }
}
