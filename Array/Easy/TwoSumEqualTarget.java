/**
 * Given an array arr[] of integers and another integer target. Determine if
 * there exist two distinct indices such that the sum of their elements is equal
 * to the target.
 * 
 * Examples:
 * 
 * Input: arr[] = [0, -1, 2, -3, 1], target = -2
 * Output: true
 * Explanation: arr[3] + arr[4] = -3 + 1 = -2
 * Input: arr[] = [1, -2, 1, 0, 5], target = 0
 * Output: false
 * Explanation: None of the pair makes a sum of 0
 * Input: arr[] = [11], target = 11
 * Output: false
 * Explanation: No pair is possible as only one element is present in arr[]
 * Constraints:
 * 1 ≤ arr.size ≤ 105
 * -105 ≤ arr[i] ≤ 105
 * -2*105 ≤ target ≤ 2*105
 */

/**
 * Solution: Use a HashMap to store the elements and their indices.
 * For each element, check if the complement (target - current element) exists
 * in the map.
 * If it does, return the indices of the two elements.
 * If not, add the current element and its index to the map.
 */

import java.util.HashSet;
public class TwoSumEqualTarget {
    boolean twoSum(int arr[], int target) {
        // code here
     // Create a HashSet to store the elements
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            // Calculate the complement(The number needed to reach the target.) that added to
            // arr[i], equals the target
            int complement = target - arr[i];

            // Check if the complement exists in the set
            if (set.contains(complement)) {
                return true;
            }

            // Add the current element to the set
            set.add(arr[i]);
        }
        // If no pair is found
        return false;
    }
}
