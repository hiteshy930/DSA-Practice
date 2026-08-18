/**
 * Find the first non-repeating element in a given array arr of integers and if
 * there is not present any non-repeating element then return 0
 * 
 * Note: The array consists of only positive and negative integers and not zero.
 * 
 * Examples:
 * 
 * Input: arr[] = [-1, 2, -1, 3, 2]
 * Output: 3
 * Explanation: -1 and 2 are repeating whereas 3 is the only number occuring
 * once. Hence, the output is 3.
 * Input: arr[] = [1, 1, 1]
 * Output: 0
 * Explanation: There is not present any non-repeating element so answer should
 * be 0.
 * Constraints:
 * 1 <= arr.size <= 106
 * -109 <= arr[i] <= 109
 * arr[i] != 0
 */

/**
 * sOLUTION:
 * 1. Create a HashMap to store the count of each element in the array.
 * 2. Iterate through the array and for each element, check if it is already in
 * the HashMap. If it is, increment its count by 1. If it is
 * not, add it to the HashMap with a count of 1.
 * 3. After that, iterate through the array again and check if the count of the
 * current element is equal to 1. If it is, return the current element as the
 * answer.
 * 4. If no element is found that occurs only once, return 0.
 */
import java.util.HashMap;
import java.util.Map;
class NonRepeatingNumber {
    public int firstNonRepeating(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        // Count occurrences
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // Find FIRST non-repeating element
        for (int num : arr) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return 0;
    }
}