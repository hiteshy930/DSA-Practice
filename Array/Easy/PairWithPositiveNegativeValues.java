/**
 * Given an array of integers, return all the elements such that both the positive and negative values of a number exist in the array. The order of elements in the output should be based on the order of first appearance of any element in a pair in input. For example, in a pair (x, y) if any of x or y appear first in the input array, then the whole pair will appear first.
 * 
 * Note : If no such pair exists, simply return an empty array, also multiple pairs of the same number could exist and you need to put each of them in the array. 
 * 
 * Examples:
 * 
 * Input: arr[] = [1, -3, 2, 3, 6, -1, -3, 3]
 * Output: [1, -1, -3, 3, 3, -3]
 * Explanation: The array is traversed from left to right, and whenever a number is found whose positive or negative counterpart also exists and has not already been used, both are added to the result. This ensures that pairs are formed in the same order as they appear in the input array, giving the output [1, -1, -3, 3, 3, -3]
 * Input: arr[] = [4, 8, 9, -4, 1, -1, -8, -9]
 * Output: [4, -4, 8, -8, 9, -9, 1, -1]
 * Explanation: The array is traversed from left to right, and whenever a number is found whose positive or negative counterpart also exists and has not already been used, both are added to the result. This ensures that pairs are formed in the same order as they appear in the input array, giving the output [4, -4, 8, -8, 9, -9, 1, -1]
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * -105 ≤ arr[i] ≤ 105
 */

/**
 * Solution: Using HashMap
 * 1. Create a HashMap to store the frequency of each number in the array.
 * 2. Iterate through the array and for each number, check if its positive or negative
 *    counterpart exists in the HashMap and has a positive count.
 * 3. If both the number and its counterpart exist, add them to the result list and 
 *    decrement their counts in the HashMap.
 * 4. Continue this process until the end of the array is reached.
 * 5. Return the result list containing all the pairs found.
 * 
 * Time Complexity: O(n), where n is the size of the input array. 
 * We traverse the array once to build the frequency map and once more to 
 * find the pairs.
 * Space Complexity: O(n), as we are using a HashMap to store the frequency of 
 * each number in the array.
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;
class PairWithPositiveNegativeValues {
    public List<Integer> posNegPair(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        // Count the frequency of each number in the array
        for (int num : arr) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }

        for (int num : arr) {
            if (num == 0) {
                continue;
            }

            int opposite = -num;
            // Check if both the number and its opposite exist in the frequency map 
            // and have a positive count
            if (freq.containsKey(num) && freq.containsKey(opposite)
                    && freq.get(num) > 0 && freq.get(opposite) > 0) {

                result.add(num);
                result.add(opposite);

                freq.put(num, freq.get(num) - 1);
                freq.put(opposite, freq.get(opposite) - 1);
            }
        }

        return result;
    }
}