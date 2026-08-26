/**
 * Given an array arr[] containing equal number of positive and negative elements, arrange the array such that every positive element is followed by a negative element. The relative order of positive and negative numbers should be maintained.

 *  *Examples:

 *  *Input: arr[] = [-1, 2, -3, 4, -5, 6]
 * Output: [2, -1, 4, -3, 6, -5]
 * Explanation: Positive numbers in their original order are 2, 4, 6, and negative numbers are -1, -3, -5. Placing them alternately starting with a positive element gives [2, -1, 4, -3, 6, -5].
 * Input: arr[] = [-3, 2, -4, 1]
 * Output: [2, -3, 1, -4]
 * Explanation: Positive numbers in order are 2, 1, and negative numbers are -3, -4. Arranging them alternately results in [2, -3, 1, -4].
 * Constraints:
 * 2 ≤ arr.size() ≤ 105
 * -106 ≤ arr[i] ≤ 106
 */

/**
 * Solution: 
 * Approach: Two ArrayList Separation with Two-Pointer Merge
 * 
 * 1. Create two separate ArrayLists to store positive and negative numbers
 * 2. Iterate through the input array and separate numbers into respective lists
 * 3. Use two pointers to alternate between positive and negative elements
 * 4. Add remaining elements from whichever list still has elements
 * 
 * Time Complexity: O(n) - single pass to separate + single pass to merge
 * Space Complexity: O(n) - for storing positive and negative ArrayLists
 * 
 * Advantages:
 * - Simple and easy to understand
 * - Maintains relative order of positive and negative numbers
 * - Handles unequal distribution gracefully (though problem states equal count)
 */
import java.util.ArrayList;
class PositiveAndNegativeAlternative {
    public ArrayList<Integer> arranged(int[] arr) {

        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        // Separate while maintaining relative order
        for (int num : arr) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        // Alternate while both are available
        while (i < positive.size() && j < negative.size()) {

            result.add(positive.get(i++));
            result.add(negative.get(j++));
        }

        // Add remaining elements
        while (i < positive.size()) {
            result.add(positive.get(i++));
        }

        while (j < negative.size()) {
            result.add(negative.get(j++));
        }

        return result;
    }
}