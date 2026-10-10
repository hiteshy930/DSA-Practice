/**
 * You are given an array arr[] of integers. Find all the numbers in the array whose digits consist only of [1, 2, 3].
 * 
 * The order of the numbers in the output array should be the same as their order in the input array.
 * If there is no such element in arr[]. Return [-1].
 * Examples:
 * 
 * Input: arr[] = [14, 31, 7]
 * Output: [31]
 * Explanation: Only 31 has all digits in set {1, 2, 3}
 * Input: arr[] = [1, 2, 13, 4] 
 * Output: [1, 2, 13]
 * Explanation: 1, 2 and 13 are the only elements which contain digits in {1, 2, 3}
 * Input: arr[] = [56, 51, 7]
 * Output: [-1]
 * Explanation: No number has all digits in set {1, 2, 3}
 * Constraints:
 * 
 * 1 ≤ arr.size() ≤ 105
 * 1 ≤ arr[i] ≤ 106
 */

/**
 * Solution: Using ArrayList
 * 1. Create an ArrayList to store the result.
 * 2. Iterate through the input array and for each number, check if all its digits
 *   are in the set {1, 2, 3}.
 * 3. If a number satisfies the condition, add it to the result list.
 * 4. If no such number is found, add -1 to the result list.
 * 5. Return the result list.
 * 
 * Time Complexity: O(n * d), where n is the size of the input array and d is 
 * the number of digits in the largest number.
 * Space Complexity: O(n), as we are using an ArrayList to store the result.
 */
import java.util.ArrayList;
class NumberContaining123 {
    public ArrayList<Integer> filterByDigits(int[] arr) {
      ArrayList<Integer> result = new ArrayList<>();

             for (int num : arr) {
                 int n = num;
                 boolean valid = true;

                 while (n > 0) {
                     int digit = n % 10;

                     if (digit < 1 || digit > 3) {
                         valid = false;
                         break;
                     }

                     n /= 10;
                 }

                 if (valid) {
                     result.add(num);
                 }
             }

             if (result.isEmpty()) {
                 result.add(-1);
             }

             return result;
    }
}
